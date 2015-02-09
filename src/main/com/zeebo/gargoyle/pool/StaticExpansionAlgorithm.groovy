package com.zeebo.gargoyle.pool

/**
 * User: Eric
 */
class StaticExpansionAlgorithm<T> extends ExpansionAlgorithm<T> {

	private int amount

	StaticExpansionAlgorithm(int amount = 10) {
		this.amount = amount
	}

	@Override
	int calculateNewSize(int currentSize) {
		return currentSize + amount
	}
}
