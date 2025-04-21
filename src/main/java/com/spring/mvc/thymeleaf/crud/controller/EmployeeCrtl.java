package com.spring.mvc.thymeleaf.crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.thymeleaf.crud.entity.Employee;
import com.spring.mvc.thymeleaf.crud.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeCrtl {

	EmployeeService service;

	public EmployeeCrtl(EmployeeService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String listEmployees(Model model) {
		List<Employee> employeesList = service.findAll();

		model.addAttribute("employeesList", employeesList);

		return "list-employee";
	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.save(employee);
		return "redirect:/employees/";
	}

	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("employeeId") int employeeId, Model model) {
		Employee employee = service.findById(employeeId);
		model.addAttribute("employee", employee);
		return "employee-form";
	}

	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int employeeId) {
		service.deleteById(employeeId);
		return "redirect:/employees/";
	}
}
