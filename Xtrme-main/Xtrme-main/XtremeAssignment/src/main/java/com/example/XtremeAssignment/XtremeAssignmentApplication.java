package com.example.XtremeAssignment;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.XtremeAssignment.model.Employee;
import com.example.XtremeAssignment.model.Manager;
import com.example.XtremeAssignment.model.Project;
import com.example.XtremeAssignment.service.EmployeeService;
import com.google.gson.Gson;

@SpringBootApplication
public class XtremeAssignmentApplication {

	public static void main(String[] args)  {
		SpringApplication.run(XtremeAssignmentApplication.class, args);
	}

	
	


}
