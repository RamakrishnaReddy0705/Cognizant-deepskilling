
package com.example.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("Should add two positive numbers")
    void testAddPositiveNumbers() {
        assertEquals(5, calculatorService.add(2, 3));
    }

    @Test
    @DisplayName("Should add negative numbers")
    void testAddNegativeNumbers() {
        assertEquals(-5, calculatorService.add(-2, -3));
    }

    @Test
    @DisplayName("Should add positive and negative number")
    void testAddMixedNumbers() {
        assertEquals(1, calculatorService.add(3, -2));
    }

    @Test
    @DisplayName("Should add zeros")
    void testAddZeros() {
        assertEquals(0, calculatorService.add(0, 0));
    }
}
