package com.knoldus.assignmentmanagementsystem.service.impl;

import com.knoldus.assignmentmanagementsystem.exception.ResourceNotFoundException;
import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;

//import com.knoldus.assignmentmanagementsystem.repository.InternMentorRepository;
import com.knoldus.assignmentmanagementsystem.repository.KipKupRepository;
import com.knoldus.assignmentmanagementsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 The AdminServiceImpl class is an implementation of the service layer
 for the administration
 functionality in the Assignment Management System.
 */
@Component
public class AdminServiceImpl implements AdminService {

    @Autowired
    private KipKupRepository kipKupRepository;

//    @Autowired
//    private InternMentorRepository internMentorRepository;

    @Override
    public String createPlan(KipKupPlan kipKupPlan) {
        kipKupRepository.save(kipKupPlan);
        return "Created Plan";
    }

    @Override
    public String updateKipKupPlan(KipKupPlan kipKupPlan, Integer sessionId) {
        KipKupPlan existingPlan=kipKupRepository.findById(sessionId).orElseThrow(() -> new ResourceNotFoundException("Plan not found with SessionID "+sessionId));
        existingPlan.setDate(kipKupPlan.getDate());
        existingPlan.setTopic(kipKupPlan.getTopic());
        existingPlan.setTime(kipKupPlan.getTime());
        existingPlan.setPlanType(kipKupPlan.getPlanType());
        existingPlan.setSessionId(kipKupPlan.getSessionId());
        existingPlan.setMentorName(kipKupPlan.getMentorName());
        return "Updated Plan";
    }

//    @Override
//    public String assignMentorToIntern(InternMentorMapping internMentorMap){
//        internMentorRepository.save(internMentorMap);
//        return "Assigned Mentor " +internMentorMap.getMentor_Id()+ "to Intern " +internMentorMap.getIntern_Id();
//    }

}
