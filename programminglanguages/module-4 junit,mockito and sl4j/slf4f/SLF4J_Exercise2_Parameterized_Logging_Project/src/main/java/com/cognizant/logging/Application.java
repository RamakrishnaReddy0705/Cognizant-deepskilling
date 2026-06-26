
package com.cognizant.logging;

import com.cognizant.logging.service.EmployeeService;

public class Application {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        employeeService.displayEmployeeInformation(101,"Ramakrishna","Java Developer",85000.00);
    }
}
