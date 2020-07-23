package dev.astamur.geekbrains.lessons.lesson2;

public class ArithmeticExample {
    public static void main(String[] args) {
        try {
            wrongCalc(42, 0);
        } catch (MyCheckedException e) {
            System.out.println(e.getMessage());
        }

        int[] numbers = new int[]{0, 1, 2, 3, 4, 5};
        // System.out.println(calc(numbers));
        try {
            System.out.println(calcWithValidation(numbers));
        } catch (MyCheckedException e) {
            e.printStackTrace();
        }

        System.out.println("Программа завершена!");
    }

    private static void wrongCalc(int a, int b) throws MyCheckedException {
        try {
            System.err.println(a / b);
        } catch (ArithmeticException e) {
            throw new MyCheckedException("Деление на ноль", e);
        }
    }

    public static int calc(int[] numbers) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= numbers.length; i++) {
            try {
                result = result / numbers[i];
            } catch (ArithmeticException e) {
                System.out.println("Деление на ноль! Result: " + result);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Вышли за пределы массива!");
            } catch (Throwable t) {
                System.out.println("Что-то пошло не так!");
            }
        }

        return result;
    }

    public static int calcWithValidation(int[] numbers) throws MyCheckedException {
        for (int n : numbers) {
            if (n == 0) {
                throw new MyCheckedException("В массиве есть 0!");
            }
        }

        int result = 1;

        for (int i = 0; i <= numbers.length; i++) {
            result = result / numbers[i];
        }

        return result;
    }
}

class MyCheckedException extends Exception {
    public MyCheckedException(String message) {
        super(message);
    }

    public MyCheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}

class ArrayWithZeroException extends RuntimeException {
    // Дополнительные поля в классе исключения

    public ArrayWithZeroException(String message) {
        super(message);
    }

    // Геттеры, сеттеры и т.д.
}
