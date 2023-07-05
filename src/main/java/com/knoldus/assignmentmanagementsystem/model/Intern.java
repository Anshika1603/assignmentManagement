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
     The unique identifier (ID) of the intern.
     */
    @Id
    private Integer internId;


    /**
     The employee ID of the intern.
     */
    private String empId;


    /**
     The competency name of the intern.
     */
    private String competencyName;


    /**
     The first name of the intern.
     */
    private String firstName;


    /**
     The last name of the intern.
     */
    private String lastName;


    /**
     The skills of the intern.
     */
    private String skills;

    /**
     The date when the intern was created. Defaults to the current date.
     */
    private LocalDate createdDate = LocalDate.now();


    /**
     The date when the intern was last modified. Defaults to the current date.
     */
    private LocalDate modifiedDate = LocalDate.now();

}
