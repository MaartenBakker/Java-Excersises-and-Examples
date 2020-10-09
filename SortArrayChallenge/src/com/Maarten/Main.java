package com.Maarten;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
	// write your code here

//
//        int[] array = getArray(5);
//        Arrays.sort(array);
//        printArray(array);

    }

    public static int[] getArray(int capacity) {

        int[] array = new int[capacity];
        System.out.println("Please enter " + capacity + " integer values.\r");
        for (int i = 0; i < capacity ; i++) {
                array[i] = scanner.nextInt();
        }

        return array;
        
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length ; i++) {

            System.out.println("Element " + i + " contents " + array[i]);
        }

    }

    public static int[] sortArray(int[] input) {

        int[] sortedArray = Arrays.copyOf(input, input.length);

            int temp;
            boolean is_sorted;

            for (int i = 0; i < sortedArray.length; i++) {

                is_sorted = true;

                for (int j = 1; j < (sortedArray.length - i); j++) {

                    if (sortedArray[j - 1] < sortedArray[j]) {
                        temp = sortedArray[j - 1];
                        sortedArray[j - 1] = sortedArray[j];
                        sortedArray[j] = temp;
                        is_sorted = false;
                    }

                }



            }
        return sortedArray;
    }





}
