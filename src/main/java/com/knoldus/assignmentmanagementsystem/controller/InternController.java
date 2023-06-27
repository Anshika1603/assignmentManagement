package com.knoldus.assignmentmanagementsystem.controller;

import com.knoldus.assignmentmanagementsystem.model.Intern;
import com.knoldus.assignmentmanagementsystem.service.InternService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InternController {

    @Autowired
    private InternService internService;

    private static final Logger logger = LoggerFactory.getLogger(InternController.class);

    @GetMapping("/getAllInterns")
    public ResponseEntity<List<Intern>> getAllInterns(){
        logger.info("Finding interns");
        return ResponseEntity.ok(internService.getAll());
    }

    @PostMapping("/addIntern")
    public ResponseEntity<Intern> addIntern(@RequestBody Intern intern){
        logger.info("Adding interns");
        return ResponseEntity.ok(internService.addIntern(intern));
    }

    @PutMapping("/updateIntern/{internId}")
    public ResponseEntity<String> updateIntern(@RequestBody Intern intern, @PathVariable Integer internId){
        logger.info("Updating intern");
        return ResponseEntity.ok(internService.updateIntern(intern,internId));
    }

    @DeleteMapping("/deleteIntern/{internId}")
    public ResponseEntity<String> deleteIntern(@PathVariable Integer internId){
        logger.info("Deleting intern");
        return ResponseEntity.ok(internService.deleteIntern(internId));
    }

    @GetMapping("/getDetails/{internId}")
    public ResponseEntity<Optional<Intern>> getDetailsOfInterns(@PathVariable Integer internId){
        logger.info("Finding details of Intern");
        return ResponseEntity.ok(internService.getDetails(internId));
    }
}