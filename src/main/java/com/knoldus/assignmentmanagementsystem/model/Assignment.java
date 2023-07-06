package com.knoldus.assignmentmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;
import java.util.List;


/**
 The Assignment class represents an assignment document
 stored in a document-oriented database.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Assignment {

    /**
     The technology associated with the assignment.
     */
    private String technology;


    /**
     The unique identifier (ID) of the assignment topic.
     */
    @Id
    private String topic;


    /**
     The username of the user who created the assignment.
     */
    private String createdBy;


    /**
     The username of the user to whom the assignment is assigned.
     */
    private String assignedTo;


    /**
     The list of questions associated with the assignment.
     */
    private List<Questions> questions;


    /**
     The list of answers submitted for the assignment questions.
     */
    private List<Answers> answers;


    /**
     The status of the assignment (e.g., "in progress", "completed").
     */
    private String status;


    /**
     The date when the assignment was created. Defaults to the current date.
     */
    private LocalDate createdDate = LocalDate.now();


    /**
     The date when the assignment was last modified.
     Defaults to the current date.
     */
    private LocalDate modifiedDate = LocalDate.now();

}
