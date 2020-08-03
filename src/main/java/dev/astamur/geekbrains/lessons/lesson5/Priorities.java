package dev.astamur.geekbrains.lessons.lesson5;

import java.util.Arrays;

public class Priorities {
    public static void main(String[] args) throws InterruptedException {
        Counter[] counters = new Counter[50];
        Thread[] threads = new Thread[50];

        for (int i = 0; i < 50; i++) {
            final int index = i;
            counters[i] = new Counter();
            threads[i] = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    counters[index].increment();
                }
            });
            threads[i].setPriority(i % 2 == 0 ? Thread.MAX_PRIORITY : Thread.MIN_PRIORITY);
            threads[i].start();
        }

        Thread.sleep(10_000);

        Arrays.stream(threads).forEach(Thread::interrupt);

        for (Thread thread : threads) {
            thread.join();
        }

        for (int i = 0; i < counters.length; i++) {
            System.out.printf("Counter %d : %d\n", i, counters[i].get());
        }
    }

    private static class Counter {
        private long value = 0;

        public long get() {
            return value;
        }

        public void increment() {
            value++;
        }
    }
}