package com.knoldus.assignmentmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class KipKupPlan {

    @Id
    private Integer sessionId;

    private LocalDate date;

    private String time;

    private String topic;

    private String mentorName;

    private String planType;

}
