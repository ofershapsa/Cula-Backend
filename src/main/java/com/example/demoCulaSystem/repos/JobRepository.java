package com.example.demoCulaSystem.repos;

import com.example.demoCulaSystem.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
