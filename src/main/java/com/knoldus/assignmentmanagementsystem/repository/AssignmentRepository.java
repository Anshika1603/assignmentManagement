package com.knoldus.assignmentmanagementsystem.repository;

import com.knoldus.assignmentmanagementsystem.model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends MongoRepository<Assignment, String> {
}
