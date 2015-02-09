package com.zeebo.gargoyle.prefab

import com.zeebo.gargoyle.behavior.Behavior
import com.zeebo.gargoyle.gameobject.GameObject

/**
 * User: Eric
 */
class Prefab {

	String name

	Map<Class<? extends Behavior>, Closure> behaviors

	def newGameObject() {
		GameObject go = new GameObject()

		behaviors.each { behaviorClass, closure ->
			Behavior behavior = behaviorClass.newInstance()
			closure.delegate = behavior
			closure.resolveStrategy = Closure.DELEGATE_ONLY
			closure()
			go.addBehavior behavior
		}

		return go
	}
}
