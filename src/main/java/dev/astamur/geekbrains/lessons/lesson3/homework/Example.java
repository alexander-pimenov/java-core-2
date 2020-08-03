package dev.astamur.geekbrains.lessons.lesson3.homework;

import java.util.*;

public class Example {
    public static void main(String[] args) {
        String[] words = new String[]{"aaa", "aaa", "bbb", "bbb", "ccc", "ccc"};
        Map<String, Integer> stats = distinctWords(words);

        System.out.println("Distinct words count: " + stats);
        System.out.println("Distinct words: " + stats.keySet());

        phoneBook();
    }

    private static Map<String, Integer> distinctWords(String[] words) {
        Map<String, Integer> stats = new HashMap<>();

        for (String word : words) {
            stats.put(word, stats.getOrDefault(word, 0) + 1);
        }

        return stats;
    }

    private static void phoneBook() {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Aaaaa", "+7(999)999-991");
        phoneBook.add("Aaaaa", "+7(999)999-992");
        phoneBook.add("Bbbbb", "+7(999)999-993");
        phoneBook.add("Bbbbb", "+7(999)999-994");
        phoneBook.add("Ccccc", "+7(999)999-995");
        phoneBook.add("Ccccc", "+7(999)999-995");

        System.out.println("Aaaaa numbers: " + phoneBook.get("Aaaaa"));

        System.out.println(phoneBook);
    }
}

class PhoneBook {
    private final Map<String, Set<String>> data = new HashMap<>();

    public void add(String surname, String number) {
        data.computeIfAbsent(surname, k -> new HashSet<>()).add(number);
    }

    public Set<String> get(String surname) {
        return data.getOrDefault(surname, Collections.emptySet());
    }

    @Override
    public String toString() {
        return "PhoneBook: " + data;
    }
}
