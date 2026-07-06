package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {

        System.out.println("Department REST Service Called");

        return service.getAllDepartments();

    }

}