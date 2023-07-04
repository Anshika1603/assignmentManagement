package com.knoldus.assignmentmanagementsystem.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

/**
 The InternMentorMapId class represents the composite primary key for the InternMentorMap entity in the system.
 */
@Component
public class InternMentorMapId implements Serializable {

    /**
     The ID of the intern.
     */
    private Integer internId;


    /**
     The ID of the mentor.
     */
    private Integer mentorId;


    /**
     Constructs a new InternMentorMapId object with default values.
     */
    public InternMentorMapId() {
    }


    /**
     Constructs a new InternMentorMapId object with the specified intern ID and mentor ID.
     @param internId The ID of the intern.
     @param mentorId The ID of the mentor.
     */
    public InternMentorMapId(Integer internId, Integer mentorId) {
        this.internId = internId;
        this.mentorId = mentorId;
    }


    /**
     Returns the ID of the intern.
     @return The ID of the intern.
     */
    public Integer getInternId() {
        return internId;
    }


    /**
     Sets the ID of the intern.
     @param internId The ID of the intern.
     */
    public void setInternId(Integer internId) {
        this.internId = internId;
    }


    /**
     Returns the ID of the mentor.
     @return The ID of the mentor.
     */
    public Integer getMentorId() {
        return mentorId;
    }


    /**
     Sets the ID of the mentor.
     @param mentorId The ID of the mentor.
     */
    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }


    /**
     Compares this InternMentorMapId object to the specified object for equality.
     @param o The object to compare.
     @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternMentorMapId that = (InternMentorMapId) o;
        return Objects.equals(internId, that.internId) && Objects.equals(mentorId, that.mentorId);
    }


    /**
     Computes the hash code for this InternMentorMapId object.
     @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(internId, mentorId);
    }
}



