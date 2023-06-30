package com.knoldus.assignmentmanagementsystem.controller.controller;

import com.knoldus.assignmentmanagementsystem.controller.AdminController;
import com.knoldus.assignmentmanagementsystem.model.InternMentorMap;
import com.knoldus.assignmentmanagementsystem.model.InternMentorMapId;
import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import com.knoldus.assignmentmanagementsystem.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
public class AdminControllerImpl implements AdminController {
    @Autowired
    private AdminService adminService;

    private static final Logger logger = LoggerFactory.getLogger(AdminControllerImpl.class);

    /**
     * Creates a new KipKupPlan.
     *
     * @param kipKupPlan The KipKupPlan to create.
     * @return ResponseEntity representing the status of the operation.
     */
    public ResponseEntity<String> createPlan(@RequestBody KipKupPlan kipKupPlan){
        logger.info("Creating Plan");
        return ResponseEntity.ok(adminService.createPlan(kipKupPlan));
    }

    /**
     * Updates an existing KipKupPlan.
     *
     * @param kipKupPlan The updated KipKupPlan.
     * @param sessionId  The session ID of the plan to update.
     * @return ResponseEntity representing the status of the operation.
     */
    public ResponseEntity<String> updatePlan(@RequestBody KipKupPlan kipKupPlan,@PathVariable Integer sessionId){
        logger.info("Updating Plan");
        return ResponseEntity.ok(adminService.updateKipKupPlan(kipKupPlan,sessionId));
    }

    /**
     * Assigns a mentor to an intern.
     *
     * @param internMentorMap The mapping between intern and mentor.
     * @return ResponseEntity representing the status of the operation.
     */
    public ResponseEntity<String> assignMentorToIntern(@RequestBody InternMentorMap internMentorMap){
        logger.info("Assigning Mentor to Intern");
        return ResponseEntity.ok(adminService.assignMentorToIntern(internMentorMap));
    }

    /**
     * Reassigns a mentor to an intern.
     *
     * @param internMentorMapId   The ID of the intern-mentor mapping.
     * @param internMentorMap The updated mapping between intern and mentor.
     * @return ResponseEntity representing the status of the operation.
     */
    public ResponseEntity<String> reassign(@RequestBody InternMentorMapId internMentorMapId,@RequestBody InternMentorMap internMentorMap){
        logger.info("Reassigning Mentor to Intern");
        return ResponseEntity.ok(adminService.reassignMentor(internMentorMapId,internMentorMap));
    }
}
