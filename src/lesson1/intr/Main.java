package lesson1.intr;

import lesson1.Animal;

public class Main {
    public static void main(String[] args) {
        AnimalInterface dog = new Dog();

        dog.run();
        dog.voice();

    }
}