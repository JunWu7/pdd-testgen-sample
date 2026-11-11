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

    /**
     * n! for 0 <= n <= 20.
     *
     * @throws IllegalArgumentException when {@code n} is negative or greater than 20
     */
    public long factorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("n must be between 0 and 20");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * {@code part} as a percentage of {@code whole}, rounded to two decimal places.
     *
     * @throws IllegalArgumentException when {@code whole} is zero
     */
    public double percentage(double part, double whole) {
        if (whole == 0) {
            throw new IllegalArgumentException("whole must not be zero");
        }
        return Math.round(part / whole * 10000.0) / 100.0;
    }
}
