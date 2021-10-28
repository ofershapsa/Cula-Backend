package com.example.demoCulaSystem.repos;

import com.example.demoCulaSystem.model.Category;
import com.example.demoCulaSystem.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {
    boolean existsByTitle(String title);

}
