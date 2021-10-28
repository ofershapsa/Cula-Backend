package com.example.demoCulaSystem.controllers;

import com.example.demoCulaSystem.exceptions.ProjectException;
import com.example.demoCulaSystem.exceptions.TaskException;
import com.example.demoCulaSystem.model.Project;
import com.example.demoCulaSystem.model.Task;
import com.example.demoCulaSystem.model.User;
import com.example.demoCulaSystem.services.ProjectService;
import com.example.demoCulaSystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", value = "*")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Project project) throws ProjectException {
        return new ResponseEntity<>(projectService.createProject(project), HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> updateTask(@RequestBody Project project) throws ProjectException {
        return new ResponseEntity<>(projectService.updateProject(project), HttpStatus.OK);
    }

    //works
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        try {
            projectService.deleteProject(id);
            System.out.println("peoject deleted: " + id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    // works
    @GetMapping
    public ResponseEntity<?> getAllProjects() throws ProjectException {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }
}