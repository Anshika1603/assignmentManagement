package com.knoldus.assignmentmanagementsystem.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 The InternMentorMap class represents a mapping between
 an intern and a mentor in the system.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(InternMentorMapId.class)
@Table(name = "InternMentorMap")
public class InternMentorMap {

    /**
     * The ID of the intern.
     */
    @Id
    private Integer internId;


    /**
     * The ID of the mentor.
     */
    @Id
    private Integer mentorId;


    /**
     * The date when the mapping was created. Defaults to the current date.
     */
    private LocalDate creationDate = LocalDate.now();


    /**
     * The date when the mapping was last modified.
     * Defaults to the current date.
     */
    private LocalDate modifiedDate = LocalDate.now();
}
