package com.knoldus.assignmentmanagementsystem.repository;

import com.knoldus.assignmentmanagementsystem.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 The MentorRepository interface provides CRUD operations for the Mentor entity
 using the JpaRepository interface.
 */
@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer> {
}
