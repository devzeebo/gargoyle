package com.zeebo.gargoyle.util

/**
 * User: Eric
 */
class Timing {

	static void time(Closure c) {
		time(1, c)
	}

	static void time(int times, Closure c) {
		long start, end
		double total = 0

		for (int i = 0; i < times; i++) {
			start = System.currentTimeMillis()
			c()
			end = System.currentTimeMillis()
			total += end - start
		}



		println total / times / 1000
	}
}
