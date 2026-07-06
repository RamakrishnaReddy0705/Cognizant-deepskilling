package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Department;

@Repository
public class DepartmentDao {

    public static List<Department> DEPARTMENT_LIST;

    @Autowired
    private ApplicationContext context;

    public List<Department> getAllDepartments() {

        if (DEPARTMENT_LIST == null) {

            DEPARTMENT_LIST = new ArrayList<>();

            DEPARTMENT_LIST.add(context.getBean("department1", Department.class));
            DEPARTMENT_LIST.add(context.getBean("department2", Department.class));
            DEPARTMENT_LIST.add(context.getBean("department3", Department.class));
        }

        return DEPARTMENT_LIST;
    }

}