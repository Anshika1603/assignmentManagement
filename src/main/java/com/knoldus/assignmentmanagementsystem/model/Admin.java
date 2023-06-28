package com.knoldus.assignmentmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 The Admin class represents an admin in the Assignment Management System.
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    /**
     The AdminId field represents the unique identifier
     for an admin in the Assignment Management System.
     */
    @Id
    private Integer adminId;

    /**
     The name field represents the name of an admin
     in the Assignment Management System.
     */
    private String name;

    /**
     The studio field represents the studio associated with an admin in the
     Assignment Management System.
     */
    private String studio;
}
