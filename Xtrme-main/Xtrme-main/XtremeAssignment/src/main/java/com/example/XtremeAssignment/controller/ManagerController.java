package com.example.XtremeAssignment.controller;

import com.example.XtremeAssignment.model.Manager;
import com.example.XtremeAssignment.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/getByEmployeeId")
    public ResponseEntity<?> getManagerByEmployeeId(@RequestParam ("id") int employeeId) {
        Manager manager = managerService.getManagerByEmployeeId(employeeId);
        if (manager!=null) {
            return ResponseEntity.ok().body(manager);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
