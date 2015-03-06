package com.zeebo.gargoyle.render.culling

import com.zeebo.gargoyle.gameobject.GameObject
import org.lwjgl.util.vector.Vector3f

/**
 * User: Eric
 */
interface CullingMask {

	public void prepare()

	public boolean cull(Vector3f point)

	public boolean cull(GameObject object)
}
