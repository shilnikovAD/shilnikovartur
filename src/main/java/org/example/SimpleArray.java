package org.example;

import java.util.Iterator;

public class SimpleArray<A> implements Simple<A> {

    public static void main(String[] args) {
        Simple<String> strings = new SimpleArray<>();
        strings.add("first");
        strings.add("second");
        strings.add("tree");

        //strings.remove(1);

        System.out.println(strings.get(1));
        System.out.println(strings.size());
    }

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