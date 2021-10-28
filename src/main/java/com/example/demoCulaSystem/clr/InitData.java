package com.example.demoCulaSystem.clr;

import com.example.demoCulaSystem.model.Category;
import com.example.demoCulaSystem.model.Task;
import com.example.demoCulaSystem.model.TaskStatus;
import com.example.demoCulaSystem.model.User;
import com.example.demoCulaSystem.repos.TaskRepository;
import com.example.demoCulaSystem.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@Component
@Order(1)
@RequiredArgsConstructor
class InitData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = User.builder()
                .firstName("ben")
                .lastName("miller")
                .email("ben@gmail.com").interest(Category.FULLSTACK)
                .build();

        userRepository.save(user1);


        Task task1 = Task.builder()
                .adminsTask(Arrays.asList(user1))
                .taskStatus(TaskStatus.STARTED)
                .title("meeting in ...")
                .build();

        System.out.println(task1);
        taskRepository.save(task1);


        User user2 = User.builder()
                .firstName("Ofer")
                .lastName("Amit")
                .email("oferA@gmail.com").interest(Category.AUTOMATION)
                .build();

        userRepository.save(user2);


        Task task2 = Task.builder()
                .adminsTask(Arrays.asList(user2))
                .taskStatus(TaskStatus.COMPLETED)
                .title("meeting in ...")
                .build();
        System.out.println(task2);
        taskRepository.save(task2);
    }
}
