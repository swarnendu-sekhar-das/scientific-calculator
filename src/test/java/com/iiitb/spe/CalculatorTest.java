package com.iiitb.spe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testSquareRoot() {
        assertEquals(4.0, Calculator.squareRoot(16));
    }

    @Test
    void testFactorial() {
        assertEquals(120, Calculator.factorial(5));
    }

    @Test
    void testNaturalLog() {
        assertEquals(Math.log(10), Calculator.naturalLog(10));
    }

    @Test
    void testPower() {
        assertEquals(8, Calculator.power(2,3));
    }
}