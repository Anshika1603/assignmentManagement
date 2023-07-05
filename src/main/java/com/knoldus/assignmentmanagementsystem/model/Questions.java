package com.knoldus.assignmentmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 The Questions class represents a question in the system.
 */
@Data
@AllArgsConstructor
public class Questions {

    /**
     The unique identifier (ID) of the question.
     */
    private Integer id;

    /**
     The text of the question.
     */
    private String question;
}
