
package com.cognizant.logging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeService.class);

    public void displayEmployeeInformation(
            int employeeId,
            String employeeName,
            String designation,
            double salary) {

        LOGGER.info(
                "Employee Details -> Id: {}, Name: {}, Designation: {}, Salary: {}",
                employeeId,
                employeeName,
                designation,
                salary
        );

        LOGGER.warn(
                "Employee {} salary is being processed for payroll",
                employeeName
        );

        LOGGER.debug(
                "Debug Information -> Employee Id {} validated successfully",
                employeeId
        );
    }
}
