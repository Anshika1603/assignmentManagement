package com.knoldus.assignmentmanagementsystem.controller;

import com.knoldus.assignmentmanagementsystem.model.InternMentorMap;
import com.knoldus.assignmentmanagementsystem.model.InternMentorMapId;
import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import com.knoldus.assignmentmanagementsystem.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 The AdminController interface defines the endpoints and operations for the administrative tasks.
 */
@RestController
public interface AdminController {

        /**
         * The logger field is a static final Logger object used for
         * logging events and messages within the AdminController class.
         */
         static final Logger logger = LoggerFactory.getLogger(AdminController.class);

        /**
         * Creates a new plan.
         *
         * @param kipKupPlan The KipKupPlan object containing the
         *                   details of the plan to be created.
         * @return A ResponseEntity object with the HTTP status code
         * and the response message as a String.
         */
        @PostMapping("/createPlan")
        public ResponseEntity<String> createPlan(@RequestBody KipKupPlan kipKupPlan);

        @Operation(summary = "Update an existing KipKupPlan")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Successfully updated the plan"),
                @ApiResponse(responseCode = "404", description = "Plan not found")
        })


        /**
         Updates a KipKupPlan with the specified session ID.
         @param kipKupPlan The KipKupPlan object containing the updated plan details.
         @param sessionId The ID of the session to update the plan for.
         @return A ResponseEntity with a String message indicating the result of the update operation.
         */
        @PutMapping("/updatePlan/{sessionId}")
        public ResponseEntity<String> updatePlan(@RequestBody KipKupPlan kipKupPlan, @PathVariable Integer sessionId);


        /**
         Updates a KipKupPlan with the specified session ID.
         @param kipKupPlan The KipKupPlan object containing the updated plan details.
         @param sessionId The ID of the session to update the plan for.
         @return A ResponseEntity with a String message indicating the result of the update operation.
         */
        @Operation(summary = "Assign a mentor to an intern")
        @PostMapping("/assignMentorToIntern")
        public ResponseEntity<String> assignMentorToIntern(@RequestBody InternMentorMap internMentorMap);

        /**
         Reassigns a mentor to a different intern based on the given mentor ID, intern ID, and mapping details.
         @param mentorId The ID of the mentor to be reassigned.
         @param internId The ID of the intern to be reassigned.
         @param internMentorMap The InternMentorMap object containing the updated mapping between the intern and the mentor.
         @return A ResponseEntity with a String message indicating the result of the reassignment operation.
         */
        @Operation(summary = "Reassign a mentor")
        @PutMapping("/reassign")
        public ResponseEntity<String> reassign(@PathVariable Integer mentorId, @PathVariable Integer internId, @RequestBody InternMentorMap internMentorMap);
    }
