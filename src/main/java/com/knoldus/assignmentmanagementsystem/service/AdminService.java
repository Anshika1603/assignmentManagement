package com.knoldus.assignmentmanagementsystem.service;

import com.knoldus.assignmentmanagementsystem.model.InternMentorMap;
import com.knoldus.assignmentmanagementsystem.model.Assignment;
import com.knoldus.assignmentmanagementsystem.model.InternMentorMapId;
import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import org.springframework.stereotype.Service;


/**
 The AdminService interface defines the contract for managing
 administrative operations in the system.
 */
@Service
public interface AdminService {

    /**
     * Creates a new KipKupPlan.
     *
     * @param kipKupPlan The KipKupPlan object representing the plan to be created.
     * @return A String indicating the result of the operation.
     */
    public String createPlan(KipKupPlan kipKupPlan);

    /**
     * Updates an existing KipKupPlan with the specified sessionId.
     *
     * @param kipKupPlan The KipKupPlan object representing the updated plan.
     * @param sessionId  The unique identifier of the session.
     * @return A String indicating the result of the operation.
     */
    public String updateKipKupPlan(KipKupPlan kipKupPlan, Integer sessionId);

    /**
     * Assigns a mentor to an intern.
     *
     * @param internMentorMap The InternMentorMap object representing the mapping between an intern and a mentor.
     * @return A String indicating the result of the operation.
     */
    public String assignMentorToIntern(InternMentorMap internMentorMap);


    /**
     * Reassigns a mentor for a specific intern.
     *
     * @param internMentorMapId The unique identifier of the intern-mentor mapping.
     * @param internMentorMap  The InternMentorMap object representing the updated mapping.
     * @return A String indicating the result of the operation.
     */
    String reassignMentor(InternMentorMapId internMentorMapId, InternMentorMap internMentorMap);

}



