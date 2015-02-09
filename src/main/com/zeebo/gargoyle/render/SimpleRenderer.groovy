package com.zeebo.gargoyle.render

import com.zeebo.gargoyle.behavior.Render
import com.zeebo.gargoyle.gameobject.GameObject

import static com.zeebo.gargoyle.GL.*

/**
 * User: Eric
 */
class SimpleRenderer implements Renderer {

	@Override
	void render(GameObject sceneGraph) {

		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

		sceneGraph.eachChildRecursive renderObject
	}

	private final def renderObject = { GameObject go ->

		Render r
		if ((r = go[Render])) {
			glBindVertexArray r.mesh.vao

			glBindBuffer GL_ELEMENT_ARRAY_BUFFER, r.mesh.indexVbo

			glDrawElements GL_TRIANGLES, r.mesh.faces.size() * 3, GL_UNSIGNED_INT, 0

			glBindVertexArray 0
		}
	}
}
