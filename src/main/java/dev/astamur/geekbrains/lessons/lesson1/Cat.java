package dev.astamur.geekbrains.lessons.lesson1;

import dev.astamur.geekbrains.lessons.lesson1.base.Animal;
import dev.astamur.geekbrains.lessons.lesson1.base.Jumping;

import java.util.StringJoiner;

public class Cat extends Animal implements Jumping, Runnable {
    String color;
    int age;

    public Cat() {
    }

    public Cat(String color, int age) {
        this.color = color;
        this.age = age;
    }

    public Cat(String name, String color, int age) {
        super(name);
        this.color = color;
        this.age = age;
    }

    public void catInfo() {
        System.out.printf("Кошка. Имя: %s. Цвет: %s. Возраст: %d\n", name, color, age);
    }

    @Override
    public void animalInfo() {
        super.animalInfo();
        catInfo();
    }

    @Override
    public void voice() {
        System.out.println("Cat: myau!");
    }

    @Override
    public void jump() {
        System.out.println(String.format("Cat '%s': jump!", name));
    }

    @Override
    public void run() {
        System.out.println(String.format("Cat '%s': run!", name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;

        Cat cat = (Cat) o;

        if (age != cat.age) return false;
        return color.equals(cat.color);
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cat.class.getSimpleName() + "[", "]")
                .add("color='" + color + "'")
                .add("age=" + age)
                .add("name='" + name + "'")
                .toString();
    }

    public CatReader createReader() {
        return new CatReader();
    }

    public static class CatReader {
        public String getCatInfo() {
            return "Hello, from CatReader";
        }
    }
}