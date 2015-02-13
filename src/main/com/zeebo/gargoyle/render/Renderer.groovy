package com.zeebo.gargoyle.render

import com.zeebo.gargoyle.behavior.camera.Camera
import com.zeebo.gargoyle.gameobject.GameObject

/**
 * User: Eric
 */
interface Renderer {

	void render(GameObject sceneGraph)

	void applyCamera(Camera camera)
}