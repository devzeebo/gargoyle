package com.zeebo.gargoyle.shader

import com.zeebo.gargoyle.GL
import org.lwjgl.LWJGLException
import org.lwjgl.opengl.GL20
import org.lwjgl.util.glu.GLU

import static com.zeebo.gargoyle.GL.*

/**
 * User: Eric
 */
class ShaderDefinition {

	final int programId
	final int[] attributeArrays

	final Map<String, Integer> uniformLocations

	ShaderDefinition(int id, int[] attrs, def uniforms) {
		programId = id
		attributeArrays = attrs
		uniformLocations = uniforms
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
		def uniforms

		Builder() {
			programId = GL.glCreateProgram()
			attrs = []
			uniforms = []
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

			int error
			if ((error = GL.glGetError()) != GL.GL_NO_ERROR) {
				throw new LWJGLException(GLU.gluErrorString(error))
			}

			return this
		}

		ShaderDefinition compile() {
			GL.glLinkProgram programId
			GL.glValidateProgram programId

			def sd = new ShaderDefinition(programId, attrs as int[], uniforms.collectEntries { String it -> [it, GL20.glGetUniformLocation(programId, it)] })

			return sd
		}

		void bindUniformLocation(String uniform) {
			uniforms << uniform
		}
	}
}
