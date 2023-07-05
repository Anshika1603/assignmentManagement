package com.knoldus.assignmentmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 The Assignment class represents an assignment document stored in a document-oriented database.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Assignment {

    /**
     The technology associated with the assignment.
     */
    String technology;


    /**
     The unique identifier (ID) of the assignment topic.
     */
    @Id
    String topic;


    /**
     The username of the user who created the assignment.
     */
    String createdBy;


    /**
     The username of the user to whom the assignment is assigned.
     */
    String assignedTo;


    /**
     The list of questions associated with the assignment.
     */
    List<Questions> questions;


    /**
     The list of answers submitted for the assignment questions.
     */
    List<Answers> answers;


    /**
     The status of the assignment (e.g., "in progress", "completed").
     */
    String status;


    /**
     The date when the assignment was created. Defaults to the current date.
     */
    LocalDate createdDate = LocalDate.now();


    /**
     The date when the assignment was last modified. Defaults to the current date.
     */
    LocalDate modifiedDate = LocalDate.now();

}
