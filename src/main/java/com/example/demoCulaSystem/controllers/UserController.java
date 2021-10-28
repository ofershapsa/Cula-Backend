package com.example.demoCulaSystem.controllers;

import com.example.demoCulaSystem.exceptions.EventException;
import com.example.demoCulaSystem.exceptions.UserException;
import com.example.demoCulaSystem.model.Category;
import com.example.demoCulaSystem.model.Event;
import com.example.demoCulaSystem.model.Task;
import com.example.demoCulaSystem.model.User;
import com.example.demoCulaSystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", value = "*")
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> createUser(@RequestBody User user) throws UserException {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) throws UserException {
        userService.updateUser(user);
        return new ResponseEntity<> (HttpStatus.OK);
    }


    //works
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) throws UserException{
        try {
            userService.deleteUser(id);
            System.out.println("user deleted: " + id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    // works
    @GetMapping
    public ResponseEntity<?> getAllEvents() throws  UserException {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{interest}")
    public ResponseEntity<?> getAllUsersByInterest(@PathVariable Category interest) throws UserException {
        return new ResponseEntity<>(userService.getUsersByCategory(interest), HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<?> getUsersByTasks(@PathVariable Long taskId) throws UserException {
        return new ResponseEntity<>(userService.getUsersByTasks(taskId), HttpStatus.OK);
    }
}





