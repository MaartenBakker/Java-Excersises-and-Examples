package com.Maarten;

import java.util.Scanner;

public class Main {

        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {

            System.out.println("Please enter a number.\r");
            int count = scanner.nextInt();
            scanner.nextLine();

            int[] array = readIntegers(count);
            int min = findMin(array);
            System.out.println("The minimum number entered is " + min);

            scanner.close();
        }


        public static int[] readIntegers(int count){

            int[] array = new int[count];
            System.out.println("Please enter " + count + " numbers.\r");

            for (int i = 0; i < array.length ; i++) {
                array[i] = scanner.nextInt();
                scanner.nextLine();
            }
            return array;
        }

        public static int findMin(int[] array) {
            int min = array[0];

            for (int i = 0; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                }
            }
            return min;
        }
}
