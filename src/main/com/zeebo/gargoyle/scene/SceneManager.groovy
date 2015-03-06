package com.zeebo.gargoyle.scene

import com.zeebo.gargoyle.behavior.Render
import com.zeebo.gargoyle.gameobject.GameObject
import com.zeebo.gargoyle.prefab.Prefab
import com.zeebo.gargoyle.prefab.PrefabManager
import com.zeebo.gargoyle.util.ScriptCategory
import org.lwjgl.util.vector.Matrix4f
import org.lwjgl.util.vector.Vector3f

/**
 * User: Eric
 */
class SceneManager {

	static Map<String, Reader> scenes = [:] as LinkedHashMap<String, Reader>

	static {
		SceneManager.metaClass.static.propertyMissing = { String key ->
			scenes[key]
		}
	}

	static Scene loadScene(String name, Reader reader) {
		Scene scene = new Scene()

		SceneLoader loader = new SceneLoader()

		GroovyShell shell = new GroovyShell()
		def script = shell.parse(reader)

		use(ScriptCategory) {
			script.delegateTo loader
		}

		script.run()

		scene.sceneGraph = loader.objects.peek()

		return scene
	}

	static Scene getAt(def key) {
		return scenes[key]
	}

	public static void main(String[] args) {
		PrefabManager.prefabs['quad'] = new Prefab(name: 'quad', behaviors: [(Render): {}])
		SceneManager.loadScene('scene1', new File('example/scenes/scene1.scene').newReader())
	}
}

class SceneLoader {

	Stack<GameObject> objects = new Stack<>()

	def sceneGraph(Closure c) {
		GameObject go = new GameObject()
		go.name = 'sceneGraph'
		objects.push go
		c()
	}

	def methodMissing(String name, args) {
		args = args as List
		GameObject go = name == 'gameObject' ? new GameObject() : PrefabManager[name].newGameObject()
		go.name = args.remove(0)
		objects.peek().transform.children << go.transform
		go.transform.parent = objects.peek().transform

		if (!args.empty) {
			if (args[-1] instanceof Closure) {
				objects.push go
				args[-1]()
				objects.pop()

				args = args[0..<-1]
			}

			if (!args.empty) {
				Matrix4f mat = new Matrix4f()
				mat.setIdentity()
				if (!args.empty) {
					mat.translate(new Vector3f(*args.remove(0)))
				}
				if (!args.empty) {
					Vector3f rotate = new Vector3f(*args.remove(0))
					mat.rotate(rotate.x, new Vector3f(1, 0, 0))
					mat.rotate(rotate.y, new Vector3f(0, 1, 0))
					mat.rotate(rotate.z, new Vector3f(0, 0, 1))
				}
				if (!args.empty) {
					mat.scale(new Vector3f(*args.remove(0)))
				}
				go.transform << mat
			}
		}
	}
}