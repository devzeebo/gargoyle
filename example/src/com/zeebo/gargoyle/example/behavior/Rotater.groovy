package com.zeebo.gargoyle.example.behavior

import com.zeebo.gargoyle.behavior.Behavior
import com.zeebo.gargoyle.behavior.BehaviorManager
import org.lwjgl.util.vector.Vector3f

/**
 * User: Eric
 */
class Rotater extends Behavior {

	Vector3f axis

	void onUpdate() {
		gameObject.transform.rotate(0.01f, axis)
	}
}
