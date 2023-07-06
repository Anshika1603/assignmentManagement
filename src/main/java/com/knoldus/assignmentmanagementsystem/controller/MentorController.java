package com.knoldus.assignmentmanagementsystem.controller;

import com.knoldus.assignmentmanagementsystem.model.Assignment;
import com.knoldus.assignmentmanagementsystem.model.Mentor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
    ResponseEntity<List<Mentor>> getAllMentors();


    /**
     Adds a new mentor using the provided Mentor object.
     @param mentor The Mentor object representing the mentor to be added.
     @return A ResponseEntity containing the added Mentor object.
     */
    @PostMapping("/addMentor")
    ResponseEntity<Mentor> addMentor(@RequestBody Mentor mentor);


    /**
     Updates an existing mentor with the specified mentor ID.
     @param mentor The Mentor object containing the
     updated mentor details.
     @param mentorId The ID of the mentor to be updated.
     @return A ResponseEntity with a String message
     indicating the result of the update operation.
     */
    @PutMapping("/updateMentor/{mentorId}")
    ResponseEntity<String> updateMentor(@RequestBody Mentor mentor,
                                        @PathVariable Integer mentorId);


    /**
     Deletes a mentor with the specified mentor ID.
     @param mentorId The ID of the mentor to be deleted.
     @return A ResponseEntity with a String message
     indicating the result of the delete operation.
     */
    @DeleteMapping("/deleteMentor/{mentorId}")
    ResponseEntity<String> deleteMentor(@PathVariable Integer mentorId);


    /**
     Retrieves the details of a mentor with
     the specified mentor ID.
     @param mentorId The ID of the mentor
     to retrieve details for.
     @return A ResponseEntity containing an Optional
     Mentor object representing the details of the mentor.
     */
    @GetMapping("/getDetailsOfMentor/{mentorId}")
    ResponseEntity<Optional<Mentor>>
    getDetailsOfMentors(@PathVariable Integer mentorId);


    /**
     Creates a new assignment using the provided Assignment object.
     @param assignment The Assignment object representing
     the assignment to be created.
     @return A ResponseEntity with a String message
     indicating the result of the creation operation.
     */
    @PostMapping("/createAssignment")
    ResponseEntity<String> createAssignment(@RequestBody Assignment assignment);
}
