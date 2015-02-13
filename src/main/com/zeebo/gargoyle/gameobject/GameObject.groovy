package com.zeebo.gargoyle.gameobject

import com.zeebo.gargoyle.behavior.Behavior
import org.lwjgl.util.vector.Matrix4f
import org.lwjgl.util.vector.Vector3f

/**
 * User: Eric
 */
final class GameObject {

	final Matrix4f renderTransform = new Matrix4f()
	final Matrix4f transform = new Matrix4f()

	private boolean dirty = true

	String name

	GameObject parent

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

	void setPosition(def position) {
		transform.translate new Vector3f(*position)
	}

	void setRotation(def rotation) {
		transform.rotate(rotation[0], new Vector3f(1, 0, 0))
		transform.rotate(rotation[1], new Vector3f(0, 1, 0))
		transform.rotate(rotation[2], new Vector3f(0, 0, 1))
	}

	void setScale(def scale) {
		transform.scale(new Vector3f(*scale))
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
		dirty = false
		if (parent) {
			Matrix4f.mul(parent.renderTransform, transform, renderTransform)
		}
		else {
			renderTransform.load transform
		}
		return renderTransform
	}

	void eachChildRecursive(Closure closure) {
		closure(this)
		children.each closure
	}

	String toHierarchy(int depth = 0) {
		StringBuilder hierarchy = new StringBuilder()

		hierarchy.append( '\t' * depth + name + '\n')
		children.each {
			hierarchy.append it.toHierarchy(depth + 1)
		}

		return hierarchy.toString()
	}
}