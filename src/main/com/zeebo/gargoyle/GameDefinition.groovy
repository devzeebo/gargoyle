package com.zeebo.gargoyle

import com.zeebo.gargoyle.behavior.Render
import com.zeebo.gargoyle.behavior.camera.Camera
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

	Camera camera = new Camera()

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

	Stack delegates = new Stack()
	Stack<Closure> methodMissings = new Stack<>()

	GameDefinitionLoader() {
		delegates.push this
	}

	// https://jira.codehaus.org/browse/GROOVY-4862
	def methodMissing(String name, args) {
		if (args.size() == 1 && args[0] != null && args[0] instanceof Closure) {

			String className = "${delegates.peek().class.name}\$${name.capitalize()}"
			def del = Class.forName(className).newInstance(delegates.peek())

			delegates.push del
			args[0].delegate = del
			boolean useMethodMissing = del.respondsTo('handleMethodMissing')
			if (useMethodMissing) {
				methodMissings.push del.&handleMethodMissing
			}
			args[0]()
			if (del.respondsTo('onComplete')) {
				del.onComplete()
			}
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

		class ShaderRenderer {

			Reader vertex
			Reader fragment
			Map attrLocs
			def uniforms

			def vertex(def shader) {
				vertex = getResourceAsReader shader
			}

			def fragment(def shader) {
				fragment = getResourceAsReader shader
			}

			def vertexBindings(def map) {
				attrLocs = map
			}

			def uniformLocations(String... names) {
				uniforms = names
			}

			def onComplete() {
				definition.renderer = new com.zeebo.gargoyle.render.ShaderRenderer(vertex, fragment, attrLocs, uniforms)
			}
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
			SceneManager.scenes[name] = getResourceAsReader(args[0])
		}
	}

	def getResourceAsReader(def res) {
		if (res instanceof Reader) {
			return res
		}
		return new BufferedReader(new InputStreamReader(GameDefinitionLoader.class.getResourceAsStream(res)))
	}
}
