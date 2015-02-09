package com.zeebo.gargoyle.mesh

import com.zeebo.gargoyle.GL
import org.lwjgl.BufferUtils
import org.lwjgl.util.vector.Vector2f
import org.lwjgl.util.vector.Vector3f
import org.lwjgl.util.vector.Vector4f

import java.nio.FloatBuffer
import java.nio.IntBuffer

/**
 * User: Eric
 */
class Mesh {

	List<Vector3f> vertices = []
	List<Vector2f> texCoords = []
	List<Vector3f> normals = []
	List<Vector4f> colors = []

	List<Face> faces = []

	int vao
	int vertexVbo
	int indexVbo
	int colorVbo
	int textureVbo

	Mesh() {
		Runtime.addShutdownHook {
			releaseBufferObjects()
		}
	}

	@Override
	final void finalize() {
		releaseBufferObjects()
	}

	private final def releaseBufferObjects() {
		try {
			GL.glDeleteBuffers vertexVbo
			GL.glDeleteBuffers indexVbo
			GL.glDeleteBuffers colorVbo
			GL.glDeleteBuffers textureVbo
			GL.glDeleteVertexArrays vao
		}
		catch (Exception re) {}
	}

	def bindVertexData() {
		vao = GL.glGenVertexArrays()
		GL.glBindVertexArray vao

		FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer vertices.size() * 4
		vertexBuffer.put(vertices.collect { [it.x, it.y, it.z, 1.0f] }.flatten() as float[])
		vertexBuffer.flip()

		IntBuffer indexBuffer = BufferUtils.createIntBuffer faces.size() * 3
		indexBuffer.put(faces*.vertices.flatten() as int[])
		indexBuffer.flip()

		FloatBuffer colorBuffer = BufferUtils.createFloatBuffer colors.size() * 4
		colorBuffer.put(colors.collect { [it.x, it.y, it.z, it.w] }.flatten() as float[])
		colorBuffer.flip()

		FloatBuffer textureBuffer = BufferUtils.createFloatBuffer texCoords.size() * 2
		textureBuffer.put(texCoords.collect { [it.x, it.y] }.flatten() as float[])
		textureBuffer.flip()

		vertexVbo = GL.glGenBuffers()

		GL.glBindBuffer GL.GL_ARRAY_BUFFER, vertexVbo
		GL.glBufferData GL.GL_ARRAY_BUFFER, vertexBuffer, GL.GL_STATIC_DRAW
		GL.glVertexAttribPointer 0, 4, GL.GL_FLOAT, false, 0, 0
		GL.glEnableVertexAttribArray 0

		indexVbo = GL.glGenBuffers()

		GL.glBindBuffer GL.GL_ELEMENT_ARRAY_BUFFER, indexVbo
		GL.glBufferData GL.GL_ELEMENT_ARRAY_BUFFER, indexBuffer, GL.GL_STATIC_DRAW

		colorVbo = GL.glGenBuffers()

		GL.glBindBuffer GL.GL_ARRAY_BUFFER, colorVbo
		GL.glBufferData GL.GL_ARRAY_BUFFER, colorBuffer, GL.GL_STATIC_DRAW
		GL.glVertexAttribPointer 1, 4, GL.GL_FLOAT, false, 0, 0
		GL.glEnableVertexAttribArray 1

		textureVbo = GL.glGenBuffers()

		GL.glBindBuffer GL.GL_ARRAY_BUFFER, textureVbo
		GL.glBufferData GL.GL_ARRAY_BUFFER, textureBuffer, GL.GL_STATIC_DRAW
		GL.glVertexAttribPointer 2, 2, GL.GL_FLOAT, false, 0, 0
		GL.glEnableVertexAttribArray 2

		GL.glBindBuffer GL.GL_ARRAY_BUFFER, 0
		GL.glBindBuffer GL.GL_ELEMENT_ARRAY_BUFFER, 0
		// unbind
		GL.glBindVertexArray 0
	}

	@Override
	String toString() {
		return "Mesh{" +
				"vertices=" + vertices +
				", texCoords=" + texCoords +
				", normals=" + normals +
				", colors=" + colors +
				", faces=" + faces +
				'}';
	}
}
