package com.example.demoCulaSystem.repos;


import com.example.demoCulaSystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    boolean existsByTitle(String title);
}
