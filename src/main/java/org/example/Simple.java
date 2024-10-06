package org.example;

public interface Simple<A> extends Iterable<A> {
    boolean add(A e);
    void remove(int index);
    A get(int index);
    int size();
}