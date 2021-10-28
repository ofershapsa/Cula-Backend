package com.example.demoCulaSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private String description;
    private Date startDate;
    private Date endDate;
    @Enumerated(EnumType.STRING)
     private ProjectStatus projectStatus;

    @OneToMany
    private List<Task> tasks;


}
