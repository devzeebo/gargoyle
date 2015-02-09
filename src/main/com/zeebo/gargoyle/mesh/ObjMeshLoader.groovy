package com.zeebo.gargoyle.mesh

import org.lwjgl.util.vector.Vector2f
import org.lwjgl.util.vector.Vector3f
import org.lwjgl.util.vector.Vector4f

/**
 * User: Eric
 */
class ObjMeshLoader implements MeshLoader {

	@Override
	Mesh loadMesh(Reader reader) {

		Mesh mesh = new Mesh()

		reader.eachLine {
			def split = it.split(/\s+/)
			switch(split[0]) {
				case 'v':
					mesh.vertices << new Vector3f(*split[1..3].collect { it as float })
					if (split.length == 7) {
						mesh.colors << new Vector4f(*split[4..6].collect { it as float }, 1f)
					}
					break
				case 'vt': mesh.texCoords << new Vector2f(*split[1..2].collect { it as float }); break
				case 'vn': mesh.normals << new Vector3f(*split[1..3].collect { it as float }); break
				case 'f':
					Face face = new Face()
					split[1..3].each {
						def vertDef = it.split('/')
						face.vertices << (vertDef[0] as int) - 1
						if (vertDef.length > 1 && vertDef[1]) {
							face.texCoords << (vertDef[1] as int) - 1
						}
						if (vertDef.length > 2 && vertDef[2]) {
							face.normals << (vertDef[2] as int) - 1
						}
					}
					mesh.faces << face
					break
			}
		}

		mesh.bindVertexData()

		return mesh
	}

	@Override
	void saveMesh(Writer writer, Mesh mesh) {

	}

	public static void main(String[] args) {
		println new ObjMeshLoader().loadMesh(new File('cube.obj').newReader())
	}
}
