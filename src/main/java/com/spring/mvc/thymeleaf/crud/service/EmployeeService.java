package com.spring.mvc.thymeleaf.crud.service;

import java.util.List;

import com.spring.mvc.thymeleaf.crud.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
