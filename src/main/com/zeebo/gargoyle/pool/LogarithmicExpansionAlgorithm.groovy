package com.zeebo.gargoyle.pool

/**
 * User: Eric
 */
class LogarithmicExpansionAlgorithm<T> extends ExpansionAlgorithm<T> {

	private float base
	private int startingSize

	private int iteration = 0

	LogarithmicExpansionAlgorithm(float b = 2) {
		base = b
	}

	@Override
	int calculateNewSize(int currentSize) {
		if (startingSize == 0) {
			startingSize = currentSize
		}

		return currentSize + Math.ceil(startingSize / (base ** iteration++))
	}
}
