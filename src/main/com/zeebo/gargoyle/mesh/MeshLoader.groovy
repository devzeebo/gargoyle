package com.zeebo.gargoyle.mesh
/**
 * User: Eric
 */
interface MeshLoader {

	Mesh loadMesh(Reader reader)

	void saveMesh(Writer writer, Mesh mesh)
}
