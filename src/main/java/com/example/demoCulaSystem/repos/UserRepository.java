package com.example.demoCulaSystem.repos;

import com.example.demoCulaSystem.model.Category;
import com.example.demoCulaSystem.model.Task;
import com.example.demoCulaSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
    List<User> getUsersByInterest(Category interest);
    List<User> getUsersByTasksId(Long taskId);

}
