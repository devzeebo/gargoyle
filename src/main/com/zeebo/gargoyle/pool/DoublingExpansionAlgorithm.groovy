package com.zeebo.gargoyle.pool

/**
 * User: Eric
 */
public class DoublingExpansionAlgorithm<T> extends ExpansionAlgorithm<T> {
	@Override
	int calculateNewSize(int currentSize) {
		return currentSize * 2
	}
}