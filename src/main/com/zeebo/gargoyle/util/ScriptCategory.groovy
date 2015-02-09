package com.zeebo.gargoyle.util

/**
 * User: Eric
 */
@Category(Script)
class ScriptCategory {
	static void delegateTo(Script script, def object) {
		script.metaClass.methodMissing = { String methodName, args ->
			object."$methodName"(*args)
		}
		script.metaClass.propertyMissing = { String propertyName ->
			object."$propertyName"
		}
		script.metaClass.propertyMissing << { String propertyName, newValue ->
			object."$propertyName" = newValue
		}
	}
}
