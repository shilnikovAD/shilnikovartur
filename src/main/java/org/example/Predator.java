package org.example;

public class Predator {
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println("Predator ест " + food);
        } else {
            System.out.println("Predator не ест эту еду.");
        }
    }
}
