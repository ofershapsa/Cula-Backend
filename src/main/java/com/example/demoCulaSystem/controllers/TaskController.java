package com.example.demoCulaSystem.controllers;



import com.example.demoCulaSystem.exceptions.TaskException;
import com.example.demoCulaSystem.exceptions.UserException;
import com.example.demoCulaSystem.model.Task;
import com.example.demoCulaSystem.services.TaskService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", value = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task) throws TaskException {
      return new ResponseEntity<>(taskService.createTask(task),HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> updateTask(@RequestBody Task task) throws TaskException {
        return new ResponseEntity<>(taskService.updateTask(task), HttpStatus.OK);
    }

    //works
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        try {
            taskService.deleteTask(id);
            System.out.println("task deleted: " + id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    // works
    @GetMapping
    public ResponseEntity<?> getAllTask() throws  TaskException {
     return new ResponseEntity<>(taskService.getAllTasks(),HttpStatus.OK);
    }


}



