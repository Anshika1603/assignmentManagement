package com.knoldus.assignmentmanagementsystem.controller;

import com.knoldus.assignmentmanagementsystem.model.InternMentorMap;
import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import com.knoldus.assignmentmanagementsystem.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PostMapping("/createPlan")
    public ResponseEntity<String> createPlan(@RequestBody KipKupPlan kipKupPlan){
        logger.info("Creating Plan");
        return ResponseEntity.ok(adminService.createPlan(kipKupPlan));
    }

    @PutMapping("/updatePlan/{sessionId}")
    public ResponseEntity<String> updatePlan(@RequestBody KipKupPlan kipKupPlan,@PathVariable Integer sessionId){
        logger.info("Updating Plan");
        return ResponseEntity.ok(adminService.updateKipKupPlan(kipKupPlan,sessionId));
    }

    @PostMapping("/assignMentorToIntern")
    public ResponseEntity<String> assignMentorToIntern(@RequestBody InternMentorMap internMentorMap){
        logger.info("Assigning Mentor to Intern");
        return ResponseEntity.ok(adminService.assignMentorToIntern(internMentorMap));
    }

}
