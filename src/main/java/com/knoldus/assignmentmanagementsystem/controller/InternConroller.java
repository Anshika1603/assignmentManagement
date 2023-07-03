package com.knoldus.assignmentmanagementsystem.controller;

import com.knoldus.assignmentmanagementsystem.model.Assignment;
import com.knoldus.assignmentmanagementsystem.model.Intern;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public interface InternConroller {
    @Operation(summary = "Get all interns")
    @GetMapping("/getAllInterns")
    public ResponseEntity<List<Intern>> getAllInterns();

    @Operation(summary = "Add a new intern")
    @PostMapping("/addIntern")
    public ResponseEntity<Intern> addIntern(@RequestBody Intern intern);

    @Operation(summary = "Update an existing intern")
    @PutMapping("/updateIntern/{internId}")
    public ResponseEntity<String> updateIntern(@RequestBody Intern intern, @PathVariable Integer internId);

    @Operation(summary = "Delete an intern")
    @DeleteMapping("/deleteIntern/{internId}")
    public ResponseEntity<String> deleteIntern(@PathVariable Integer internId);

    @Operation(summary = "Get details of an intern")
    @GetMapping("/getDetails/{internId}")
    public ResponseEntity<Optional<Intern>> getDetailsOfInterns(@PathVariable Integer internId);

    @Operation(summary = "Submit an assignment")
    @PostMapping("submitAssignment")
    public ResponseEntity<String> submitAssignment(@RequestBody Assignment assignment);

}
