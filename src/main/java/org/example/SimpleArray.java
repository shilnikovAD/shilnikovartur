package org.example;

import java.util.Iterator;

/**
 * A simple generic array implementation that supports adding, removing,
 * and retrieving elements.
 *
 * <A> the type of elements in the array
 */

public class SimpleArray<A> implements Simple<A> {
    private A[] values;
    public SimpleArray() {
        values = (A[]) new Object[0];
    }

    @Override
    public boolean add(A a) {
        try {
            A[] temp = values;
            values = (A[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = a;
            return true;

        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void remove(int index) {
        try{
            A[] temp = values;
            values = (A[]) new Object[temp.length - 1];
            System.arraycopy(temp,0,values,0, index);
            int amountElemAfterIndex = temp.length - index - 1;
            System.arraycopy(temp,index + 1, values, index, amountElemAfterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public A get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public Iterator<A> iterator() {
        return new ArrayIterator<A>(values);
    }
}