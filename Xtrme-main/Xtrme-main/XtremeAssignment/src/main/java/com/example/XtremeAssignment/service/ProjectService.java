package com.example.XtremeAssignment.service;

import com.example.XtremeAssignment.model.Project;
import com.example.XtremeAssignment.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
public Optional<Project> getProjectByName(String projectName) {
    return projectRepository.findByProjectName(projectName);
}
    public Optional<Project> getProjectById(Long id) {
        try {
            return projectRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }
}
