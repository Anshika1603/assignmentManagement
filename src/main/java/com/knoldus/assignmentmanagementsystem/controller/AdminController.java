package com.knoldus.assignmentmanagementsystem.controller;

import com.knoldus.assignmentmanagementsystem.model.InternMentorMap;
import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 The AdminController interface defines the endpoints
 and operations for the administrative tasks.
 */
@RestController
public interface AdminController {
        /**
         * The LOGGER field is a static final Logger object used for
         * logging events and messages within the AdminController class.
         */
         Logger LOGGER = LoggerFactory.getLogger(
                 AdminController.class);

        /**
         * Creates a new plan.
         * @param kipKupPlan The KipKupPlan object containing the
         * details of the plan to be created.
         * @return A ResponseEntity object with the HTTP status code
         * and the response message as a String.
         */
        @PostMapping("/createPlan")
        ResponseEntity<String> createPlan(
                @RequestBody KipKupPlan kipKupPlan);


        /**
         Updates a KipKupPlan with the specified session ID.
         @param kipKupPlan The KipKupPlan object
         containing the updated plan details.
         @param sessionId The ID of the session to update the plan for.
         @return A ResponseEntity with a String
         message indicating the result of the update operation.
         */
        @Operation(summary = "Update an existing KipKupPlan")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Successfully updated the plan"),
                @ApiResponse(responseCode = "404",
                        description = "Plan not found")
        })
        @PutMapping("/updatePlan/{sessionId}")
        ResponseEntity<String> updatePlan(
                @RequestBody KipKupPlan kipKupPlan,
                @PathVariable Integer sessionId);


        /**
         Updates a InternMentorMap with the specified session ID.
         @param internMentorMap The KipKupPlan object
         containing the updated plan details.
         @return A ResponseEntity with a String message
         indicating the result of the update operation.
         */
        @Operation(summary = "Assign a mentor to an intern")
        @PostMapping("/assignMentorToIntern")
        ResponseEntity<String> assignMentorToIntern(
                @RequestBody InternMentorMap internMentorMap);

        /**
         Reassigns a mentor to a different intern based on the
         given mentor ID, intern ID, and mapping details.
         @param mentorId The ID of the mentor to be reassigned.
         @param internId The ID of the intern to be reassigned.
         @param internMentorMap The InternMentorMap object containing
         the updated mapping between the intern and the mentor.
         @return A ResponseEntity with a String message indicating
         the result of the reassignment operation.
         */
        @Operation(summary = "Reassign a mentor")
        @PutMapping("/reassign")
        ResponseEntity<String> reassign(
                @PathVariable Integer mentorId,
                @PathVariable Integer internId,
                @RequestBody InternMentorMap internMentorMap);
    }
