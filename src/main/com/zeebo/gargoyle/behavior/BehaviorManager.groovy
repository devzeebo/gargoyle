package com.zeebo.gargoyle.behavior
/**
 * User: Eric
 */
class BehaviorManager {

	private static Map<String, LinkedHashSet<Behavior>> map = [:].withDefault { [] as LinkedHashSet }

	static void doWith(String key, Closure c) {
		Iterator i = map[key].iterator()

		while(i.hasNext()) {
			def behavior = i.next()
			if (behavior.deleteOnPass.contains(key)) {
				i.remove()
				behavior.deleteOnPass.remove(key)
				continue
			}
			switch(c.parameterTypes.length) {
				case 1: c(behavior); break
				case 2: c(behavior, i); break
			}
		}
	}

	static void runEvent(String event, args) {

		String methodName = "on${event.capitalize()}"
		map[event].each {
			it."$methodName"(args)
		}
	}

	static void unregister(Behavior go, String action) {
		go.deleteOnPass << action
	}

	static void register(Behavior go, String action) {
		if (go.respondsTo('deleteOnPass')) {
			go.deleteOnPass.remove(action)
		}
		else {
			go.metaClass.deleteOnPass = [] as HashSet
		}

		map[action] << go
	}

	static boolean isRegistered(Behavior go, String action) {
		map[action].contains(go) && go.deleteOnPass.contains(action)
	}
}
