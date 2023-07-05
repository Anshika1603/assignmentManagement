package com.knoldus.assignmentmanagementsystem.repository;

import com.knoldus.assignmentmanagementsystem.model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 The AssignmentRepository interface provides CRUD operations for the Assignment collection in MongoDB.
 @param <Assignment> the type of the entity class (Assignment)
 @param <String> the type of the ID field in the entity class (String)
 */
@Repository
public interface AssignmentRepository extends MongoRepository<Assignment, String> {
}
