package com.knoldus.assignmentmanagementsystem.repository;

import com.knoldus.assignmentmanagementsystem.model.InternMentorMap;
import com.knoldus.assignmentmanagementsystem.model.InternMentorMapId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**

 The InternMentorRepository interface provides CRUD operations
 for the InternMentorMap entity
 using the JpaRepository interface.
 */
@Repository
public interface InternMentorRepository extends
        JpaRepository<InternMentorMap, InternMentorMapId> {
}
