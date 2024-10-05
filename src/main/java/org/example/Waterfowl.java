package org.example;

public interface Waterfowl {
    default void swim() {
        System.out.println("Aquatic плывет.");
    }
}
