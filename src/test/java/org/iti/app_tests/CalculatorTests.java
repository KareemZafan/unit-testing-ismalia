package org.iti.app_tests;

import org.iti.app.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CalculatorTests {

    private Calculator calculator;

    private static Stream<Arguments> provideData() {

        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(1, -2, -1),
                Arguments.of(1, 0, 1),
                Arguments.of(-20, -90, -110)
                );
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All Tests , it runs single time");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All Tests , it runs single time");
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Before each test method");
    }


    @DisplayName("ABC-123 Addition Functionality")
    @Tag("JAN")
    @ParameterizedTest
    @MethodSource("provideData")
    void testAddition(double a , double b , double result) {
        System.out.println("Addition test method");
        assertEquals(result, calculator.add(a, b));
    }

    @Test
    @Tag("JAN")
    @DisplayName("ABC-123 Subtraction Functionality")
    void testSubtraction() {
        assertEquals(-16, calculator.sub(2, 18));
        assertEquals(-1, calculator.sub(-2, -1));
        assertEquals(0, calculator.sub(-1, -1));
    }

    @Test
    @DisplayName("ABC-123 Test Multiply Function")
    void testMultiplication() {
        assertEquals(36, calculator.mul(2, 18));
        assertEquals(2, calculator.mul(-2, -1));
        assertEquals(1, calculator.mul(-1, -1));
        assertEquals(0, calculator.mul(0, -1000));
    }

    @Test
    // @Disabled("Not ready yet")
    // @EnabledOnOs(OS.MAC)
    @EnabledForJreRange(min = JRE.JAVA_16, max = JRE.JAVA_20)
    void testDivision() {

        assertEquals(2, calculator.div(30, 15));
        assertEquals(0.5, calculator.div(-2, -4));
        Exception ex = assertThrowsExactly(ArithmeticException.class, () -> calculator.div(2, 0));

        assertEquals("Division by zero!!!", ex.getMessage());

    }

    @Test
    void testModulus() {
        assertEquals(14, calculator.mod(30, 16));
        assertEquals(1, calculator.mod(1, 100));

    }

    @Test
    void testSquareRoot() {
        assertEquals(13, calculator.getSquareRoot(169));
        assertEquals(20, calculator.getSquareRoot(400));

    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test method");
    }
}
