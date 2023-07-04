package com.knoldus.assignmentmanagementsystem.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class InternMentorMapId implements Serializable {
    private Integer internId;
    private Integer mentorId;


    // Constructors

    public InternMentorMapId() {
    }

    public InternMentorMapId(Integer internId, Integer mentorId) {
        this.internId = internId;
        this.mentorId = mentorId;
    }

    // Getters and setters

    public Integer getInternId() {
        return internId;
    }

    public void setInternId(Integer internId) {
        this.internId = internId;
    }

    public Integer getMentorId() {
        return mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    // equals and hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternMentorMapId that = (InternMentorMapId) o;
        return Objects.equals(internId, that.internId) && Objects.equals(mentorId, that.mentorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internId, mentorId);
    }
}
