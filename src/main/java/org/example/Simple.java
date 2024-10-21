package org.example;
/**
 * A generic interface defining basic array-like operations.
 *
 * <A> the type of elements in the array
 */
public interface Simple<A> extends Iterable<A> {
    boolean add(A e);
    void remove(int index);
    A get(int index);
    int size();
}