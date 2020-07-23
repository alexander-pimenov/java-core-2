package dev.astamur.geekbrains.lessons.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReadFile {
    private Lock lock = new ReentrantLock();
    private int value = 0;

    public static void main(String[] args) {
        read();
        readWithResources();

        // Example with a lock and a finally block
        ReadFile counter = new ReadFile();

        Runnable action = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.increment();
            }
        };
        Thread thread1 = new Thread(action);
        Thread thread2 = new Thread(action);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + counter.value);

    }

    private static void read() {
        InputStream inputStream;
        BufferedReader reader = null;
        try {
            inputStream = ReadFile.class.getClassLoader().getResourceAsStream("text.txt");
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                // Do nothing
            }
        }
    }

    private static void readWithResources() {
        try (InputStream inputStream = ReadFile.class.getClassLoader().getResourceAsStream("text.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void increment() {
        lock.lock();
        try {
            value++;
            if (value % 1000 == 0) {
                throw new IllegalStateException(String.format("Exceptional situation in thread '%s'!",
                        Thread.currentThread().getName()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}
