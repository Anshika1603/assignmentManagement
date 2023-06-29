package com.knoldus.assignmentmanagementsystem;

import com.knoldus.assignmentmanagementsystem.exception.ResourceNotFoundException;
import com.knoldus.assignmentmanagementsystem.model.Mentor;
import com.knoldus.assignmentmanagementsystem.repository.MentorRepository;
import com.knoldus.assignmentmanagementsystem.service.impl.MentorServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MentorSeriveTest {
    @Mock
    MentorRepository mentorRepository;

    @InjectMocks
    MentorServiceImpl mentorService;


    @Test
    public void getAllMentor_ReturnListOfMentors() {
        // Mock the behavior of the MentorRepository
        List<Mentor> mockMentors = Arrays.asList(
                new Mentor(1, "EMP001", "Java", LocalDate.now(),LocalDate.now()),
                new Mentor(2, "EMP002", "Python",LocalDate.now(),LocalDate.now())
        );
        when(mentorRepository.findAll()).thenReturn(mockMentors);

        // Call the mentorService.getAllMentor() method
        List<Mentor> retrievedMentors = mentorService.getAllMentor();

        // Verify the expected behavior
        assertNotNull(retrievedMentors);
        assertEquals(2, retrievedMentors.size());
        assertEquals(1, retrievedMentors.get(0).getMentorId());
        assertEquals("EMP001", retrievedMentors.get(0).getEmpId());
        assertEquals("Java", retrievedMentors.get(0).getCompetencyName());
        assertEquals(2, retrievedMentors.get(1).getMentorId());
        assertEquals("EMP002", retrievedMentors.get(1).getEmpId());
        assertEquals("Python", retrievedMentors.get(1).getCompetencyName());

        // Verify that the mentorRepository.findAll() was called once
        Mockito.verify(mentorRepository, times(1)).findAll();
    }

    @Test
    public void addMentor_ReturnAddedMentor() {
        // Create a mock mentor object
        Mentor mentor = new Mentor();
        mentor.setMentorId(1);
        mentor.setEmpId("EMP001");
        mentor.setCompetencyName("Java");

        // Mock the behavior of the MentorRepository
        when(mentorRepository.save(mentor)).thenReturn(mentor);

        // Call the mentorService.addMentor() method
        Mentor addedMentor = mentorService.addMentor(mentor);

        // Verify the expected behavior
        assertNotNull(addedMentor);
        assertEquals(1, addedMentor.getMentorId());
        assertEquals("EMP001", addedMentor.getEmpId());
        assertEquals("Java", addedMentor.getCompetencyName());

        // Verify that the mentorRepository.save() was called once with the mentor object
        Mockito.verify(mentorRepository, times(1)).save(mentor);
    }

    @Test
    public void updateMentor_WhenMentorExists_ReturnSuccessMessage() {
        Integer mentorId = 1;

        // Create a mock mentor object
        Mentor mentor = new Mentor();
        mentor.setEmpId("EMP001");
        mentor.setCompetencyName("Java");

        // Mock the behavior of the MentorRepository
        Mentor existingMentor = new Mentor();
        existingMentor.setMentorId(mentorId);
        existingMentor.setEmpId("EMP002");
        existingMentor.setCompetencyName("Python");
        when(mentorRepository.findById(mentorId)).thenReturn(Optional.of(existingMentor));
        when(mentorRepository.save(existingMentor)).thenReturn(existingMentor);

        // Call the mentorService.updateMentor() method
        String result = mentorService.updateMentor(mentor, mentorId);

        // Verify the expected behavior
        assertNotNull(result);
        assertEquals("record has been updated", result);
        assertEquals("EMP001", existingMentor.getEmpId());
        assertEquals("Java", existingMentor.getCompetencyName());
        assertNotNull(existingMentor.getModifiedDate());

        // Verify that the mentorRepository.findById() was called once with the correct mentorId
      Mockito.verify(mentorRepository, times(1)).findById(mentorId);

        // Verify that the mentorRepository.save() was called once with the existingMentor object
        Mockito.verify(mentorRepository, times(1)).save(existingMentor);
    }

    @Test
    public void updateMentor_WhenMentorDoesNotExist_ThrowResourceNotFoundException() {
        Integer mentorId = 1;

        // Create a mock mentor object
        Mentor mentor = new Mentor();
        mentor.setEmpId("EMP001");
        mentor.setCompetencyName("Java");

        // Mock the behavior of the MentorRepository to return an empty Optional
        when(mentorRepository.findById(mentorId)).thenReturn(Optional.empty());

        // Call the mentorService.updateMentor() method and expect a ResourceNotFoundException to be thrown
        assertThrows(ResourceNotFoundException.class, () -> mentorService.updateMentor(mentor, mentorId));

        // Verify that the mentorRepository.findById() was called once with the correct mentorId
        Mockito.verify(mentorRepository, times(1)).findById(mentorId);

        // Verify that the mentorRepository.save() was never called
        Mockito.verify(mentorRepository, never()).save(any(Mentor.class));
    }



}
