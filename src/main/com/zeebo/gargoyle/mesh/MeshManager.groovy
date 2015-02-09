package com.zeebo.gargoyle.mesh
/**
 * User: Eric
 */
class MeshManager {

	static Map<String, Mesh> meshes = [:] as LinkedHashMap<String, Mesh>

	static {
		MeshManager.metaClass.static.propertyMissing = { String key ->
			meshes[key]
		}
	}

	static void loadMesh(String name, Reader reader, Class<? extends MeshLoader> loader) {
		if (!meshes[name]) {
			meshes[name] = loader.newInstance().loadMesh(reader)
		}
	}

	static Mesh getAt(def key) {
		return meshes[key]
	}
}
