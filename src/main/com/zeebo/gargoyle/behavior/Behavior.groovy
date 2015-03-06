package com.zeebo.gargoyle.behavior

import com.zeebo.gargoyle.gameobject.GameObject

/**
 * User: Eric
 */
class Behavior {

	GameObject gameObject

	static Map<Class<? extends Behavior>, Map<String, List>> registrationDefs = [:].withDefault {
		discoverResgistration(it)
	}

	final void setGameObject(GameObject go) {
		gameObject = go

		if (go) {
			println "Do registration $go: ${this.class}"
			doRegistration()
		}
		else {
			doUnregistration()
		}
	}

	private final void doRegistration() {
		registrationDefs[this.class].each { String action, value ->
			BehaviorManager.register(this, action)
		}
	}

	private final void doUnregistration() {
		registrationDefs[this.class].each { String action, value ->
			BehaviorManager.unregister(this, action)
		}
	}

	private static final def discoverResgistration(Class klass) {

		Class clazz = klass
		def methods = [:]

		while (clazz != Behavior) {
			clazz.declaredMethods.findAll { !methods.containsKey(it.name) && it.name.startsWith('on') }.each {
				methods[it.name] = [it, it.parameterCount > 0 && it.parameterTypes[0] == float]
			}
			clazz = clazz.superclass
		}

		return methods.collectEntries { String name, value -> ["${name[2].toLowerCase()}${name.substring(3)}".toString(), value] }
	}
}