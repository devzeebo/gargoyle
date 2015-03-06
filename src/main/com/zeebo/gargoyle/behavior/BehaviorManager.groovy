package com.zeebo.gargoyle.behavior

import com.zeebo.gargoyle.util.Timing

/**
 * User: Eric
 */
class BehaviorManager {

	private static Map<String, LinkedHashSet<Behavior>> map = [:].withDefault { [] as LinkedHashSet }
	private static Map<String, Long> lastExecTime = [:].withDefault { System.currentTimeMillis() }

	static void doWith(String key, Closure c) {
		Iterator i = map[key].iterator()

		while (i.hasNext()) {
			def behavior = i.next()
			if (behavior.deleteOnPass.contains(key)) {
				i.remove()
				behavior.deleteOnPass.remove(key)
				continue
			}
			switch (c.parameterTypes.length) {
				case 1: c(behavior); break
				case 2: c(behavior, i); break
			}
		}
	}

	static void runEvent(String event, args = null) {

		long execTime = System.currentTimeMillis()
		float deltaTime = (execTime - lastExecTime[event]) / 1000f

		map[event].each {
			if (Behavior.registrationDefs[it.class][event][1]) {
				Behavior.registrationDefs[it.class][event][0].invoke(it, deltaTime)
			} else {
				Behavior.registrationDefs[it.class][event][0].invoke(it, null)
			}
		}

		lastExecTime[event] = execTime
	}

	static void unregister(Behavior go, String action) {
		go.deleteOnPass << action
	}

	static void register(Behavior go, String action) {
		if (go.respondsTo('deleteOnPass')) {
			go.deleteOnPass.remove(action)
		} else {
			go.metaClass.deleteOnPass = [] as HashSet
		}

		map[action] << go
	}

	static boolean isRegistered(Behavior go, String action) {
		map[action].contains(go) && go.deleteOnPass.contains(action)
	}
}
