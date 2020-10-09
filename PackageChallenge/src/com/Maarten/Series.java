package com.Maarten;

public class Series {

    public static int nSum (int n) {
        int sum = 0;

        for (int i = 0; i <= n ; i++) {
            sum += i;
        }
         return sum;
    }

    public static int factorial (int n) {
        int factorial = 1;
        for (int i = 1; i <= n ; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int fibonacci(int n) {

        if (n == 0) return 0;
        else if (n == 1) return 1;

        else {
            int[] array = new int[n + 1];
            array[0] = 0;
            array[1] = 1;

            for (int i = 2; i < array.length; i++) {
                array[i] = (array[i - 1] + array[i - 2]);
            }
            return array[n];
        }
    }
}
