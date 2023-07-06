package com.knoldus.assignmentmanagementsystem.service.impl;

import com.knoldus.assignmentmanagementsystem.exception.EmptyInputException;
import com.knoldus.assignmentmanagementsystem.exception.ResourceNotFoundException;
import com.knoldus.assignmentmanagementsystem.model.Assignment;
import com.knoldus.assignmentmanagementsystem.model.Mentor;
import com.knoldus.assignmentmanagementsystem.publisher.Publisher;
import com.knoldus.assignmentmanagementsystem.repository.AssignmentRepository;
import com.knoldus.assignmentmanagementsystem.repository.MentorRepository;
import com.knoldus.assignmentmanagementsystem.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 The MentorServiceImpl class is an implementation
 of the MentorService interface, representing the service layer
 for handling mentor entities in the Assignment Management System.
 */
@Component
public class MentorServiceImpl implements MentorService {

    /**
     The mentorRassignmentRepositoryepository field is annotated
     with @Autowired, indicating that it is a dependency to be automatically
     injected by the Spring framework.
     */
    @Autowired
    private MentorRepository mentorRepository;



    /**
     Autowires the AssignmentRepository bean, which is used for
     performing database operations related to assignments.
     */
    @Autowired
    private AssignmentRepository assignmentRepository;




    /**
     Autowires the MongoTemplate bean, which provides
     the core MongoDB operations for the application.
     @param mongoTemplate The MongoTemplate object to be autowired.
     */
    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     Autowired field for the Publisher object.
     */
    @Autowired
    private Publisher publisher;

    /**
     Retrieves a list of all mentors.
     This method retrieves all the mentor records from the data source
     using the mentorRepository.
     It returns a list of Mentor objects representing all the mentors
     available in the system.
     @return A list of Mentor objects representing all mentors.
     */
    @Override
    public List<Mentor> getAllMentor() {
        return mentorRepository.findAll();
    }

    /**
     Adds a new mentor to the system.
     This method adds the provided Mentor object to the data source
     using the mentorRepository.
     @param mentor The Mentor object to be added.
     @return The added Mentor object.
     */
    @Override
    public Mentor addMentor(final Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    /**
     Updates an existing mentor in the system.
     @param mentor The updated Mentor object containing the new information.
     @param mentorId The ID of the mentor to be updated.
     @return A string indicating the success of the update operation.
     @throws OpenApiResourceNotFoundException if the mentor
     with the given ID is not found in the data source.
     */
    @Override
    public String updateMentor(final Mentor mentor, final Integer mentorId) {
        Mentor existingMentor = mentorRepository.findById(mentorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Mentor not found with Id " + mentorId));
        existingMentor.setEmpId(mentor.getEmpId());
        existingMentor.setCompetencyName(mentor.getCompetencyName());
        existingMentor.setModifiedDate(LocalDate.now());
        mentorRepository.save(existingMentor);
        return "record has been updated";
    }

    /**
     Deletes a mentor from the system.
     This method deletes the mentor with the specified mentorId
     from the data source.
     @param mentorId The ID of the mentor to be deleted.
     @return A string indicating the success of the delete operation,
     including the ID of the deleted mentor.
     */
    @Override
    public String deleteMentor(final Integer mentorId) {
        Optional<Mentor> mentor = mentorRepository.findById(mentorId);
        if (mentor.isPresent()) {
            mentorRepository.deleteById(mentorId);
            return "deleted mentor where id = " + mentorId;
        } else {
            throw new ResourceNotFoundException("no record of this id found");
        }
    }

    /**
     Retrieves the details of a specific mentor.
     This method retrieves the mentor with the specified mentorId
     from the data source using the
     mentorRepository.
     @param mentorId The ID of the mentor to retrieve details for.
     @return An Optional object containing the mentor details if found,
     otherwise empty.
     */
    @Override
    public Optional<Mentor> getDetailsOfMentor(final Integer mentorId) {
        return mentorRepository.findById(mentorId);
    }



    /**

     Creates an assignment by saving it in the repository
     and sending a message through the publisher.
     @param assignment The Assignment object to be created and saved.
     @return A string indicating the status of the operation.
     @throws EmptyInputException If the assignment object is null or empty.
     */
    @Override
    public String createAssignment(final Assignment assignment) {
        Assignment assignment1 = assignmentRepository.save(assignment);
        if (assignment1 != null) {
            publisher.messageSender();
            return "assignment is saved";
        } else {
            throw new EmptyInputException("Please enter a valid Input");
        }
    }
}
