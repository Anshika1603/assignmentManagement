package com.knoldus.assignmentmanagementsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(InternMentorMapId.class)
@Table(name = "InternMentorMap")
public class InternMentorMap {

    @Id
    private Integer internId;

    @Id
    private Integer mentorId;

    private LocalDate creationDate=LocalDate.now();

    private LocalDate modifiedDate=LocalDate.now();

}
