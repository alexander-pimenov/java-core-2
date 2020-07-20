package dev.astamur.geekbrains.lessons.lesson1;

public class CatDemoApp {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик", "Коричневый", 4);
        Cat cat2 = new Cat();

        cat2.setName("Мурзик");
        cat2.color = "Черный";
        cat2.age = 6;

        cat1.animalInfo();
        cat2.animalInfo();

        cat1.jump();
        cat2.jump();

        cat1.run();
        cat2.run();

        System.out.println(cat1);

        Cat.CatReader catReader = new Cat.CatReader();
        System.out.println(catReader.getCatInfo());
    }
}

