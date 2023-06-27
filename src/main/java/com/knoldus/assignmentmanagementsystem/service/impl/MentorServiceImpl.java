package com.knoldus.assignmentmanagementsystem.service.impl;

import com.knoldus.assignmentmanagementsystem.exception.ResourceNotFoundException;
import com.knoldus.assignmentmanagementsystem.model.Mentor;
import com.knoldus.assignmentmanagementsystem.repository.MentorRepository;
import com.knoldus.assignmentmanagementsystem.service.MentorService;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;
    @Override
    public List<Mentor> getAllMentor() {
        return mentorRepository.findAll();
    }

    @Override
    public Mentor addMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    @Override
    public String updateMentor(Mentor mentor, Integer mentorId) {
        Mentor existingMentor=mentorRepository.findById(mentorId).orElseThrow(() -> new ResourceNotFoundException("Mentor not found with Id: "+mentorId));
        existingMentor.setEmployeeId(mentor.getEmployeeId());
        existingMentor.setName(mentor.getName());
        existingMentor.setStudio(mentor.getStudio());
        return "record has been updated";
    }

    @Override
    public String deleteMentor(Integer mentorId) {
        mentorRepository.deleteById(mentorId);
        return "deleted mentor where id = "+mentorId;
    }

    @Override
    public Optional<Mentor> getDetailsOfMentor(Integer mentorId) {
        return mentorRepository.findById(mentorId);
    }
}
