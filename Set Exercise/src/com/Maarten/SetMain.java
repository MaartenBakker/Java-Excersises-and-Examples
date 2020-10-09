package com.Maarten;

import java.util.HashSet;
import java.util.Set;

public class SetMain {

    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100 ; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares.");
        System.out.println("There are " + cubes.size() + " cubes.");

        Set<Integer> allShapes = new HashSet<>(squares);
//        allShapes.addAll(squares);
        allShapes.addAll(cubes);

        System.out.println("There are " + allShapes.size() + " shapes.");

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("The size of intersection is " + intersection.size());

        for (Integer i: intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));

        }

    }
}
