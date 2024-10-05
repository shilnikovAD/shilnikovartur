package org.example;

public class Herbivor {
    public void eat(Food food) {
        if (food instanceof Grass) {
            System.out.println("Herbivore ест " + food);
        } else {
            System.out.println("Herbivore не ест эту еду.");
        }
    }
}
