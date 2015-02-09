package com.zeebo.gargoyle.render

import com.zeebo.gargoyle.behavior.Render
import com.zeebo.gargoyle.gameobject.GameObject
import com.zeebo.gargoyle.shader.ShaderDefinition

import static com.zeebo.gargoyle.GL.*

/**
 * User: Eric
 */
class ShaderRenderer implements Renderer {

	ShaderDefinition shader

	ShaderRenderer(Reader vertexShader, Reader fragmentShader, Map attributeLocations = [:]) {
		ShaderDefinition.Builder builder = new ShaderDefinition.Builder()
				.loadShader(vertexShader, GL_VERTEX_SHADER)
				.loadShader(fragmentShader, GL_FRAGMENT_SHADER)

		attributeLocations.each { k, v ->
			builder.bindAttributeLocation(k, v)
		}

		shader = builder.compile()
	}

	@Override
	void render(GameObject sceneGraph) {

		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

		glUseProgram shader.programId

		sceneGraph.eachChildRecursive renderObject

		glUseProgram 0
	}

	private final def renderObject = { GameObject go ->

		if (go[Render]) {
			glBindVertexArray go[Render].mesh.vao

			glBindBuffer GL_ELEMENT_ARRAY_BUFFER, go[Render].mesh.indexVbo
			glDrawElements GL_TRIANGLES, go[Render].mesh.faces.size() * 3, GL_UNSIGNED_INT, 0

			glBindVertexArray 0
		}
	}
}
