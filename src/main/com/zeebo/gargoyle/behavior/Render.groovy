package com.zeebo.gargoyle.behavior

import com.zeebo.gargoyle.mesh.Mesh
import com.zeebo.gargoyle.mesh.MeshManager
import com.zeebo.gargoyle.pool.ObjectPool

/**
 * User: Eric
 */
class Render extends Behavior {

	final static ObjectPool<Render> objectPool = new ObjectPool<>(Render, 10, { it.mesh = null })

	Mesh mesh

	void setMesh(Mesh mesh) {
		this.mesh = mesh
	}

	void setMesh(String meshName) {
		mesh = MeshManager[meshName]
	}
}
