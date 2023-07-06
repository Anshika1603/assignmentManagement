package com.knoldus.assignmentmanagementsystem.model;

import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.Objects;

/**
 The InternMentorMapId class represents the composite primary key
 for the InternMentorMap entity in the system.
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
     Constructs a new InternMentorMapId object with the
     specified intern ID and mentor ID.
     @param internId1 The ID of the intern.
     @param mentorId1 The ID of the mentor.
     */
    public InternMentorMapId(final Integer internId1, final Integer mentorId1) {
        this.internId = internId1;
        this.mentorId = mentorId1;
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
     @param internId1 The ID of the intern.
     */
    public void setInternId(final Integer internId1) {
        this.internId = internId1;
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
     @param mentorId1 The ID of the mentor.
     */
    public void setMentorId(final Integer mentorId1) {
        this.mentorId = mentorId1;
    }


    /**
     Compares this InternMentorMapId object to
     the specified object for equality.
     @param o The object to compare.
     @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InternMentorMapId that = (InternMentorMapId) o;
        return Objects.equals(internId, that.internId)
                && Objects.equals(mentorId, that.mentorId);
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
