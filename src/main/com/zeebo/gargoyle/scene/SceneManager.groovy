package com.zeebo.gargoyle.scene

import com.zeebo.gargoyle.behavior.Render
import com.zeebo.gargoyle.gameobject.GameObject
import com.zeebo.gargoyle.prefab.Prefab
import com.zeebo.gargoyle.prefab.PrefabManager
import com.zeebo.gargoyle.util.ScriptCategory

/**
 * User: Eric
 */
class SceneManager {

	static Map<String, Scene> scenes = [:] as LinkedHashMap<String, Scene>

	static {
		SceneManager.metaClass.static.propertyMissing = { String key ->
			scenes[key]
		}
	}

	static void loadScene(String name, Reader reader) {
		if (!scenes[name]) {
			scenes[name] = new Scene()

			Stack<GameObject> scene = new Stack<>()

			SceneLoader loader = new SceneLoader()

			GroovyShell shell = new GroovyShell()
			def script = shell.parse(reader)

			use(ScriptCategory) {
				script.delegateTo loader
			}

			script.run()

			scenes[name].sceneGraph = loader.objects.peek()

			println scenes[name].sceneGraph.toHierarchy()
		}
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
		objects.push new GameObject(name: 'sceneGraph')
		c()
	}

	def methodMissing(String name, args) {
		GameObject go = name == 'gameObject' ? new GameObject() : PrefabManager[name].newGameObject()
		go.name = args[0]
		objects.peek().children << go

		if (args.size() > 1) {
			args = args[1..-1]

			if (args[-1] instanceof Closure) {
				objects.push go
				args[-1]()
				objects.pop()

				args = args[0..<-1]
			}

			if (args) {
				['position', 'rotation', 'scale'][0..<args.size()].reverse().eachWithIndex { it, idx ->
					go."$it" = args[-(idx + 1)]
				}
			}
		}
	}
}