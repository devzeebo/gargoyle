package com.zeebo.gargoyle.render.culling

import com.zeebo.gargoyle.behavior.camera.Camera
import com.zeebo.gargoyle.gameobject.GameObject
import groovy.util.logging.Log
import org.lwjgl.util.vector.Vector3f

import java.util.logging.Level

/**
 * User: Eric
 */
@Log
class FrustumCullingMask implements CullingMask {

	Camera camera

	Vector3f X = new Vector3f()
	Vector3f Y = new Vector3f()
	Vector3f Z

	int count

	float tang

	void prepare() {
		count = 0
		Z = camera.gameObject.transform * new Vector3f(0, 0, 1)
		Vector3f.sub(Z, camera.gameObject.transform.position, Z)
		Z.normalise(Z)
		Vector3f.cross(Z, new Vector3f(0, 1, 0), X)
		X.normalise()
		Vector3f.cross(X, Z, Y)
		Y.normalise()

		tang = Math.tan(Math.toRadians(camera.projection.fieldOfView))
	}

	@Override
	boolean cull(Vector3f point) {
		count++
		log.level = Level.OFF
		log.log Level.INFO, '\n'
		log.log Level.INFO, "$point"
		Vector3f pc = new Vector3f()
		Vector3f.sub(point, camera.gameObject.transform.position, pc)

		log.log Level.INFO, "$pc"
		log.log Level.INFO, "$Z"

		float z = Vector3f.dot(pc, Z)
		log.log Level.INFO, "$camera.projection.nearPlane:$camera.projection.farPlane $z"
		if (!(camera.projection.nearPlane..camera.projection.farPlane).containsWithinBounds(z)) {
			return true
		}

		float y = Vector3f.dot(pc, Y)
		float aux = z * tang
		log.log Level.INFO, "${-aux}:$aux $y"
		if (!(-aux..aux).containsWithinBounds(y)) {
			return true
		}

		float x = Vector3f.dot(pc, X)
		aux *= camera.projection.aspectRatio
		log.log Level.INFO, "${-aux}:$aux $x"
		if (!(-aux..aux).containsWithinBounds(x)) {
			return true
		}

		log.log Level.INFO, "$point"
		count--
		return false
	}

	@Override
	boolean cull(GameObject object) {
		return false
	}
}
