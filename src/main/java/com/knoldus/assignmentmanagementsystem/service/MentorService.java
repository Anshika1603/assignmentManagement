package com.knoldus.assignmentmanagementsystem.service;

import com.knoldus.assignmentmanagementsystem.model.Mentor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MentorService {
    public List<Mentor> getAllMentor();

    public Mentor addMentor(Mentor mentor);

    public String updateMentor(Mentor mentor, Integer mentorId);

    public String deleteMentor(Integer mentorId);

    public Optional<Mentor> getDetailsOfMentor(Integer mentorId);

}
