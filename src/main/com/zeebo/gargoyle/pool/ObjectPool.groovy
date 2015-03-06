package com.zeebo.gargoyle.pool

import javax.naming.OperationNotSupportedException
import java.util.function.Consumer

/**
 * User: Eric
 */
class ObjectPool<T> {

	static <NT> void usePoolForClass(Class<NT> clazz, ObjectPool<NT> op = new ObjectPool<NT>(clazz)) {

		clazz.metaClass.static.getPool = { op }
		clazz.metaClass.constructor = {
			op.checkout()
		}
		clazz.metaClass.finalize = {
			op.checkin(delegate)
			clazz.metaClass.getMetaMethod('finalize', null).invoke(delegate)
		}
		clazz.metaClass.checkin = {
			op.checkin(delegate)
		}
	}

	private T[] objects
	private int i

	private Closure clean

	private ExpansionAlgorithm<T> expander

	private Class<T> classRef

	ObjectPool(Class<T> clazz, int capacity = 10, Closure clean = null, ExpansionAlgorithm algo = new DoublingExpansionAlgorithm<T>()) {

		classRef = clazz

		objects = new T[capacity]
		if (!(this.clean = clean)) {
			if (clazz.metaClass.getMetaMethod('clean', [clazz] as Object[])) {
				this.clean = clazz.&clean
			}
		}
		expander = algo

		for (int i = 0; i < capacity; i++) {
			objects[i] = classRef.metaClass.invokeConstructor()
		}
	}

	synchronized T checkout() {
		println 'Checkout'
		if (i >= objects.size()) {
			expand()
		}
		T obj = objects[i]
		if (obj.hasProperty('opmIndex')) {
			obj.opmIndex = i++
		} else {
			obj.metaClass.opmIndex = i++
		}
		clean?.call(obj)
		return obj
	}

	synchronized void checkin(T object) {
		println 'checkin'
		objects[i - 1].opmIndex = object.opmIndex
		objects[object.opmIndex] = objects[i - 1]
		objects[--i] = object
	}

	private synchronized void expand() {

		objects = expander.expand(objects)
		for (int x = i; x < objects.size(); x++) {
			objects[x] = classRef.getConstructor().newInstance()
		}
	}

	ObjectPoolIterator iterator() {
		new ObjectPoolIterator()
	}

	class ObjectPoolIterator implements Iterator<T> {

		int iter = 0

		@Override
		boolean hasNext() {
			return iter < i
		}

		@Override
		T next() {
			return objects[iter++]
		}

		@Override
		void remove() {
			checkin objects[iter--]
		}

		@Override
		void forEachRemaining(Consumer<? super T> action) {
			throw new OperationNotSupportedException()
		}
	}
}