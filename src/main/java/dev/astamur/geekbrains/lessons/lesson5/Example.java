package dev.astamur.geekbrains.lessons.lesson5;

public class Example {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello! Thread: " + Thread.currentThread().getName());

        MyTread additional = new MyTread();
        // Thread additional = new Thread(new Task());
        // additional.setDaemon(true);
        System.out.printf("MyThread state: %s\n", additional.getState());
        additional.start();

        Thread.sleep(5000);

        additional.interrupt();
        additional.join();

        System.out.printf("MyThread state: %s\n", additional.getState());

        System.out.println("Bye! Thread: " + Thread.currentThread().getName());
    }
}

class MyTread extends Thread {
    @Override
    public void run() {
        int i = 1;
        while (true) {
            try {
                System.out.printf("Value: %d. Thread: %s. Status: %s\n", i++,
                        Thread.currentThread().getName(), Thread.currentThread().getState());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(String.format("Thread '%s' was interrupted", Thread.currentThread().getName()));
                return;
            }
        }
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        while (true) {
            int i = 1;
            try {
                System.out.printf("Counter: %s. Thread: %s\n", i++, Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(String.format("Thread '%s' was interrupted", Thread.currentThread().getName()));
                return;
            }
        }
    }
}