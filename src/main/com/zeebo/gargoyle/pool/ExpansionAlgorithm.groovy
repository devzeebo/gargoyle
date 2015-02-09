package com.zeebo.gargoyle.pool

/**
 * User: Eric
 */
abstract class ExpansionAlgorithm<T> {

	final T[] expand(T[] pool) {
		T[] newArray = new T[calculateNewSize(pool.length)]
		System.arraycopy(pool, 0, newArray, 0, pool.length)

		return newArray
	}

	abstract int calculateNewSize(int currentSize)
}
