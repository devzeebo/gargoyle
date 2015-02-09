package com.zeebo.gargoyle.shader

import com.zeebo.gargoyle.GL
import org.lwjgl.LWJGLException
import org.lwjgl.util.glu.GLU

import static com.zeebo.gargoyle.GL.*

/**
 * User: Eric
 */
class ShaderDefinition {

	final int programId
	final int[] attributeArrays

	ShaderDefinition(int id, int[] attrs) {
		programId = id
		attributeArrays = attrs
	}

	def withShader(Closure closure) {

		glUseProgram programId
		attributeArrays.each {
			glEnableVertexAttribArray it
		}

		closure()

		attributeArrays.each {
			glDisableVertexAttribArray it
		}
		glUseProgram 0
	}

	static class Builder {

		int programId
		def attrs

		Builder() {
			programId = GL.glCreateProgram()
			attrs = []
		}

		Builder loadShader(Reader reader, int type) {

			int shaderId = GL.glCreateShader type
			GL.glShaderSource shaderId, reader.readLines().join('\n')
			GL.glCompileShader shaderId

			GL.glAttachShader programId, shaderId

			return this
		}

		Builder bindAttributeLocation(int attribId, String location) {
			GL.glBindAttribLocation programId, attribId, location

			attrs << attribId

			return this
		}

		ShaderDefinition compile() {
			GL.glLinkProgram programId
			GL.glValidateProgram programId

			def error
			if ((error = GL.glGetError()) != GL.GL_NO_ERROR) {
				throw new LWJGLException(GLU.gluErrorString(error))
			}

			return new ShaderDefinition(programId, attrs as int[])
		}
	}
}
