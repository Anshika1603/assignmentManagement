package com.knoldus.assignmentmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    /**
     The name field represents the name of an intern
     in the Assignment Management System.
     */
    private String name;

    /**
    The Studio field represents the studio associated with an intern in the
     Assignment Management System.
    */
    private String studio;
}
