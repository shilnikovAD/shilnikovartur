package org.example;

public class Main {
    public static void main(String[] args) {
        Horses horse = new Horses();
        Tigers tiger = new Tigers();
        Dolphin dolphin = new Dolphin();
        Eagles eagle = new Eagles();
        Camels camel = new Camels();

        System.out.println("Животные в зоопарке:");
        System.out.println("Лошадь:");
        horse.walk();
        horse.eat(new Grass());

        System.out.println("\nТигр:");
        tiger.walk();
        tiger.eat(new Beef());
        tiger.eat(new Fish());

        System.out.println("\nДельфин:");
        dolphin.swim();
        dolphin.eat(new Fish());
        dolphin.eat(new Grass());

        System.out.println("\nОрел:");
        eagle.fly();
        eagle.eat(new Beef());
        eagle.eat(new Fish());

        System.out.println("\nВерблюд:");
        camel.walk();
        camel.eat(new Grass());
        camel.eat(new Beef());
    }
}