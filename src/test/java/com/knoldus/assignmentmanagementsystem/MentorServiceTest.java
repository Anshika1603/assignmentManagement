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
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the MentorServiceImpl class.
 */
@SpringBootTest
public class MentorServiceTest {
    @Mock
    MentorRepository mentorRepository;

    @InjectMocks
    MentorServiceImpl mentorService;



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


    @Test
    public void deleteMentor_WhenMentorExists_ReturnSuccessMessage() {
        Integer mentorId = 1;

        // Create a mock mentor object
        Mentor mentor = new Mentor();
        mentor.setMentorId(mentorId);
        mentor.setEmpId("EMP001");
        mentor.setCompetencyName("Java");

        // Mock the behavior of the MentorRepository
        when(mentorRepository.findById(mentorId)).thenReturn(Optional.of(mentor));

        // Call the mentorService.deleteMentor() method
        String result = mentorService.deleteMentor(mentorId);

        // Verify the expected behavior
        assertNotNull(result);
        assertEquals("deleted mentor where id = " + mentorId, result);

        // Verify that the mentorRepository.findById() was called once with the correct mentorId
        verify(mentorRepository, times(1)).findById(mentorId);

        // Verify that the mentorRepository.deleteById() was called once with the correct mentorId
        verify(mentorRepository, times(1)).deleteById(mentorId);
    }

    @Test
    public void deleteMentor_WhenMentorDoesNotExist_ThrowResourceNotFoundException() {
        Integer mentorId = 1;

        // Mock the behavior of the MentorRepository to return an empty Optional
        when(mentorRepository.findById(mentorId)).thenReturn(Optional.empty());

        // Call the mentorService.deleteMentor() method and expect a ResourceNotFoundException to be thrown
        assertThrows(ResourceNotFoundException.class, () -> mentorService.deleteMentor(mentorId));

        // Verify that the mentorRepository.findById() was called once with the correct mentorId
        verify(mentorRepository, times(1)).findById(mentorId);

        // Verify that the mentorRepository.deleteById() was never called
        verify(mentorRepository, never()).deleteById(mentorId);
    }

}
