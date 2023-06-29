package com.knoldus.assignmentmanagementsystem.controller;

import com.knoldus.assignmentmanagementsystem.model.Assignment;
import com.knoldus.assignmentmanagementsystem.model.Intern;
import com.knoldus.assignmentmanagementsystem.service.InternService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import java.util.Optional;

/**
Controller class for handling operations related to interns.
*/
@RestController
public class InternController {

    /**
     Autowired field for the InternService.
     */
    @Autowired
    private InternService internService;

    /**
     The logger field represents an instance of the Logger class from
     the SLF4J logging framework.
     */
    private static final Logger logger = LoggerFactory.getLogger(InternController.class);


    /**
     Retrieves a list of all interns from the Assignment Management System.
     @return ResponseEntity<List<Intern>> - A response entity containing the list of all interns
     @see InternService#getAll()
     @see ResponseEntity
     @see Logger#info(String)
     */
    @GetMapping("/getAllInterns")
    public ResponseEntity<List<Intern>> getAllInterns(){
        logger.info("Finding interns");
        return ResponseEntity.ok(internService.getAll());
    }

    /**
     Adds a new intern to the Assignment Management System.
     @param intern - The intern object to be added
     @return ResponseEntity<Intern> - A response entity containing the added intern
     @see InternService#addIntern(Intern)
     @see ResponseEntity
     @see Logger#info(String)
     */
    @PostMapping("/addIntern")
    public ResponseEntity<Intern> addIntern(@RequestBody Intern intern){
        logger.info("Adding interns");
        return ResponseEntity.ok(internService.addIntern(intern));
    }

    /**
     Updates the details of an existing intern in the Assignment Management System.
     @param intern - The updated intern object
     @param internId - The ID of the intern to be updated
     @return ResponseEntity<String> - A response entity containing the status message of the update operation
     @see InternService#updateIntern(Intern, Integer)
     @see ResponseEntity
     @see Logger#info(String)
     */
    @PutMapping("/updateIntern/{internId}")
    public ResponseEntity<String> updateIntern(@RequestBody Intern intern, @PathVariable Integer internId){
        logger.info("Updating intern");
        return ResponseEntity.ok(internService.updateIntern(intern,internId));
    }

    /**
     Deletes an intern from the Assignment Management System based on the provided intern ID.
     @param internId - The ID of the intern to be deleted
     @return ResponseEntity<String> - A response entity containing the status message of the deletion operation
     @see InternService#deleteIntern(Integer)
     @see ResponseEntity
     @see Logger#info(String)
    */
    @DeleteMapping("/deleteIntern/{internId}")
    public ResponseEntity<String> deleteIntern(@PathVariable Integer internId){
        logger.info("Deleting intern");
        return ResponseEntity.ok(internService.deleteIntern(internId));
    }


    /**
     Retrieves the details of an intern from the Assignment Management System based on the provided intern ID.
     @param internId - The ID of the intern for which details are requested
     @return ResponseEntity<Optional<Intern>> - A response entity containing the optional intern object representing the details
     @see InternService#getDetails(Integer)
     @see ResponseEntity
     @see Logger#info(String)
    */
    @GetMapping("/getDetails/{internId}")
    public ResponseEntity<Optional<Intern>> getDetailsOfInterns(@PathVariable Integer internId){
        logger.info("Finding details of Intern");
        return ResponseEntity.ok(internService.getDetails(internId));
    }

    @PostMapping("submitAssignment")
    public ResponseEntity<String> submitAssignment(@RequestBody Assignment assignment){
        logger.info("submitting Assignment");
        return ResponseEntity.ok(internService.submitAssignment(assignment));
    }
}
