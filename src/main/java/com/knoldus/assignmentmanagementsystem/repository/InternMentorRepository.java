package com.knoldus.assignmentmanagementsystem.repository;

import com.knoldus.assignmentmanagementsystem.model.InternMentorMap;
import com.knoldus.assignmentmanagementsystem.model.InternMentorMapId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**

 The InternMentorRepository interface provides CRUD operations for the InternMentorMap entity
 using the JpaRepository interface.
 @param <InternMentorMap> the type of the entity class (InternMentorMap)
 @param <InternMentorMapId> the type of the ID class for the InternMentorMap entity (InternMentorMapId)
 */
@Repository
public interface InternMentorRepository extends JpaRepository<InternMentorMap, InternMentorMapId> {
}
