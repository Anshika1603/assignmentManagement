package com.knoldus.assignmentmanagementsystem.controller;

import com.knoldus.assignmentmanagementsystem.model.Intern;
import com.knoldus.assignmentmanagementsystem.model.Mentor;
import com.knoldus.assignmentmanagementsystem.service.MentorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MentorController {
    @Autowired
    private MentorService mentorService;

    private static final Logger logger = LoggerFactory.getLogger(InternController.class);

    @GetMapping("/getAllMentors")
    public ResponseEntity<List<Mentor>> getAllMentors(){
        logger.info("Finding mentors");
        return ResponseEntity.ok(mentorService.getAllMentor());
    }

    @PostMapping("/addMentor")
    public ResponseEntity<Mentor> addMentor(@RequestBody Mentor mentor){
        logger.info("Adding mentors");
        return ResponseEntity.ok(mentorService.addMentor(mentor));
    }

    @PutMapping("/updateMentor/{mentorId}")
    public ResponseEntity<String> updateMentor(@RequestBody Mentor mentor, @PathVariable Integer mentorId){
        logger.info("Updating mentor");
        return ResponseEntity.ok(mentorService.updateMentor(mentor,mentorId));
    }

    @DeleteMapping("/deleteMentor/{mentorId}")
    public ResponseEntity<String> deleteMentor(@PathVariable Integer mentorId){
        logger.info("Deleting mentor");
        return ResponseEntity.ok(mentorService.deleteMentor(mentorId));
    }

    @GetMapping("/getDetailsOfMentor/{mentorId}")
    public ResponseEntity<Optional<Mentor>> getDetailsOfMentors(@PathVariable Integer mentorId){
        logger.info("Finding details of Mentor");
        return ResponseEntity.ok(mentorService.getDetailsOfMentor(mentorId));
    }
}
