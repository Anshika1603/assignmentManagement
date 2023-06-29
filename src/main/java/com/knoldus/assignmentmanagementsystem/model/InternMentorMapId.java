package com.knoldus.assignmentmanagementsystem.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

public class InternMentorMapId implements Serializable {
    private Integer internId;
    private Integer mentorId;


    // Constructors

    public InternMentorMapId() {
        System.out.println("rahul kuam sinha --------------------------------------------------------------------------------------------------------------------");

    }

    public InternMentorMapId(Integer internId, Integer mentorId) {
        this.internId = internId;
        this.mentorId = mentorId;
        System.out.println("rahul kuam sinha --------------------------------------------------------------------------------------------------------------------");
    }

    // Getters and setters

    public Integer getInternId() {
        System.out.println("rahul kuam sinha --------------------------------------------------------------------------------------------------------------------");

        return internId;

    }

    public void setInternId(Integer internId) {
        System.out.println("rahul kuam sinha --------------------------------------------------------------------------------------------------------------------");

        this.internId = internId;
    }

    public Integer getMentorId() {
        System.out.println("rahul kuam sinha --------------------------------------------------------------------------------------------------------------------");

        return mentorId;
    }

    public void setMentorId(Integer mentorId) {
        System.out.println("rahul kuam sinha --------------------------------------------------------------------------------------------------------------------");
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
