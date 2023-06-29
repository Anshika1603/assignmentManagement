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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Assignment {

    String technology;

    @Id
    String topic;

    String createdBy;

    String assignedTo;

    List<Questions> questions;

    List<Answers> answers;

    String status;

    LocalDate createdDate=LocalDate.now();

    LocalDate modifiedDate=LocalDate.now();

}
