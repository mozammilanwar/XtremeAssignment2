package com.example.XtremeAssignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.XtremeAssignment.model.Employee;
import com.example.XtremeAssignment.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	
	@Autowired 
	EmployeeService employeeService;
	
	 @GetMapping("/getemployee")
	    public ResponseEntity<?> searchEmployee(
	            @RequestParam(required = false) Long id) {
		 
		 Optional<Employee> employee=  employeeService.getEmployee(id);
		 
		 return ResponseEntity.ok().body(employee);

	    }
	 
	 @PostMapping("/saveemployee")
	    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		 
		 Employee output=  employeeService.saveEmployee(employee);
		 
		 return ResponseEntity.ok().body(output);

	    }

}
