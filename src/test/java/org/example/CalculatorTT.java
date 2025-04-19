package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTT {
    // Create an instance to test
    private final Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        // Basic assertion
        assertEquals(5, calculator.add(2, 10), "2 + 3 should equal 5");
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    void testDivisionByZero() {
        // Verify exception is thrown
        assertThrows(ArithmeticException.class,
                () -> calculator.divide(1, 0));
    }

}