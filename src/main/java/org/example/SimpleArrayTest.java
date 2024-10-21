package org.example;

public class SimpleArrayTest {

  public static void main(String[] args) {
    Simple<String> strings = new SimpleArray<>();
    strings.add("first");
    strings.add("second");
    strings.add("third");

    System.out.println("Element at index 1: " + strings.get(1));
    System.out.println("Size of array: " + strings.size());

    strings.remove(1);
  }
}
