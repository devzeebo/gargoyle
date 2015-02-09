package com.zeebo.gargoyle.camera

import org.lwjgl.util.vector.Matrix4f

/**
 * User: Eric
 */
class ProjectionMatrix {

	Matrix4f matrix

	float fieldOfView
	float aspectRatio
	float nearPlane
	float farPlane

	private boolean dirty = true

	void setProperty(String name, value) {
		this.@"$name" = value
		dirty = true
	}

	def getMatrix() {
		if (dirty) {
			def mat = new Matrix4f()

			def frustrumLength = farPlane - nearPlane

			mat.m11 = 1.0f / Math.tan(Math.toRadians(fieldOfView / 2f))
			mat.m00 = mat.m11 / aspectRatio
			mat.m22 = -((farPlane + nearPlane) / frustrumLength)
			mat.m23 = -1
			mat.m32 = -((2 * nearPlane * farPlane) / frustrumLength)
			mat.m33 = 0

			matrix = mat
			dirty = false
		}

		return matrix
	}
}
