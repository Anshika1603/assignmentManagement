package com.knoldus.assignmentmanagementsystem.controller.impl;

import com.knoldus.assignmentmanagementsystem.controller.AdminController;
import com.knoldus.assignmentmanagementsystem.model.InternMentorMap;
import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import com.knoldus.assignmentmanagementsystem.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 The AdminControllerImpl class is an implementation
 of the AdminController interface.
 */
@Component
public class AdminControllerImpl implements AdminController {

    /**
     Autowires an instance of the AdminService
     class to the AdminControllerImpl class.
     */
    @Autowired
    private AdminService adminService;


    /**
     The LOGGER object is used to record and log events
     and messages within the AdminControllerImpl class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(
            AdminControllerImpl.class);


    /**
     * Creates a new KipKupPlan.
     * @param kipKupPlan The KipKupPlan to create.
     * @return ResponseEntity representing the status of the operation.
     */
    public ResponseEntity<String> createPlan(
            @RequestBody final KipKupPlan kipKupPlan) {
        LOGGER.info("Creating Plan");
        return ResponseEntity.ok(adminService.createPlan(kipKupPlan));
    }

    /**
     * Updates an existing KipKupPlan.
     * @param kipKupPlan The updated KipKupPlan.
     * @param sessionId  The session ID of the plan to update.
     * @return ResponseEntity representing the status of the operation.
     */
    public ResponseEntity<String> updatePlan(
            @RequestBody final KipKupPlan kipKupPlan,
            @PathVariable final Integer sessionId) {
        LOGGER.info("Updating Plan");
        return ResponseEntity.ok(
                adminService.updateKipKupPlan(kipKupPlan, sessionId));
    }

    /**
     * Assigns a mentor to an intern.
     * @param internMentorMap The mapping between intern and mentor.
     * @return ResponseEntity representing the status of the operation.
     */
    public ResponseEntity<String> assignMentorToIntern(
            @RequestBody final InternMentorMap internMentorMap) {
        LOGGER.info("Assigning Mentor to Intern");
        return ResponseEntity.ok(
                adminService.assignMentorToIntern(internMentorMap));
    }

    /**
     * Reassigns a mentor to an intern.
     * @param internId  The ID of the intern.
     * @param mentorId  The ID of the mentor.
     * @param internMentorMap The updated mapping between intern and mentor.
     * @return ResponseEntity representing the status of the operation.
     */
    @Override
    public ResponseEntity<String> reassign(final Integer mentorId,
                                           final Integer internId,
                                           final InternMentorMap
                                                       internMentorMap) {
        LOGGER.info("Reassigning Mentor to Intern");
        return ResponseEntity.ok(
                adminService.reassignMentor(mentorId,
                        internId, internMentorMap));
    }
}
