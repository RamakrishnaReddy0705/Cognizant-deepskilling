
package com.example.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceParameterizedTest {

    private final CalculatorService service =
            new CalculatorService();

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,3,5",
            "10,20,30",
            "-5,5,0",
            "100,200,300",
            "0,0,0"
    })
    @DisplayName("Parameterized addition test")
    void testAdd(int a,int b,int expected){

        assertEquals(
                expected,
                service.add(a,b)
        );
    }
}
