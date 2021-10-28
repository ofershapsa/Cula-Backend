package com.example.demoCulaSystem.services;

import com.example.demoCulaSystem.exceptions.TaskException;
import com.example.demoCulaSystem.exceptions.UserException;
import com.example.demoCulaSystem.model.Category;
import com.example.demoCulaSystem.model.Task;
import com.example.demoCulaSystem.repos.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) throws TaskException {

            if (taskRepository.existsByTitle(task.getTitle())) {
                throw new TaskException("this title is already exists");
        }
           return taskRepository.save(task);
    }


    @Override
    public Task updateTask(Task task) throws TaskException {
        return taskRepository.saveAndFlush(task);
    }

    @Override
    public void deleteTask(Long id) throws TaskException {
        if (!taskRepository.existsById(id)) {
            throw new TaskException("this task doesn't exists");
        }
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAllTasks() throws TaskException {
        if (taskRepository.findAll().isEmpty()) {
            throw new TaskException("sorry, no tasks to show yet");
        }
        List<Task> listOfTasks = taskRepository.findAll();
        return listOfTasks;
    }


}