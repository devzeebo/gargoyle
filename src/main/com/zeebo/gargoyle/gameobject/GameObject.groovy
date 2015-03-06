package com.zeebo.gargoyle.gameobject

import com.zeebo.gargoyle.behavior.Behavior
import com.zeebo.gargoyle.behavior.Transform
import org.lwjgl.util.vector.Matrix4f
import org.lwjgl.util.vector.Vector3f

/**
 * User: Eric
 */
final class GameObject {

	final Transform transform = new Transform()

	String name

	def behaviors = new LinkedHashMap<Class, Behavior>()

	GameObject() {
		transform.setIdentity()
		addBehavior transform
	}

	GameObject(GameObject parent) {
		this()

		transform.parent = parent.transform
		parent.transform.children << this
	}

	GameObject clone(GameObject other) {
		transform.parent = other.transform.parent
		transform << other.transform

		for (int i = 0; i < other.transform.children.size(); i++) {
			GameObject child = new GameObject()
			child.clone(other.transform.children[i].gameObject)
		}

		return this
	}

	public <T extends Behavior> T getAt(Class<T> behavior) {
		return behaviors[behavior]
	}

	void addBehavior(Behavior b) {
		if (behaviors[b.class]) {
			behaviors[b.class].gameObject = null
		}
		behaviors[b.class] = b
		b.gameObject = this
	}

	void eachChild(Closure operation) {
		operation(this)

		transform.children*.gameObject*.eachChild(operation)
	}

	String toHierarchy(int depth = 0) {
		StringBuilder hierarchy = new StringBuilder()

		hierarchy.append( '\t' * depth + name + '\n')
		transform.children.each {
			hierarchy.append it.gameObject.toHierarchy(depth + 1)
		}

		return hierarchy.toString()
	}
}