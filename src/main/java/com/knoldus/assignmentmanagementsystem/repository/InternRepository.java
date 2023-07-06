package com.knoldus.assignmentmanagementsystem.repository;

import com.knoldus.assignmentmanagementsystem.model.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 The InternRepository interface provides CRUD operations for the Intern entity
 using the JpaRepository interface.
 */
@Repository
public interface InternRepository extends JpaRepository<Intern, Integer> {
}
