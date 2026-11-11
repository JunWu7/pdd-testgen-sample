package com.example.toolkit;

/**
 * Basic arithmetic on integers.
 */
public class Calculator {

    public int add(int a, int b) {
        return Math.addExact(a, b);
    }

    public int subtract(int a, int b) {
        return Math.subtractExact(a, b);
    }

    public int multiply(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    /**
     * Integer division.
     *
     * @throws IllegalArgumentException when {@code divisor} is zero
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("divisor must not be zero");
        }
        return dividend / divisor;
    }
}
