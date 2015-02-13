package com.zeebo.gargoyle.render

import com.zeebo.gargoyle.behavior.Render
import com.zeebo.gargoyle.behavior.camera.Camera
import com.zeebo.gargoyle.gameobject.GameObject
import com.zeebo.gargoyle.shader.ShaderDefinition
import org.lwjgl.BufferUtils
import org.lwjgl.LWJGLException
import org.lwjgl.util.glu.GLU
import org.lwjgl.util.vector.Matrix4f
import org.lwjgl.util.vector.Vector3f

import java.nio.FloatBuffer

import static com.zeebo.gargoyle.GL.*

/**
 * User: Eric
 */
class ShaderRenderer implements Renderer {

	ShaderDefinition shader
	FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer 16

	ShaderRenderer(Reader vertexShader, Reader fragmentShader, Map attributeLocations = [:], def uniformLocations = []) {
		ShaderDefinition.Builder builder = new ShaderDefinition.Builder()
				.loadShader(vertexShader, GL_VERTEX_SHADER)
				.loadShader(fragmentShader, GL_FRAGMENT_SHADER)

		attributeLocations.each { k, v ->
			builder.bindAttributeLocation(k, v)
		}

		uniformLocations.each { builder.bindUniformLocation(it) }

		shader = builder.compile()

		int error
		if ((error = glGetError()) != GL_NO_ERROR) {
			throw new LWJGLException(GLU.gluErrorString(error))
		}
	}

	void applyCamera(Camera camera) {
		int error
		if ((error = glGetError()) != GL_NO_ERROR) {
			throw new LWJGLException(GLU.gluErrorString(error))
		}

		camera.projection.matrix.store matrixBuffer
		matrixBuffer.flip()
		glUniformMatrix4 shader.uniformLocations.projectionMatrix, false, matrixBuffer
		camera.matrix.store matrixBuffer
		matrixBuffer.flip()
		glUniformMatrix4 shader.uniformLocations.viewMatrix, false, matrixBuffer

		if ((error = glGetError()) != GL_NO_ERROR) {
			throw new LWJGLException(GLU.gluErrorString(error))
		}
	}

	@Override
	void render(GameObject sceneGraph) {

		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

		shader.withShader {

			applyCamera Camera.mainCamera

			sceneGraph.eachChildRecursive renderObject
		}
	}

	private final def renderObject = { GameObject go ->

		if (go[Render]) {
			glBindVertexArray go[Render].mesh.vao

			go.renderTransform.store matrixBuffer
			matrixBuffer.flip()
			glUniformMatrix4 shader.uniformLocations.modelMatrix, false, matrixBuffer

			glBindBuffer GL_ELEMENT_ARRAY_BUFFER, go[Render].mesh.indexVbo
			glDrawElements GL_TRIANGLES, go[Render].mesh.faces.size() * 3, GL_UNSIGNED_INT, 0

			glBindVertexArray 0
		}
	}
}
