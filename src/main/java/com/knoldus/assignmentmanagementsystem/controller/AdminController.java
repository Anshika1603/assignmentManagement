package com.knoldus.assignmentmanagementsystem.controller;

import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import com.knoldus.assignmentmanagementsystem.service.AdminService;
import com.knoldus.assignmentmanagementsystem.service.InternService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

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

    @PutMapping("/updatePlan")
    public ResponseEntity<String> updatePlan(@RequestBody KipKupPlan kipKupPlan, Integer sessionId){
        logger.info("Updating Plan");
        return ResponseEntity.ok(adminService.updateKipKupPlan(kipKupPlan,sessionId));
    }

}
