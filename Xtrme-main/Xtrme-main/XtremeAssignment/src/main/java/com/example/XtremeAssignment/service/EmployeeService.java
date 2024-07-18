package com.example.XtremeAssignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.XtremeAssignment.model.Employee;
import com.example.XtremeAssignment.repository.EmployeeRepository;

@Service
public class EmployeeService {

	
	@Autowired
	EmployeeRepository employeeRepository;

	
	
	public Employee saveEmployee(Employee employee) {
		Employee result=null;
		try {
			result = employeeRepository.save(employee);
		} catch (Exception e) {
				
			e.printStackTrace();
		}
		return result;
	}
	
	
	public Optional<Employee> getEmployee(Long id) {
		Optional<Employee> result=null;
		try {
			result = employeeRepository.findById(id);
		} catch (Exception e) {
				
			e.printStackTrace();
		}
		return result;
	}

	public List<Employee> getEmployeesByProjectId(Long projectId) {
		try {
			return employeeRepository.findAllByProjectId(projectId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
