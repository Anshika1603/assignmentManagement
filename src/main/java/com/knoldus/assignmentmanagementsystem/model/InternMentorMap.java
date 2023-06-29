package com.knoldus.assignmentmanagementsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(InternMentorMapId.class)
@Table(name = "InternMentorMap")
public class InternMentorMap {

    @Id
    private Integer internId;

    @Id
    private Integer mentorId;

    private LocalDate currentDate=LocalDate.now();

    private LocalDate modifiedDate=LocalDate.now();

//    public Integer getInternId() {
//        return internId;
//    }
//
//    public void setInternId(Integer internId) {
//        this.internId = internId;
//    }
//
//    public Integer getMentorId() {
//        return mentorId;
//    }
//
//    public void setMentorId(Integer mentorId) {
//        this.mentorId = mentorId;
//    }
//
//    public LocalDate getCurrentDate() {
//        return currentDate;
//    }
//
//    public void setCurrentDate(LocalDate currentDate) {
//        this.currentDate = currentDate;
//    }
//
//    public LocalDate getModifiedDate() {
//        return modifiedDate;
//    }
//
//    public void setModifiedDate(LocalDate modifiedDate) {
//        this.modifiedDate = modifiedDate;
//    }
//
//    public InternMentorMap(Integer internId, Integer mentorId, LocalDate currentDate, LocalDate modifiedDate) {
//        this.internId = internId;
//        this.mentorId = mentorId;
//        this.currentDate = currentDate;
//        this.modifiedDate = modifiedDate;
//    }
//
//    public InternMentorMap() {
//    }
}
