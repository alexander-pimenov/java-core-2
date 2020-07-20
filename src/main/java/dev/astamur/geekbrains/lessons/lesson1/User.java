package dev.astamur.geekbrains.lessons.lesson1;

public class User {
    private final static String TYPE = "Human";

    private int id;
    private String name;
    private String position;
    private int age;

    protected User() {
    }

    public User(int id, String name, String position, int age) {
        this.id = id;
        this.name = name;
        this.position = position;
        setAge(age);
    }

    private User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age can not be negative number");
        }

        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void info() {
        System.out.println("id: " + id + "; Имя пользователя: " + name + "; Должность: " + position + "; Возраст: " + age);
    }

    public static String type() {
        return TYPE;
    }

    public static User create(String name, int age) {
        return new User(name, age);
    }

    public static void main(String[] args) {
        // User user = new User();
        // User user1 = new User(1, "Test User 1", "Worker", 30);
        // User user2 = new User("Test User 2", 35);
        // user1.info();
        // user2.info();
        // System.out.println("Возраст: " + user2.getAge());

        System.out.println("Тип: " + User.type());
    }
}