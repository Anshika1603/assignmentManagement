package com.knoldus.assignmentmanagementsystem.service.impl;

import com.knoldus.assignmentmanagementsystem.exception.ResourceNotFoundException;
import com.knoldus.assignmentmanagementsystem.model.InternMentorMap;
import com.knoldus.assignmentmanagementsystem.model.InternMentorMapId;
import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
//import com.knoldus.assignmentmanagementsystem.repository.InternMentorRepository;
import com.knoldus.assignmentmanagementsystem.repository.InternMentorRepository;
import com.knoldus.assignmentmanagementsystem.repository.InternRepository;
import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import com.knoldus.assignmentmanagementsystem.repository.KipKupRepository;
import com.knoldus.assignmentmanagementsystem.repository.MentorRepository;
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

    @Autowired
    private InternRepository internRepository;

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private InternMentorRepository internMentorRepository;

    @Autowired
    private InternMentorMapId internMentorMapId;


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
        kipKupRepository.save(existingPlan);
        return "Updated Plan";
    }

    @Override
    public String assignMentorToIntern(InternMentorMap internMentorMap){
        if(internRepository.existsById(internMentorMap.getInternId()) && mentorRepository.existsById(internMentorMap.getMentorId())) {
            internMentorRepository.save(internMentorMap);
        }
        else {
            throw new ResourceNotFoundException("Intern or Mentor Id does not exist.");
        }
        return "Assigned Mentor " +internMentorMap.getMentorId()+ " to Intern " +internMentorMap.getInternId();
    }

    @Override
    public String reassignMentor(Integer mentorId, Integer internId, InternMentorMap internMentorMap){
        if(mentorRepository.existsById(mentorId)){
            internMentorMap.setMentorId(internMentorMap.getMentorId());
            internMentorRepository.save(internMentorMap);
        }
        else {
            throw new ResourceNotFoundException("Specified Mentor or Intern are not assigned.");
        }
        return "Reassigned Mentor " +internMentorMap.getMentorId()+ " to Intern " +internMentorMap.getInternId();
    }

}
