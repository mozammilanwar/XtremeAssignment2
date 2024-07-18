package com.example.XtremeAssignment.controller;
import com.example.XtremeAssignment.model.Employee;
import com.example.XtremeAssignment.model.Manager;
import com.example.XtremeAssignment.model.Project;
import com.example.XtremeAssignment.service.EmployeeService;
import com.example.XtremeAssignment.service.ManagerService;
import com.example.XtremeAssignment.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ManagerService managerService;

    @GetMapping("/getProjectAllocation")
    public ResponseEntity<Map<String, Object>> getProjectAllocation(@RequestParam Long  projectId) {
        Map<String, Object> result = new HashMap<>();
        try {

            Optional<Project> project = projectService.getProjectById(projectId);
            if (project.isPresent()) {
                result.put("projectName", project.get().getProjectName());


                List<Employee> employees = employeeService.getEmployeesByProjectId(projectId);
                List<String> employeeNames = new ArrayList<String>();
                for (Employee employee : employees) {
                    employeeNames.add(employee.getFirstName());
                }
                result.put("employees", employeeNames.toArray(new String[employeeNames.size()]));

                // Fetch Manager by Project ID
                Optional<Manager> manager = managerService.getManagerByProjectId(projectId);
                if (manager.isPresent()) {
                    result.put("managerName", manager.get().getManagerName());
                }

                return ResponseEntity.ok(result);
            } else {
                result.put("error", "Project not found");
                return ResponseEntity.status(404).body(result);
            }
        } catch (Exception e) {
            result.put("error", "Error retrieving project allocation: " + e.getMessage());
            return ResponseEntity.status(500).body(result);

        }
    }
    @GetMapping("/getByName")
    public ResponseEntity<?> getProjectByName(@RequestParam String projectName) {
        Optional<Project> project = projectService.getProjectByName(projectName);
        if (project.isPresent()) {
            return ResponseEntity.ok(project.get());
        } else {
            return ResponseEntity.status(404).body("Project not found");
        }
    }
}