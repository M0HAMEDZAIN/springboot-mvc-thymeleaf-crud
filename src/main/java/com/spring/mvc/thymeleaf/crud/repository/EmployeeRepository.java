package com.spring.mvc.thymeleaf.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.thymeleaf.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

}
