package com.knoldus.assignmentmanagementsystem.service.impl;

import com.knoldus.assignmentmanagementsystem.exception.ResourceNotFoundException;
import com.knoldus.assignmentmanagementsystem.model.Mentor;
import com.knoldus.assignmentmanagementsystem.repository.MentorRepository;
import com.knoldus.assignmentmanagementsystem.service.MentorService;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
     The mentorRepository field is annotated with @Autowired,
     indicating that it is a dependency
     to be automatically injected by the Spring framework.
     */
    @Autowired
    private MentorRepository mentorRepository;

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
        existingMentor.setEmployeeId(mentor.getEmployeeId());
        existingMentor.setName(mentor.getName());
        existingMentor.setStudio(mentor.getStudio());
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
        mentorRepository.deleteById(mentorId);
        return "deleted mentor where id = " + mentorId;
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
}
