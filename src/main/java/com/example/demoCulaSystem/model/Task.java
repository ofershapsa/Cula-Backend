package com.example.demoCulaSystem.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String taskCategory;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
    private TaskPriority taskPriority;
    @ManyToMany
    @JoinTable(name = "users_tasks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<User> team;
    @ManyToMany
    private List<User> adminsTask;


}
