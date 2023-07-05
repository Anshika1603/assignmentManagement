package com.knoldus.assignmentmanagementsystem.repository;

import com.knoldus.assignmentmanagementsystem.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 The MentorRepository interface provides CRUD operations for the Mentor entity
 using the JpaRepository interface.
 @param <Mentor> the type of the entity class (Mentor)
 @param <Integer> the type of the ID field in the entity class (Integer)
 */
@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer> {
}
