package org.example;

import java.util.Iterator;

/**
 * An iterator for SimpleArray that iterates through the elements of the array.
 *
 * <E> the type of elements in the array
 */

public class ArrayIterator<E> implements Iterator<E>{
    private int index = 0;
    E[] values;

    ArrayIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }

}