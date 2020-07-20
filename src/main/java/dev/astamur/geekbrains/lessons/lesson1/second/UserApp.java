package dev.astamur.geekbrains.lessons.lesson1.second;

import dev.astamur.geekbrains.lessons.lesson1.User;

public class UserApp {
    public static void main(String[] args) {
        doSomething();

        // ...
    }

    private static void doSomething() {
        User user = User.create("User 1", 20);
        user.info();
    }
}