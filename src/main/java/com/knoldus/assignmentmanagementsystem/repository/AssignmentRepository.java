package com.knoldus.assignmentmanagementsystem.repository;

import com.knoldus.assignmentmanagementsystem.model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 The AssignmentRepository interface provides CRUD
 operations for the Assignment collection in MongoDB.
 */
@Repository
public interface AssignmentRepository extends
        MongoRepository<Assignment, String> {
}
