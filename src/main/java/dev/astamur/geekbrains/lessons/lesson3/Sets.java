package dev.astamur.geekbrains.lessons.lesson3;

import java.util.*;

public class Sets {
    public static void main(String[] args) {
        // hashSets();
        // linkedHashSets();
        // treeSets();
        treeSets2();
    }

    private static void hashSets() {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= 100000; i++) {
            set.add(i % 10);
        }

        System.out.println(set);
    }

    private static void linkedHashSets() {
        Set<Integer> set = new LinkedHashSet<>();

        for (int i = 1; i <= 100000; i++) {
            set.add(i % 10);
        }

        System.out.println(set);
    }

    private static void treeSets() {
        Comparator<Cat> catComparator = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        NavigableSet<Cat> cats = new TreeSet<>(catComparator.reversed());

        for (int i = 1; i <= 12; i++) {
            cats.add(new Cat("Cat " + i, i));
        }

        System.out.println(cats);
    }

    private static void treeSets2() {
        Set<Integer> set = new TreeSet<>();

        for (int i = 1; i <= 100000; i++) {
            set.add(i % 10);
        }

        System.out.println(set);
    }
}
