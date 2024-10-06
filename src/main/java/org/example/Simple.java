package org.example;

public interface Terrestrial {

    default void walk() {
        System.out.println("Terrestrial ходит.");
    }
}
