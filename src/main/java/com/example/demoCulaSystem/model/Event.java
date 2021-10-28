package com.example.demoCulaSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date eventDate;
    private String description;
    private String title;
    private String location;
    private String address;
    private String image;


}
