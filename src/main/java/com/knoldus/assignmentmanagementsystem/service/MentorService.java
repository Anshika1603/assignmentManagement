package com.knoldus.assignmentmanagementsystem.service;

import com.knoldus.assignmentmanagementsystem.model.Assignment;
import com.knoldus.assignmentmanagementsystem.model.Mentor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 The MentorService interface defines the contract for managing
 mentor entities in the system.
 */
@Service
public interface MentorService {

    /**
     Retrieves a list of all mentors.
     @return A list of Mentor objects representing all mentors.
     */
    List<Mentor> getAllMentor();

    /**
     Adds a new mentor to the system.
     @param mentor The Mentor object to be added.
     @return The added Mentor object.
     */
    Mentor addMentor(Mentor mentor);

    /**
     Updates an existing mentor in the system.
     @param mentor The updated Mentor object containing the new information.
     @param mentorId The ID of the mentor to be updated.
     @return A string indicating the success of the update operation.
     */
    String updateMentor(Mentor mentor, Integer mentorId);

    /**
     Deletes a mentor from the system.
     @param mentorId The ID of the mentor to be deleted.
     @return A string indicating the success of the delete operation,
     including the ID of the deleted mentor.
     */
    String deleteMentor(Integer mentorId);

    /**
     Retrieves the details of a specific mentor.
     @param mentorId The ID of the mentor to retrieve details for.
     @return An Optional object containing the mentor details if found,
     otherwise empty.
     */
    Optional<Mentor> getDetailsOfMentor(Integer mentorId);


    /**
     Creates an assignment.
     @param assignment The Assignment object to be created.
     @return A string indicating the successful creation of the assignment.
     */
    String createAssignment(Assignment assignment);
}
