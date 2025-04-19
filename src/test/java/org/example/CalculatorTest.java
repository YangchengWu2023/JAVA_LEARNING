package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    // Create an instance to test
    private final Calculator calculator = new Calculator();

    @Test
    void testAnnotations() {
        Author author = Calculator.class.getAnnotation(Author.class);
        assertEquals(author.location(), "hello");
    }

    @Test
    void testAddition() {
        // Basic assertion
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
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

    @Test
    void testMultipleAdditions() {
        // Grouped assertions - all will run even if one fails
        assertAll(
                () -> assertEquals(3, calculator.add(1, 2)),
                () -> assertEquals(0, calculator.add(-1, 1)),
                () -> assertEquals(10, calculator.add(5, 5))
        );
    }
}