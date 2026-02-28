package com.iiitb.spe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAddition() {
        assertEquals(10.0, Calculator.add(6, 4), 0.0001);
    }

    @Test
    void testSubtraction() {
        assertEquals(2.0, Calculator.subtract(6, 4), 0.0001);
    }

    @Test
    void testMultiplication() {
        assertEquals(24.0, Calculator.multiply(6, 4), 0.0001);
    }

    @Test
    void testDivision() {
        assertEquals(2.0, Calculator.divide(8, 4), 0.0001);
    }

    @Test
    void testSquareRoot() {
        assertEquals(4.0, Calculator.squareRoot(16), 0.0001);
    }

    @Test
    void testFactorial() {
        assertEquals(120, Calculator.factorial(5));
    }

    @Test
    void testNaturalLog() {
        assertEquals(Math.log(10), Calculator.naturalLog(10), 0.0001);
    }

    @Test
    void testPower() {
        assertEquals(8.0, Calculator.power(2, 3), 0.0001);
    }
}
