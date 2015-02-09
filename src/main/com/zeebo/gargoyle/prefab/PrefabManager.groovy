package com.zeebo.gargoyle.prefab

/**
 * User: Eric
 */
class PrefabManager {

	static Map<String, Prefab> prefabs = [:] as LinkedHashMap<String, Prefab>

	static {
		PrefabManager.metaClass.static.propertyMissing = { String key ->
			prefabs[key]
		}
	}

	static Prefab getAt(def key) {
		return prefabs[key]
	}
}
