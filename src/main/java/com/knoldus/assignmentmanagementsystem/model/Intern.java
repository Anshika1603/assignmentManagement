package com.knoldus.assignmentmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 The Intern class represents an intern in the Assignment Management System.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Intern {
    /**
     * The internId field represents the unique identifier for an intern
     * in the Assignment Management System.
     */
    @Id
    private Integer internId;

    private String empId;

    private String competencyName;

    private String firstName;

    private String lastName;

    private String skills;

    private LocalDate createdDate=LocalDate.now();

    private LocalDate modifiedDate=LocalDate.now();
}
