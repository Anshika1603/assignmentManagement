package com.knoldus.assignmentmanagementsystem.controller;

import com.knoldus.assignmentmanagementsystem.model.Assignment;
import com.knoldus.assignmentmanagementsystem.model.Mentor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public interface MentorController {
    @GetMapping("/getAllMentors")
    public ResponseEntity<List<Mentor>> getAllMentors();

    @PostMapping("/addMentor")
    public ResponseEntity<Mentor> addMentor(@RequestBody final Mentor mentor);

    @PutMapping("/updateMentor/{mentorId}")
    public ResponseEntity<String> updateMentor(@RequestBody final Mentor mentor, @PathVariable final Integer mentorId);

    @DeleteMapping("/deleteMentor/{mentorId}")
    public ResponseEntity<String> deleteMentor(@PathVariable final Integer mentorId);

    @GetMapping("/getDetailsOfMentor/{mentorId}")
    public ResponseEntity<Optional<Mentor>>
    getDetailsOfMentors(@PathVariable final Integer mentorId);

    @PostMapping("/createAssignment")
    public ResponseEntity<String> createAssignment(@RequestBody Assignment assignment);
}
