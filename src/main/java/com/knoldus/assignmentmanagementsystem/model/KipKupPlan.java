package com.knoldus.assignmentmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


/**
 The KipKupPlan class represents a plan in the system.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class KipKupPlan {

    /**
     The unique identifier (ID) of the session.
     */
    @Id
    private Integer sessionId;

    /**
     The date of the plan.
     */
    private LocalDate date;

    /**
     The time of the plan.
     */
    private String time;

    /**
     The topic of the plan.
     */
    private String topic;

    /**
     The name of the mentor associated with the plan.
     */
    private String mentorName;

    /**
     The type of the plan.
     */
    private String planType;

}
