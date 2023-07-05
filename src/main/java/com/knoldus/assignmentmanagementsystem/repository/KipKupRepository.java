package com.knoldus.assignmentmanagementsystem.repository;

import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 The KipKupRepository interface provides CRUD operations for the KipKupPlan entity
 using the JpaRepository interface.
 @param <KipKupPlan> the type of the entity class (KipKupPlan)
 @param <Integer> the type of the ID field in the entity class (Integer)
 */
@Repository
public interface KipKupRepository extends JpaRepository<KipKupPlan, Integer> {
}
