package com.zeebo.gargoyle.util

import org.lwjgl.BufferUtils
import org.lwjgl.util.vector.Matrix4f

import java.nio.FloatBuffer

/**
 * User: Eric
 */
class Matrix4fCategory {

	static def toFloatBuffer(Matrix4f mat) {
		toFloatBuffer mat, BufferUtils.createFloatBuffer(16)
	}

	static def toFloatBuffer(Matrix4f mat, FloatBuffer fb) {

		fb.mark()
		mat.store fb
		fb.reset()
		return fb
	}
}
