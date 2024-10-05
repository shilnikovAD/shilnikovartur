package org.example;

public class Dolphin extends Predator implements Waterfowl{
    public Dolphin() {
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Fish) {
            System.out.println("Dolphin ест " + food);
        } else {
            System.out.println("Dolphin не ест эту еду.");
        }
    }
}
