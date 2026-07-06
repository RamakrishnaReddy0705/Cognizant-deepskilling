package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;



@Service
public class EmployeeService {

    @Autowired
    private ApplicationContext context;

    public List<Employee> getEmployees() {

        List<Employee> employees = new ArrayList<>();

        employees.add(context.getBean("employee1", Employee.class));
        employees.add(context.getBean("employee2", Employee.class));
        employees.add(context.getBean("employee3", Employee.class));

        return employees;
    }

    public Employee getEmployeeById(int id) {

        return getEmployees()
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

    }

}