package com.example.demoCulaSystem.services;

import com.example.demoCulaSystem.exceptions.JobException;
import com.example.demoCulaSystem.model.Job;

import java.util.List;

public interface JobService {
    Job createJob(Job job) throws JobException;
    Job updateJob(Job job) throws JobException;
    void deleteJob(Long id) throws JobException;
    List<Job> getAllJobs() throws JobException;
}
