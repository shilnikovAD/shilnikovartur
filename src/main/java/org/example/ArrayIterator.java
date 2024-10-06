package org.example;

public class Tigers extends Predator implements Terrestrial {
    public Tigers() {
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Beef) {
            System.out.println("Tiger ест " + food);
        } else {
            System.out.println("Tiger не ест эту еду.");
        }
    }
}
