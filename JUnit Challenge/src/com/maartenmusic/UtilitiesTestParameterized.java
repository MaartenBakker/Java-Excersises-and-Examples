package com.maartenmusic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UtilitiesTestParameterized {
    private Utilities utilities;

    @BeforeEach
    public void Setup() {
        utilities = new Utilities();
    }

    public static Stream<Parameter> parameters() {

        return Stream.of(new Parameter("ABCDEFF", "ABCDEF"),
                new Parameter("AB88EFFG", "AB8EFG"), new Parameter("112233445566", "123456"),
                        new Parameter("ZYZQQB", "ZYZQB"), new Parameter("A", "A"));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void removepairsParameterized(Parameter parameter){
        assertEquals(parameter.expected, utilities.removePairs(parameter.input));
    }




    static class Parameter {
        private String input;
        private String expected;

        public Parameter(String input, String expected) {
            this.input = input;
            this.expected = expected;
        }
    }
}
