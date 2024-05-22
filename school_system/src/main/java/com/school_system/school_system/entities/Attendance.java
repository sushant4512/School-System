package com.school_system.school_system.entities;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.Date;
@Entity
@Data
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private boolean present;

    @ManyToOne
    private Student student;
}



