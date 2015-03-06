package com.zeebo.gargoyle.util

/**
 * User: Eric
 */
class Timing {

	static double time(Closure c) {
		time(1, c)
	}

	static double time(int times, Closure c) {
		totalTime(times, c) / times / 1000
	}

	static double totalTime(int times, Closure c) {
		long start, end
		double total = 0

		for (int i = 0; i < times; i++) {
			start = System.currentTimeMillis()
			c()
			end = System.currentTimeMillis()
			total += end - start
		}

		return total
	}
}
