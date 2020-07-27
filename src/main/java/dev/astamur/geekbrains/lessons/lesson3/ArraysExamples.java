package dev.astamur.geekbrains.lessons.lesson3;

import java.util.Arrays;

public class ArraysExamples {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));

        // Хотим увеличить массив
        arr = increase(arr, 2);
        System.out.println(Arrays.toString(arr));

        // Долгие вычислегния
        // ...
    }

    private static int[] increase(int[] arr, int ratio) {
        int[] arrNew = new int[arr.length * ratio];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        return arrNew;
    }
}
