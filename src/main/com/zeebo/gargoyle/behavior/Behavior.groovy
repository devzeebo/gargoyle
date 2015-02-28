package com.zeebo.gargoyle.behavior

import com.zeebo.gargoyle.gameobject.GameObject

/**
 * User: Eric
 */
class Behavior {

	GameObject gameObject

	static def registrationDefs = [:].withDefault {
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
		registrationDefs[this.class].each { String action ->
			BehaviorManager.register(this, action)
		}
	}

	private final void doUnregistration() {
		registrationDefs[this.class].each { String action ->
			BehaviorManager.unregister(this, action)
		}
	}

	private static final def discoverResgistration(Class klass) {

		Class clazz = klass
		def methods = [] as HashSet

		while (clazz != Behavior) {
			clazz.declaredMethods.findAll { it.name.startsWith('on') }.each {
				methods << it.name
			}
			clazz = clazz.superclass
		}

		return methods.collect { String name -> "${name[2].toLowerCase()}${name.substring(3)}" } as List
	}

	void onUpdate() {}
}