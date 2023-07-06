package com.knoldus.assignmentmanagementsystem.service.impl;

import com.knoldus.assignmentmanagementsystem.exception.ResourceNotFoundException;
import com.knoldus.assignmentmanagementsystem.model.InternMentorMap;
import com.knoldus.assignmentmanagementsystem.model.InternMentorMapId;
import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import com.knoldus.assignmentmanagementsystem.repository.InternMentorRepository;
import com.knoldus.assignmentmanagementsystem.repository.InternRepository;
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

    /**
     The KipKupRepository is a Spring Data repository interface
     that provides CRUD operations for managing
     KipKupPlan entities in the database.
     */
    @Autowired
    private KipKupRepository kipKupRepository;


    /**
     The InternRepository is a Spring Data repository
     interface that provides CRUD operations
     for managing Intern entities in the database.
     */
    @Autowired
    private InternRepository internRepository;


    /**
     The MentorRepository is a Spring Data repository interface
     that provides CRUD operations
     for managing Mentor entities in the database.
     */
    @Autowired
    private MentorRepository mentorRepository;


    /**
     The InternMentorRepository is a Spring Data repository
     interface that provides CRUD operations
     for managing InternMentorMap entities in the database.
     */
    @Autowired
    private InternMentorRepository internMentorRepository;


    /**
     The InternMentorMapId represents the composite key
     class for the InternMentorMap entity.
     */
    @Autowired
    private InternMentorMapId internMentorMapId;



    /**
     Creates a new KipKupPlan in the database.
     @param kipKupPlan The KipKupPlan object to be created.
     @return A string indicating the successful creation of the plan.
     */
    @Override
    public String createPlan(final KipKupPlan kipKupPlan) {
        kipKupRepository.save(kipKupPlan);
        return "Created Plan";
    }


    /**

     Updates the KipKupPlan with the provided details.
     @param kipKupPlan The updated KipKupPlan object.
     @param sessionId The session ID of the plan to be updated.
     @return A string indicating the successful update of the plan.
     @throws ResourceNotFoundException If the plan with the specified
     session ID is not found.
     */
    @Override
    public String updateKipKupPlan(final KipKupPlan kipKupPlan,
                                   final Integer sessionId) {
        KipKupPlan existingPlan = kipKupRepository.findById(
                sessionId).orElseThrow(() -> new ResourceNotFoundException(
                        "Plan not found with SessionID " + sessionId));
        existingPlan.setDate(kipKupPlan.getDate());
        existingPlan.setTopic(kipKupPlan.getTopic());
        existingPlan.setTime(kipKupPlan.getTime());
        existingPlan.setPlanType(kipKupPlan.getPlanType());
        existingPlan.setSessionId(kipKupPlan.getSessionId());
        existingPlan.setMentorName(kipKupPlan.getMentorName());
        kipKupRepository.save(existingPlan);
        return "Updated Plan";
    }


    /**
     Assigns a mentor to an intern.
     @param internMentorMap The InternMentorMap object
     containing the intern and mentor IDs.
     @return A string indicating the successful assignment
     of the mentor to the intern.
     @throws ResourceNotFoundException If either the intern
     or mentor ID does not exist.
     */
    @Override
    public String assignMentorToIntern(
            final InternMentorMap internMentorMap) {
        if (internRepository.existsById(internMentorMap.getInternId())
                && mentorRepository.
                existsById(internMentorMap.getMentorId())) {
            internMentorRepository.save(internMentorMap);
        } else {
            throw new ResourceNotFoundException(
                    "Intern or Mentor Id does not exist.");
        }
        return "Assigned Mentor " + internMentorMap.getMentorId()
                + " to Intern " + internMentorMap.getInternId();
    }



    /**
     Reassigns a mentor to an intern.
     @param mentorId The ID of the mentor.
     @param internId The ID of the intern.
     @param internMentorMap The InternMentorMap object containing
     the updated mentor ID.
     @return A string indicating the successful reassignment
     of the mentor to the intern.
     @throws ResourceNotFoundException If the specified mentor
     or intern is not assigned.
     */
    @Override
    public String reassignMentor(
            final Integer mentorId,
             final Integer internId,
             final InternMentorMap internMentorMap) {
        if (mentorRepository.existsById(mentorId)) {
            internMentorMap.setMentorId(internMentorMap.getMentorId());
            internMentorRepository.save(internMentorMap);
        } else {
            throw new ResourceNotFoundException(
                    "Specified Mentor or Intern are not assigned.");
        }
        return "Reassigned Mentor " + internMentorMap.getMentorId()
                + " to Intern " + internMentorMap.getInternId();
    }

}
