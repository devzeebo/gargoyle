package com.zeebo.gargoyle.example.behavior

import com.zeebo.gargoyle.behavior.Behavior
import org.lwjgl.input.Keyboard
import org.lwjgl.util.vector.Vector3f

/**
 * User: Eric
 */
class CameraController extends Behavior {

	void onUpdate(float deltaTime) {
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			gameObject.transform.translate(new Vector3f(0, 0, 0.01f))
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			gameObject.transform.translate(new Vector3f(0, 0, -0.01f))
		}
	}
}
