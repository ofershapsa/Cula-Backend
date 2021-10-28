package com.example.demoCulaSystem.repos;

import com.example.demoCulaSystem.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    boolean existsByProjectName(String projectName);
}
