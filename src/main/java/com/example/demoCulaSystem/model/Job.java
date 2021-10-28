package com.example.demoCulaSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String title;
    private  String description;
    private  String email;
    @Enumerated(EnumType.STRING)
    private  Category category;
    private int experience;
    private Date startDate;
}
