package com.example.demoCulaSystem.services;

import com.example.demoCulaSystem.exceptions.ProjectException;
import com.example.demoCulaSystem.exceptions.UserException;

import com.example.demoCulaSystem.model.Project;


import java.util.List;

public interface ProjectService {

    Project createProject(Project project) throws ProjectException;

    Project updateProject(Project project) throws ProjectException;

    void deleteProject(Long id) throws ProjectException;

    List<Project> getAllProjects() throws ProjectException;
}
