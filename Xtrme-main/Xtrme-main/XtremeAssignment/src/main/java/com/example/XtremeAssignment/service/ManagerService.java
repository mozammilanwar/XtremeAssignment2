package com.example.XtremeAssignment.service;

import com.example.XtremeAssignment.model.Employee;
import com.example.XtremeAssignment.model.Manager;
import com.example.XtremeAssignment.repository.EmployeeRepository;
import com.example.XtremeAssignment.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    public Manager getManagerByEmployeeId(int employeeId) {
        try {
            Optional<Manager> manager = managerRepository.findByEmpId(employeeId);
            return manager.get() ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Optional<Manager> getManagerByProjectId(Long projectId) {
        try {
            return managerRepository.findByProjectId(projectId);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }



}
