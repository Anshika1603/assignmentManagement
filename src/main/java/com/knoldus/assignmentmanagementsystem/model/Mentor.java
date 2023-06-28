package com.knoldus.assignmentmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 The Mentor class represents a mentor in the Assignment Management System.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mentor {

    /**
     The EmployeeId field represents the unique identifier for a mentor
     in the Assignment Management System.
     */
    @Id
    private Integer employeeId;

    /**
     The name field represents the name of a mentor, and the
     studio field represents the studio
     associated with the mentor.
     */
    private String name;

    /**
     The studio field represents
     the studio associated with a mentor in the Assignment Management System.
     */
    private String studio;
}
