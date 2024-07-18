package com.example.XtremeAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.XtremeAssignment.model.Employee;
import com.example.XtremeAssignment.model.Project;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
  Optional<Project> findByProjectName(String projectName);

}
