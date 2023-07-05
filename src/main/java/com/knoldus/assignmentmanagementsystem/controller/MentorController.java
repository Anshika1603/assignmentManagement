package com.knoldus.assignmentmanagementsystem.controller;

import com.knoldus.assignmentmanagementsystem.exception.ResourceNotFoundException;
import com.knoldus.assignmentmanagementsystem.model.Assignment;
import com.knoldus.assignmentmanagementsystem.model.Mentor;
import com.knoldus.assignmentmanagementsystem.publisher.Publisher;
import com.knoldus.assignmentmanagementsystem.service.MentorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.knoldus.assignmentmanagementsystem.model.Assignment;
import com.knoldus.assignmentmanagementsystem.model.Mentor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 The MentorController interface defines the endpoints
 and operations for handling mentor-related tasks.
 */
@RestController
public interface MentorController {

    /**
     Retrieves a list of all mentors.
     @return A ResponseEntity containing a list of
     Mentor objects representing all the mentors.
     */
    @GetMapping("/getAllMentors")
    public ResponseEntity<List<Mentor>> getAllMentors();


    /**
     Adds a new mentor using the provided Mentor object.
     @param mentor The Mentor object representing the mentor to be added.
     @return A ResponseEntity containing the added Mentor object.
     */
    @PostMapping("/addMentor")
    public ResponseEntity<Mentor> addMentor(@RequestBody final Mentor mentor);


    /**
     Updates an existing mentor with the specified mentor ID.
     @param mentor The Mentor object containing the
     updated mentor details.
     @param mentorId The ID of the mentor to be updated.
     @return A ResponseEntity with a String message
     indicating the result of the update operation.
     */
    @PutMapping("/updateMentor/{mentorId}")
    public ResponseEntity<String> updateMentor(@RequestBody final Mentor mentor, @PathVariable final Integer mentorId);


    /**
     Deletes a mentor with the specified mentor ID.
     @param mentorId The ID of the mentor to be deleted.
     @return A ResponseEntity with a String message indicating the result of the delete operation.
     */
    @DeleteMapping("/deleteMentor/{mentorId}")
    public ResponseEntity<String> deleteMentor(@PathVariable final Integer mentorId);


    /**
     Retrieves the details of a mentor with
     the specified mentor ID.
     @param mentorId The ID of the mentor
     to retrieve details for.
     @return A ResponseEntity containing an Optional
     Mentor object representing the details of the mentor.
     */
    @GetMapping("/getDetailsOfMentor/{mentorId}")
    public ResponseEntity<Optional<Mentor>>
    getDetailsOfMentors(@PathVariable final Integer mentorId);


    /**
     Creates a new assignment using the provided Assignment object.
     @param assignment The Assignment object representing
     the assignment to be created.
     @return A ResponseEntity with a String message
     indicating the result of the creation operation.
     */
    @PostMapping("/createAssignment")
    public ResponseEntity<String> createAssignment(@RequestBody final Assignment assignment);
}
