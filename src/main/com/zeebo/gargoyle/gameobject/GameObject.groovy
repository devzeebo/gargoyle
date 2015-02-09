package com.zeebo.gargoyle.gameobject

import com.zeebo.gargoyle.behavior.Behavior
import org.lwjgl.util.vector.Matrix4f

/**
 * User: Eric
 */
final class GameObject {

	final Matrix4f renderTransform = new Matrix4f()
	private boolean dirty = true

	GameObject parent

	Matrix4f transform = new Matrix4f()

	List<GameObject> children = []

	def behaviors = new LinkedHashMap<Class, Behavior>()

	GameObject() {
		transform.setIdentity()
	}

	GameObject(GameObject parent) {
		this()

		this.parent = parent
		parent.children << this
	}

	GameObject clone(GameObject other) {
		parent = other.parent
		transform.load(other.transform)
		dirty = true

		for (int i = 0; i < other.children.size(); i++) {
			GameObject child = new GameObject()
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

	Matrix4f getRenderTransform() {
		if (dirty) {
			eachChildRecursive recalculateRenderTransform
		}

		return renderTransform
	}

	private final def recalculateRenderTransform = {
		Matrix4f.mul(parent.renderTransform, transform, renderTransform)
		dirty = false
	}

	void eachChildRecursive(Closure closure) {
		closure(this)
		children.each closure
	}
}