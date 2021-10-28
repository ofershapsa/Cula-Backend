package com.example.demoCulaSystem.services;

import com.example.demoCulaSystem.exceptions.UserException;
import com.example.demoCulaSystem.model.Category;
import com.example.demoCulaSystem.model.Task;
import com.example.demoCulaSystem.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user) throws UserException;

    void updateUser(User user) throws UserException;

    void deleteUser(Long id) throws UserException;

    List<User> getAllUsers() throws UserException;

    List<User> getUsersByCategory(Category interest) throws UserException;

    List<User> getUsersByTasks(Long taskId) throws UserException;
}
