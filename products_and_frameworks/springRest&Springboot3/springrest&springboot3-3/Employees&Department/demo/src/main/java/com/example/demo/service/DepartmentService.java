package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Department;
import com.example.demo.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao dao;

    public List<Department> getAllDepartments() {

        return dao.getAllDepartments();

    }

}