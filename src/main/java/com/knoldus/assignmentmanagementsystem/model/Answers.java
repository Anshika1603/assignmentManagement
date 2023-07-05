package com.knoldus.assignmentmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 The Answers class represents an answer to a question.
 */
@Data
@AllArgsConstructor
public class Answers {

    /**
     The ID of the question.
     */
    private Integer questionId;

    /**
     The answer to the question.
     */
    private String answer;
}
