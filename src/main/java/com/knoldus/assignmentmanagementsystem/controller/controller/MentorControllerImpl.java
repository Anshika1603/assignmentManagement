package com.knoldus.assignmentmanagementsystem.controller.controller;


import com.knoldus.assignmentmanagementsystem.controller.MentorController;
import com.knoldus.assignmentmanagementsystem.model.Assignment;
import com.knoldus.assignmentmanagementsystem.model.Mentor;
import com.knoldus.assignmentmanagementsystem.service.MentorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

/**
The MentorController class is responsible for handling the
 HTTP requests related to mentors
 in the Assignment Management System.
*/
@Component
public class MentorControllerImpl implements MentorController {


    /**
     The mentorService field represents an instance
     of the MentorService interface.
     */
    @Autowired
    private MentorService mentorService;

    /**
     The logger field represents an instance of the Logger class from
     the SLF4J logging framework.
     */
    private static final Logger LOGGER = LoggerFactory.
            getLogger(InternControllerImpl.class);


    /**
     Retrieves a list of all mentors in the Assignment Management System.
     @return ResponseEntity<List<Mentor>> - A response entity containing
     the list of mentors
     @see MentorService#getAllMentor()
     @see ResponseEntity
     @see Logger#info(String)
     */

    public ResponseEntity<List<Mentor>> getAllMentors() {
        LOGGER.info("Finding mentors");
        return ResponseEntity.ok(mentorService.getAllMentor());
    }

    /**
     Adds a new mentor to the Assignment Management System.
     @param mentor The mentor object to be added
     @return ResponseEntity<Mentor> - A response entity
     containing the added mentor
     @see MentorService#addMentor(Mentor)
     @see ResponseEntity
     @see Logger#info(String)
     */

    public ResponseEntity<Mentor> addMentor(@RequestBody final Mentor mentor) {
        LOGGER.info("Adding mentors");
        return ResponseEntity.ok(mentorService.addMentor(mentor));
    }

    /**
     Updates the details of a mentor in the Assignment Management System.
     @param mentor The updated mentor object
     @param mentorId The ID of the mentor to be updated
     @return ResponseEntity<String> - A response entity containing a message
     indicating the success of the update
     @see MentorService#updateMentor(Mentor, Integer)
     @see ResponseEntity
     @see Logger#info(String)
     */

    public ResponseEntity<String> updateMentor(
            @RequestBody final Mentor mentor,
            @PathVariable final Integer mentorId) {
        LOGGER.info("Updating mentor");
        return ResponseEntity.ok(mentorService.updateMentor(mentor, mentorId));
    }

    /**
     Deletes a mentor from the Assignment Management System.
     @param mentorId The ID of the mentor to be deleted
     @return ResponseEntity<String> - A response entity containing
     a message indicating the success of the deletion
     @see MentorService#deleteMentor(Integer)
     @see ResponseEntity
     @see Logger#info(String)
     */

    public ResponseEntity<String> deleteMentor(
            @PathVariable final Integer mentorId) {
        LOGGER.info("Deleting mentor");
        return ResponseEntity.ok(mentorService.deleteMentor(mentorId));
    }

    /**
     Retrieves the details of a mentor from the Assignment Management System.
     @param mentorId The ID of the mentor for which
     the details are to be retrieved
     @return ResponseEntity<Optional<Mentor>> - A response entity
     containing the details of the mentor (wrapped in an Optional)
     @see MentorService#getDetailsOfMentor(Integer)
     @see ResponseEntity
     @see Logger#info(String)
     */

    public ResponseEntity<Optional<Mentor>>
    getDetailsOfMentors(@PathVariable final Integer mentorId) {
        LOGGER.info("Finding details of Mentor");
        return ResponseEntity.ok(mentorService.
                getDetailsOfMentor(mentorId));
    }


    public ResponseEntity<String> createAssignment(@RequestBody Assignment assignment){
        return ResponseEntity.ok(mentorService.createAssignment(assignment));
    }
}
