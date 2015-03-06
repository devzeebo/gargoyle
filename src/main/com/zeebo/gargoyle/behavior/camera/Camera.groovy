package com.zeebo.gargoyle.behavior.camera

import com.zeebo.gargoyle.behavior.Behavior
import org.lwjgl.util.vector.Matrix4f

/**
 * User: Eric
 */
class Camera extends Behavior {

	static Camera mainCamera

	ProjectionMatrix projection = new ProjectionMatrix()

	void setMain(boolean value) {
		if (value) {
			mainCamera = this
		}
	}
}
