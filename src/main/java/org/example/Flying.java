package org.example;

public interface Flying {
    default void fly() {
        System.out.println("Flying летит.");
    }
}
