package dev.astamur.geekbrains.lessons.lesson3;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        // arrayLists();
        linkedLists();
    }

    private static void arrayLists() {
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println(numbers);
        System.out.printf("Size: %d. Capacity: %d.\n", numbers.size(), getCapacity(numbers));

        for (int i = 1; i <= 5; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);
        System.out.printf("Size: %d. Capacity: %d.\n", numbers.size(), getCapacity(numbers));

        for (int i = 6; i <= 16; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);
        System.out.printf("Size: %d. Capacity: %d.\n", numbers.size(), getCapacity(numbers));

        numbers.ensureCapacity(1000);

        System.out.println(numbers);
        System.out.printf("Size: %d. Capacity: %d.\n", numbers.size(), getCapacity(numbers));

        numbers.trimToSize();
        System.out.printf("Size: %d. Capacity: %d.\n", numbers.size(), getCapacity(numbers));

        for (int n : numbers) {
            System.out.printf("%d ", n);
        }
        System.out.println();

        Iterator<Integer> iterator  = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.printf("%s ", iterator.next());
            iterator.remove();
        }
        System.out.println();
        System.out.printf("Size: %d. Capacity: %d.\n", numbers.size(), getCapacity(numbers));
    }

    private static void linkedLists() {
        LinkedList<Integer> numbers = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);

        numbers.addFirst(0);
        numbers.addLast(6);

        // numbers.offerFirst(0);
        // numbers.offerLast(6);

        System.out.println(numbers);
    }

    private static <S> int getCapacity(List<S> list) {
        try {
            Field elementData = ArrayList.class.getDeclaredField("elementData");
            elementData.setAccessible(true);
            return ((Object[]) elementData.get(list)).length;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}