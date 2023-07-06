package com.knoldus.assignmentmanagementsystem.controller;

import com.knoldus.assignmentmanagementsystem.model.Assignment;
import com.knoldus.assignmentmanagementsystem.model.Intern;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


/**
 The InternController interface defines the endpoints
 and operations for handling intern-related tasks.
 */
@RestController
public interface InternConroller {

    /**
     Retrieves a list of all interns.
     @return A ResponseEntity containing a list of
     Intern objects representing all the interns.
     */
    @Operation(summary = "Get all interns")
    @GetMapping("/getAllInterns")
    ResponseEntity<List<Intern>> getAllInterns();


    /**
     Adds a new intern using the provided Intern object.
     @param intern The Intern object representing the intern to be added.
     @return A ResponseEntity containing the added Intern object.
     */
    @Operation(summary = "Add a new intern")
    @PostMapping("/addIntern")
    ResponseEntity<Intern> addIntern(@RequestBody Intern intern);


    /**
     Updates an existing intern with the specified intern ID.
     @param intern The Intern object containing the updated intern details.
     @param internId The ID of the intern to be updated.
     @return A ResponseEntity with a String message
     indicating the result of the update operation.
     */
    @Operation(summary = "Update an existing intern")
    @PutMapping("/updateIntern/{internId}")
    ResponseEntity<String> updateIntern(@RequestBody Intern intern,
                                               @PathVariable Integer internId);


    /**
     Deletes an intern with the specified intern ID.
     @param internId The ID of the intern to be deleted.
     @return A ResponseEntity with a String message
     indicating the result of the delete operation.
     */
    @Operation(summary = "Delete an intern")
    @DeleteMapping("/deleteIntern/{internId}")
    ResponseEntity<String> deleteIntern(@PathVariable Integer internId);

    /**
     Retrieves the details of an intern with the specified intern ID.
     @param internId The ID of the intern to retrieve details for.
     @return A ResponseEntity containing an Optional
     Intern object representing the details of the intern.
     */
    @Operation(summary = "Get details of an intern")
    @GetMapping("/getDetails/{internId}")
    ResponseEntity<Optional<Intern>> getDetailsOfInterns(
            @PathVariable Integer internId);


    /**
     Submits an assignment by the intern.
     @param assignment The Assignment object
     representing the assignment to be submitted.
     @return A ResponseEntity with a String message
     indicating the result of the submission operation.
     */
    @Operation(summary = "Submit an assignment")
    @PostMapping("submitAssignment")
    ResponseEntity<String> submitAssignment(@RequestBody Assignment assignment);
}
