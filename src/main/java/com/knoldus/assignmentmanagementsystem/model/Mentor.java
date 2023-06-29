package com.knoldus.assignmentmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import java.time.LocalDate;


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
    private Integer mentorId;

    private String empId;

    private String competencyName;

    private LocalDate createdDate=LocalDate.now();

    private LocalDate modifiedDate=LocalDate.now();
}
