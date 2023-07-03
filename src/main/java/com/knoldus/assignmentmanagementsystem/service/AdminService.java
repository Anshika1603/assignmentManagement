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

    public String createPlan(KipKupPlan kipKupPlan);

    public String updateKipKupPlan(KipKupPlan kipKupPlan, Integer sessionId);

    public String assignMentorToIntern(InternMentorMap internMentorMap);

    String reassignMentor(Integer mentorId, Integer internId, InternMentorMap internMentorMap);

}



