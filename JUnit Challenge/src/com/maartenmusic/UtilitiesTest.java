package com.maartenmusic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {
    static private Utilities utilities;

    @BeforeEach
    public void setup(){
        utilities = new Utilities();
    }

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        char[] inputArray = "hello".toCharArray();
        char[] outputArray = utilities.everyNthChar(inputArray, 2);
        char[] expectedResult = {'e', 'l'};
        assertArrayEquals(expectedResult, outputArray);
    }

    @Test
    void everyNthChar_nIsGreaterThanLengthOfInputArray(){
        char[] inputArray = "hello".toCharArray();
        char[] outputArray = utilities.everyNthChar(inputArray, 6);
        assertArrayEquals(inputArray, outputArray);
    }

    @org.junit.jupiter.api.Test
    void removePairs() {
        assertEquals("ABCDEF", utilities.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", utilities.removePairs("ABCCABDEEF"));
        assertNull(utilities.removePairs(null));
        assertEquals("A", utilities.removePairs("A"));
        assertEquals("", utilities.removePairs(""));
    }


    @org.junit.jupiter.api.Test
    void converter() {
        int output = utilities.converter(10, 5);
        assertEquals(300, output);
    }

    @Test
    void converter_divideByZero() {
        assertThrows(ArithmeticException.class, () -> utilities.converter(10, 0));
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        String result = utilities.nullIfOddLength("Maarten");
        assertNull(result);
        result = utilities.nullIfOddLength("Bakker");
        assertNotNull(result);
    }
}