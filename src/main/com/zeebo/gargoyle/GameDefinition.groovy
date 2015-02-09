package com.zeebo.gargoyle

import com.zeebo.gargoyle.behavior.Render
import com.zeebo.gargoyle.gameobject.GameObject
import com.zeebo.gargoyle.mesh.MeshManager
import com.zeebo.gargoyle.pool.ObjectPool
import com.zeebo.gargoyle.prefab.Prefab
import com.zeebo.gargoyle.prefab.PrefabManager
import com.zeebo.gargoyle.render.Renderer
import com.zeebo.gargoyle.render.SimpleRenderer

/**
 * User: Eric
 */
class GameDefinition {

	List<Class> pooledObjects = []
	Renderer renderer = new SimpleRenderer()

	static GameDefinition load(Script script) {

		GameDefinitionScriptHelper helper = new GameDefinitionScriptHelper()
		script.metaClass.methodMissing = helper.&methodMissingHelper

		script.run()
		return helper.gameDefinition
	}

	static class GameDefinitionScriptHelper {

		GameDefinition gameDefinition = new GameDefinition()

		Stack<String> mode = new Stack<>()

		def methodMissingHelper(String name, args) {
			if (args[0] instanceof Closure) {
				mode.push name
				if (this.hasProperty(name)) {
					args[0].delegate = this."$name"
					args[0].resolveStrategy = Closure.DELEGATE_FIRST
				}
				args[0]()
				if (name == 'gameDefinition') {
					initialize()
				}
				mode.pop()
			} else {
				switch (mode.peek()) {
					case 'meshes': meshes(name, args); break
					case 'prefabs': prefabs(name, args); break
				}
			}
		}

		def initialize() {
			gameDefinition.pooledObjects.addAll([GameObject, Render])
			gameDefinition.pooledObjects.unique().each {
				ObjectPool.usePoolForClass(it)
			}
		}

		def meshes(String name, args) {
			MeshManager.loadMesh name, args[0], args[1]
		}

		def gameDefinition(String name, args) {

		}

		def prefabs(String name, args) {
			Prefab prefab = new Prefab(name: name, behaviors: args[0])
			PrefabManager.prefabs[name] = prefab
		}
	}
}
