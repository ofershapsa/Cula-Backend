package com.example.demoCulaSystem.services;

import com.example.demoCulaSystem.exceptions.TaskException;
import com.example.demoCulaSystem.exceptions.UserException;
import com.example.demoCulaSystem.model.Category;
import com.example.demoCulaSystem.model.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task) throws TaskException;

    Task updateTask(Task task) throws TaskException;

    void deleteTask(Long id) throws TaskException;

    List<Task> getAllTasks () throws TaskException;


}
