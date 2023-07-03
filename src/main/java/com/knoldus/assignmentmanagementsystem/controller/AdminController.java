package com.knoldus.assignmentmanagementsystem.controller;

import com.knoldus.assignmentmanagementsystem.model.InternMentorMap;
import com.knoldus.assignmentmanagementsystem.model.InternMentorMapId;
import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public interface AdminController {

    @Operation(summary = "Create a new KipKupPlan")
    @PostMapping("/createPlan")
    public ResponseEntity<String> createPlan(@RequestBody KipKupPlan kipKupPlan);

    @Operation(summary = "Update an existing KipKupPlan")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated the plan"),
            @ApiResponse(responseCode = "404", description = "Plan not found")
    })
    @PutMapping("/updatePlan/{sessionId}")
    public ResponseEntity<String> updatePlan(@RequestBody KipKupPlan kipKupPlan, @PathVariable Integer sessionId);

    @Operation(summary = "Assign a mentor to an intern")
    @PostMapping("/assignMentorToIntern")
    public ResponseEntity<String> assignMentorToIntern(@RequestBody InternMentorMap internMentorMap);

    @Operation(summary = "Reassign a mentor")
    @PutMapping("/reassign")
    public ResponseEntity<String> reassign(@PathVariable Integer mentorId,@PathVariable Integer internId, @RequestBody InternMentorMap internMentorMap);

}
