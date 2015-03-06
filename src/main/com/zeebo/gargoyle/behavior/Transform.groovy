package com.zeebo.gargoyle.behavior

import org.lwjgl.util.vector.Matrix4f
import org.lwjgl.util.vector.Vector2f
import org.lwjgl.util.vector.Vector3f
import org.lwjgl.util.vector.Vector4f

import java.nio.FloatBuffer

/**
 * User: Eric
 */
class Transform extends Behavior {

	Transform parent
	List<Transform> children = []

	private final Matrix4f internal = new Matrix4f()
	private boolean dirty = true
	private final Matrix4f render = new Matrix4f()

	Transform setIdentity() {
		Matrix4f.setIdentity(internal)
		dirty = true
		return this
	}

	Transform setZero() {
		Matrix4f.setZero(internal)
		dirty = true
		return this
	}

	static Transform clean(Transform transform) {
		transform.setIdentity()
	}

	Transform leftShift(Transform other) {
		load other
	}

	Transform leftShift(Matrix4f other) {
		load other
	}

	Transform load(Transform other) {
		load other.internal
	}

	Transform load(Matrix4f other) {
		Matrix4f.load(other, internal)
		dirty = true
		return this
	}

	FloatBuffer rightShift(FloatBuffer buffer) {
		store(buffer)
	}

	FloatBuffer store(FloatBuffer buffer) {
		internal.store buffer
		return buffer
	}

	Transform plus(Transform other) {
		add(this, other)
	}

	static Transform add(Transform left, Transform right, Transform dest = new Transform()) {
		Matrix4f.mul(left.internal, right.internal, dest.internal)
		dest.dirty = true
		return dest
	}

	Transform minus(Transform other) {
		sub(this, other)
	}

	static Transform sub(Transform left, Transform right, Transform dest = new Transform()) {
		Matrix4f.sub(left.internal, right.internal, dest.internal)
		dest.dirty = true
		return dest
	}

	Transform multiply(Transform other) {
		mul(this, other)
	}

	Vector3f multiply(Vector3f other) {
		Vector4f vec4 = new Vector4f(other.x, other.y, other.z, 1)
		Matrix4f.transform(internal, vec4, vec4)
		return new Vector3f(vec4.x, vec4.y, vec4.z)
	}

	static Transform mul(Transform left, Transform right, Transform dest = new Transform()) {
		Matrix4f.mul(left.internal, right.internal, dest.internal)
		dest.dirty = true
		return dest
	}

	Transform translate(Vector2f vector) {
		internal.translate(vector)
		dirty = true
		return this
	}

	Transform translate(Vector3f vector) {
		internal.translate(vector)
		dirty = true
		return this
	}

	Transform rotate(float amount, Vector3f axis) {
		internal.rotate(amount, axis)
		dirty = true
		return this
	}

	Transform scale(Vector3f scale) {
		internal.scale(scale)
		dirty = true
		return this
	}

	/**
	 * Calculates the inverse of the Transform.
	 *
	 * ~myTransform
	 *
	 * @return
	 */
	Transform bitwiseNegate() {
		invert(this, this)
	}

	static Transform invert(Transform src, Transform dest = new Transform()) {
		Matrix4f.invert(src.internal, dest.internal)
		dest.dirty = true
		return dest
	}

	Transform negative() {
		negate(this, this)
	}

	static Transform negate(Transform src, Transform dest = new Transform()) {
		Matrix4f.negate(src.internal, dest.internal)
		dest.dirty = true
		return dest
	}

	Vector3f getPosition() {
		Vector4f pos = new Vector4f(0, 0, 0, 1)
		Matrix4f.transform(internal, pos, pos)
		return new Vector3f(pos.x, pos.y, pos.z)
	}

	Matrix4f getRender() {
		if (dirty) {
			recalculateRenderTransform()
			children*.recalculateRenderTransform()
		}
		return render
	}

	private final def recalculateRenderTransform = {
		dirty = false
		if (parent) {
			Matrix4f.mul(parent.render, internal, render)
		}
		else {
			render.load internal
		}
		return render
	}
}
