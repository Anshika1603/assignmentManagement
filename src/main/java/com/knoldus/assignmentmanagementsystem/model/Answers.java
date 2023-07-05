package com.knoldus.assignmentmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answers {

    private Integer questionId;

    private String answer;
}
