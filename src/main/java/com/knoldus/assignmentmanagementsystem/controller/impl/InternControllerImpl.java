package com.knoldus.assignmentmanagementsystem.controller.impl;

import com.knoldus.assignmentmanagementsystem.controller.InternConroller;
import com.knoldus.assignmentmanagementsystem.model.Assignment;
import com.knoldus.assignmentmanagementsystem.model.Intern;
import com.knoldus.assignmentmanagementsystem.service.InternService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

/**
 * Controller class for handling operations related to interns.
 */
@Component
public class InternControllerImpl implements InternConroller {

    /**
     * Autowired field for the InternService.
     */
    @Autowired
    private InternService internService;

    /**
     * The LOGGER field represents an instance of the Logger class from
     * the SLF4J logging framework.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(
            InternControllerImpl.class);

    /**
     * Retrieves a list of all interns from the Assignment Management System.
     * @return ResponseEntity<List < Intern>> -
     * A response entity containing the list of all interns
     * @see InternService#getAll()
     * @see ResponseEntity
     * @see Logger#info(String)
     */
    @Override
    public ResponseEntity<List<Intern>> getAllInterns() {
        LOGGER.info("Finding interns");
        return ResponseEntity.ok(internService.getAll());
    }

    /**
     * Adds a new intern to the Assignment Management System.
     *
     * @param intern - The intern object to be added
     * @return ResponseEntity<Intern> -
     * A response entity containing the added intern
     * @see InternService#addIntern(Intern)
     * @see ResponseEntity
     * @see Logger#info(String)
     */

    @Override
    public ResponseEntity<Intern> addIntern(@RequestBody final Intern intern) {
        LOGGER.info("Adding interns");
        return ResponseEntity.ok(internService.addIntern(intern));
    }

    /**
     * Updates the details of an existing intern in
     * the Assignment Management System.
     * @param intern   - The updated intern object
     * @param internId - The ID of the intern to be updated
     * @return ResponseEntity<String> - A response entity
     * containing the status message of the update operation
     * @see InternService#updateIntern(Intern, Integer)
     * @see ResponseEntity
     * @see Logger#info(String)
     */

    @Override
    public ResponseEntity<String> updateIntern(
            @RequestBody final Intern intern,
            @PathVariable final Integer internId) {
        LOGGER.info("Updating intern");
        return ResponseEntity.ok(internService.updateIntern(intern, internId));
    }

    /**
     * Deletes an intern from the Assignment Management
     * System based on the provided intern ID.
     * @param internId - The ID of the intern to be deleted
     * @return ResponseEntity<String> -
     * A response entity containing the status message of the deletion operation
     * @see InternService#deleteIntern(Integer)
     * @see ResponseEntity
     * @see Logger#info(String)
     */
    @Override
    public ResponseEntity<String> deleteIntern(
            @PathVariable final Integer internId) {
        LOGGER.info("Deleting intern");
        return ResponseEntity.ok(internService.deleteIntern(internId));
    }


    /**
     * Retrieves the details of an intern from the
     * Assignment Management System based on the provided intern ID.
     * @param internId - The ID of the intern for which details are requested
     * @return ResponseEntity<Optional < Intern>> -
     * A response entity containing the optional
     * intern object representing the details
     * @see InternService#getDetails(Integer)
     * @see ResponseEntity
     * @see Logger#info(String)
     */
    @Override
    public ResponseEntity<Optional<Intern>> getDetailsOfInterns(
            @PathVariable final Integer internId) {
        LOGGER.info("Finding details of Intern");
        return ResponseEntity.ok(internService.getDetails(internId));
    }


    /**
     Submits an assignment by the intern.
     @param assignment The Assignment object representing
     the assignment to be submitted.
     @return A ResponseEntity with a String message
     indicating the result of the submission operation.
     */
    @Override
    public ResponseEntity<String> submitAssignment(
            @RequestBody final Assignment assignment) {
        LOGGER.info("submitting Assignment");
        return ResponseEntity.ok(internService.submitAssignment(assignment));
    }
}
