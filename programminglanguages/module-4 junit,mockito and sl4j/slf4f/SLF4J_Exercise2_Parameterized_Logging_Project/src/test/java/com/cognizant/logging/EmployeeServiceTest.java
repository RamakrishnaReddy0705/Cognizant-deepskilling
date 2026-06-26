
package com.cognizant.logging;

import com.cognizant.logging.service.EmployeeService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class EmployeeServiceTest {

    @Test
    void testParameterizedLogging() {

        EmployeeService employeeService =
                new EmployeeService();

        assertDoesNotThrow(() ->
                employeeService.displayEmployeeInformation(
                        101,
                        "Ramakrishna",
                        "Java Developer",
                        85000.00
                )
        );
    }
}
