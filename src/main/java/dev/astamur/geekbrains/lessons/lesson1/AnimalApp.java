package dev.astamur.geekbrains.lessons.lesson1;

import dev.astamur.geekbrains.lessons.lesson1.base.Animal;
import dev.astamur.geekbrains.lessons.lesson1.base.Jumping;

public class AnimalApp {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Cat("Барсик", "Белый", 5);
        animals[1] = new Dog("Барбос", "Черный", 10);

        for (Animal animal : animals) {
            animal.animalInfo();
            animal.voice();

            ((Jumping) animal).jump();

            if (animal instanceof Runnable) {
                ((Runnable) animal).run();
            }
        }
    }
}