package com.example.demoCulaSystem.controllers;

import com.example.demoCulaSystem.exceptions.JobException;
import com.example.demoCulaSystem.model.Job;
import com.example.demoCulaSystem.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("jobs")
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", value = "*")
public class JobController {
    private final JobService jobService;

    @PostMapping
    public ResponseEntity<?> createJob(@RequestBody Job job) throws JobException {
        return new ResponseEntity<>(jobService.createJob(job), HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> updateJob(@RequestBody Job job) throws JobException {
        return new ResponseEntity<>(jobService.updateJob(job), HttpStatus.OK);
    }

    //works
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable Long id) throws JobException{
        try {
            jobService.deleteJob(id);
            System.out.println("Job deleted: " + id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    // works
    @GetMapping
    public ResponseEntity<?> getAllJobs() throws JobException {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }
}