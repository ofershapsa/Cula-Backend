package com.example.demoCulaSystem.controllers;

import com.example.demoCulaSystem.exceptions.EventException;

import com.example.demoCulaSystem.model.Event;

import com.example.demoCulaSystem.services.EventServeice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", value = "*")
public class EventController {

    private final EventServeice eventServeice;

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody Event event) throws EventException {
        return new ResponseEntity<>(eventServeice.createEvent(event), HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> updateEvent(@RequestBody Event event) throws EventException {
        return new ResponseEntity<>(eventServeice.updateEvent(event), HttpStatus.OK);
    }

    //works
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) throws EventException{
        try {
            eventServeice.deleteEvent(id);
            System.out.println("event deleted: " + id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    // works
    @GetMapping
    public ResponseEntity<?> getAllEvents() throws EventException {
        return new ResponseEntity<>(eventServeice.getAllEvents(), HttpStatus.OK);
    }
}

