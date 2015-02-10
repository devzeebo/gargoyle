package com.zeebo.gargoyle

import com.zeebo.gargoyle.behavior.Render
import com.zeebo.gargoyle.example.ExampleGameDefinition
import com.zeebo.gargoyle.gameobject.GameObject
import com.zeebo.gargoyle.mesh.MeshManager
import com.zeebo.gargoyle.pool.ObjectPool
import com.zeebo.gargoyle.prefab.Prefab
import com.zeebo.gargoyle.prefab.PrefabManager
import com.zeebo.gargoyle.render.Renderer
import com.zeebo.gargoyle.render.SimpleRenderer
import com.zeebo.gargoyle.scene.SceneManager
import com.zeebo.gargoyle.util.ScriptCategory

/**
 * User: Eric
 */
class GameDefinition {

	Renderer renderer = new SimpleRenderer()

	String startScene

	static GameDefinition load(Reader scriptSource) {

		GameDefinitionLoader loader = new GameDefinitionLoader()

		Script script = new ExampleGameDefinition()

//		GroovyShell shell = new GroovyShell()
//		def script = shell.parse(scriptSource)

		use(ScriptCategory) {
			script.delegateTo loader
		}

		script.run()

		return loader.definition
	}
}

class GameDefinitionLoader {

	GameDefinition definition = new GameDefinition()

	def delegates = new LinkedList()
	Stack<Closure> methodMissings = new Stack<>()

	// https://jira.codehaus.org/browse/GROOVY-4862
	def methodMissing(String name, args) {
		if (args.size() == 1 && args[0] != null && args[0] instanceof Closure) {

			String className = "${delegates.peek()?.class?.name ?: GameDefinitionLoader.name}\$${name.capitalize()}"
			def del = Class.forName(className).newInstance(this)

			delegates.push del
			args[0].delegate = del
			boolean useMethodMissing = del.respondsTo('handleMethodMissing')
			if (useMethodMissing) {
				methodMissings.push del.&handleMethodMissing
			}
			args[0]()
			if (useMethodMissing) {
				methodMissings.pop()
			}
			delegates.pop()
		}
		else {
			println "$name $args"
			methodMissings.peek()(name, args)
		}
	}

	class Definition {

		def pooledObjects(def pooledObjects) {
			pooledObjects = pooledObjects ?: []
			pooledObjects.addAll([GameObject, Render])
			pooledObjects.unique().each {
				ObjectPool.usePoolForClass(it)
			}
		}

		def renderer(def renderer) {
			definition.renderer = renderer
		}

		def startScene(String sceneName) {
			definition.startScene = sceneName
		}
	}

	class Meshes {
		def handleMethodMissing(String name, args) {
			MeshManager.loadMesh name, args[0], args[1]
		}
	}

	class Prefabs {
		def handleMethodMissing(String name, args) {
			Prefab prefab = new Prefab(name: name, behaviors: args[0])
			PrefabManager.prefabs[name] = prefab
		}
	}

	class Scenes {
		def handleMethodMissing(String name, args) {
			SceneManager.loadScene name, new File(args[0]).newReader()
		}
	}
}
