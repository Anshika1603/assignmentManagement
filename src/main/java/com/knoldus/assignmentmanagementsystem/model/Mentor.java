package com.knoldus.assignmentmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


/**
 The Mentor class represents a mentor in the Assignment Management System.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mentor {

    /**
     The unique identifier (ID) for the mentor.
     It represents the employee ID of the mentor.
     */
    @Id
    private Integer mentorId;


    /**
     The employee ID of the mentor.
     */
    private String empId;


    /**
     The competency name of the mentor.
     */
    private String competencyName;


    /**
     The date when the mentor record was created.
     It is initialized with the current date.
     */
    private LocalDate createdDate = LocalDate.now();


    /**
     The date when the mentor record was last modified.
     It is initialized with the current date.
     */
    private LocalDate modifiedDate = LocalDate.now();
}
