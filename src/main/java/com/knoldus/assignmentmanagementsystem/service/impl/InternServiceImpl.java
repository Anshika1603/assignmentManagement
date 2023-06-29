package com.knoldus.assignmentmanagementsystem.service.impl;

import com.knoldus.assignmentmanagementsystem.exception.ResourceNotFoundException;
import com.knoldus.assignmentmanagementsystem.model.Intern;
import com.knoldus.assignmentmanagementsystem.repository.InternRepository;
import com.knoldus.assignmentmanagementsystem.service.InternService;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * The InternServiceImpl class is an implementation of
 * the InternService interface,
 * representing the service layer for handling intern entities in the
 * Assignment Management System.
 */
@Component
public class InternServiceImpl implements InternService {

    /**
     * This field represents an instance of the InternRepository interface,
     * which is responsible for
     * interacting with the underlying data storage and performing
     * database operations related to interns.
     */
    @Autowired
    private InternRepository internRepository;

    /**
     * Retrieves a list of all interns.
     * This method retrieves all the intern records from the data source
     * using the internRepository.
     * It returns a list of Intern objects representing all the interns
     * available in the system.
     *
     * @return A list of Intern objects representing all interns.
     */
    @Override
    public List<Intern> getAll() {
        return internRepository.findAll();
    }

    /**
     * Adds a new intern to the system.
     * This method adds the provided Intern object to the data source
     * using the internRepository.
     *
     * @param intern The Intern object to be added.
     * @return The added Intern object.
     */
    @Override
    public Intern addIntern(final Intern intern) {
        return internRepository.save(intern);
    }

    /**
     * Updates an existing intern in the system.
     *
     * @param intern   The updated Intern object containing the new information.
     * @param internId The ID of the intern to be updated.
     * @return A string indicating the success of the update operation.
     * @throws OpenApiResourceNotFoundException if the intern with the given ID is not found in the data source.
     */
    @Override
    public String updateIntern(Intern intern, Integer internId) {
        Intern existingIntern = internRepository.findById(internId).orElseThrow(() -> new ResourceNotFoundException("Intern not found with InternId " + internId));
        existingIntern.setEmpId(intern.getEmpId());
        existingIntern.setCompetencyName(intern.getCompetencyName());
        existingIntern.setSkills(intern.getSkills());
        existingIntern.setFirstName(intern.getFirstName());
        existingIntern.setLastName(intern.getLastName());
        existingIntern.setModifiedDate(LocalDate.now());
        return "Updated Record of Intern";
    }

    /**
     * Deletes an intern from the system.
     * This method deletes the intern with the specified internId
     * from the data source.
     *
     * @param internId The ID of the intern to be deleted.
     * @return A string indicating the success of the delete operation,
     * including the ID of the deleted intern.
     */
    @Override
    public String deleteIntern(final Integer internId) {
        Optional<Intern> intern = internRepository.findById(internId);
        if (intern.isPresent()) {
            internRepository.deleteById(internId);
            return "Deleted Record of Intern with Id = " + internId;
        } else {
            throw new ResourceNotFoundException("no record found of this id ");
        }
    }

    /**
     * Retrieves the details of a specific intern.
     * This method retrieves the intern with the specified internId
     * from the data source using the
     * internRepository.
     *
     * @param internId The ID of the intern to retrieve details for.
     * @return An Optional object containing the intern details
     * if found, otherwise empty.
     */
    @Override
    public Optional<Intern> getDetails(final Integer internId) {
        return internRepository.findById(internId);
    }
}
