package com.example.demoCulaSystem.services;

import com.example.demoCulaSystem.exceptions.ProjectException;
import com.example.demoCulaSystem.exceptions.UserException;
import com.example.demoCulaSystem.model.Project;

import com.example.demoCulaSystem.repos.ProjectRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) throws ProjectException {
        if(projectRepository.existsByProjectName(project.getProjectName())){
            throw new ProjectException("this name is already used");

        }
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Project project) throws ProjectException {
        return projectRepository.saveAndFlush(project);
    }

    @Override
    public void deleteProject(Long id) throws ProjectException {
        if (!projectRepository.existsById(id)) {
            throw new ProjectException("this task doesn't exists");
        }
        projectRepository.deleteById(id);
    }



    @Override
    public List<Project> getAllProjects() throws ProjectException {
        if (projectRepository.findAll().isEmpty()) {
            throw new ProjectException("sorry, no projects to show yet");
        }
        return  projectRepository.findAll();

    }
}
