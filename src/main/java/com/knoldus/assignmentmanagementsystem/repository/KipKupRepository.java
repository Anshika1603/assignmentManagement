package com.knoldus.assignmentmanagementsystem.repository;

import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KipKupRepository extends JpaRepository<KipKupPlan, Integer> {
}
