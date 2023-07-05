package com.knoldus.assignmentmanagementsystem.service;
import com.knoldus.assignmentmanagementsystem.model.Assignment;
import com.knoldus.assignmentmanagementsystem.model.Intern;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 This interface represents the service layer for handling Intern entities.
 It defines methods for retrieving, adding, updating, and deleting Interns.
 */

@Service
public interface InternService {

    /**
     Retrieves a list of all Interns.
     @return A list of Intern objects representing all Interns.
     */
    List<Intern> getAll();

    /**
     Adds a new Intern to the system.
     @param intern The Intern object to be added.
     @return The added Intern object.
     */
    Intern addIntern(Intern intern);

    /**
     Updates an existing Intern in the system.
     @param intern The updated Intern object.
     @param internId The ID of the Intern to be updated.
     @return A string indicating the success or failure of the update operation.
     */
    String updateIntern(Intern intern, Integer internId);

    /**
     Deletes an Intern from the system.
     @param internId The ID of the Intern to be deleted.
     @return A string indicating the success or failure of the delete operation.
     */
    String deleteIntern(Integer internId);

    /**
     Retrieves the details of a specific Intern.
     @param internId The ID of the Intern to retrieve details for.
     @return An Optional object containing the Intern details if found,
     otherwise empty.
     */
    Optional<Intern> getDetails(Integer internId);

    /**
     Submits an assignment.
     @param assignment The Assignment object to be submitted.
     @return A string indicating the successful submission of the assignment.
     */
    String submitAssignment(Assignment assignment);
}
