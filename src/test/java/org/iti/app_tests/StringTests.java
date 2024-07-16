package org.iti.app_tests;

import org.iti.app.StringManipulation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTests {

    // radar , iti, level ,mum, Noon
    private StringManipulation stringManipulation;

    private static Stream<Arguments> provideData() {

        return Stream.of(
                Arguments.of("radar", true),
                Arguments.of("mum", true),
                Arguments.of("level", true),
                Arguments.of("racecar", true),
                Arguments.of(" ", true),
                Arguments.of("test", false),
                Arguments.of("12345", false)
        );
    }

    @BeforeEach
    void setUp() {
        stringManipulation = new StringManipulation();
    }

    @ParameterizedTest
    @ValueSource(strings = {"radar", "level", "mum", "iti", "noon"})
    void testIsStringPalindrome(String input) {
        /*assertTrue(stringManipulation.isPalindrome("mum"));
        assertTrue(stringManipulation.isPalindrome("level"));
        assertTrue(stringManipulation.isPalindrome("radar"));*/

        assertTrue(stringManipulation.isPalindrome(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void testIsStringPalindrome2(String input, boolean expectedValue) {
        /*assertTrue(stringManipulation.isPalindrome("mum"));
        assertTrue(stringManipulation.isPalindrome("level"));
        assertTrue(stringManipulation.isPalindrome("radar"));*/

        assertEquals(expectedValue, stringManipulation.isPalindrome(input));
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void testIsStringPalindrome3(String input, boolean expectedValue) {
        assertEquals(expectedValue, stringManipulation.isPalindrome(input));
    }

}
