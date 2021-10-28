package com.example.demoCulaSystem.services;

import com.example.demoCulaSystem.exceptions.JobException;
import com.example.demoCulaSystem.exceptions.TaskException;
import com.example.demoCulaSystem.model.Job;
import com.example.demoCulaSystem.model.Task;
import com.example.demoCulaSystem.repos.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public Job createJob(Job job) throws JobException {
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Job job) throws JobException{
        return jobRepository.saveAndFlush(job);
    }

    @Override
    public void deleteJob(Long id) throws JobException {
        jobRepository.deleteById(id);
    }

    @Override
    public List<Job> getAllJobs() throws JobException {
        if (jobRepository.findAll().isEmpty()) {
            throw new JobException("sorry, no jobs to show yet");
        }

        return jobRepository.findAll();
    }

}

