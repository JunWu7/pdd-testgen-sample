package com.example.toolkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void addReturnsSum() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void addThrowsOnOverflow() {
        assertThrows(ArithmeticException.class, () -> calculator.add(Integer.MAX_VALUE, 1));
    }

    @Test
    void subtractReturnsDifference() {
        assertEquals(-1, calculator.subtract(2, 3));
    }

    @Test
    void multiplyReturnsProduct() {
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    void divideTruncatesTowardZero() {
        assertEquals(-2, calculator.divide(-7, 3));
    }

    @Test
    void divideByZeroIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
    }
}
