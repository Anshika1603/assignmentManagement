package com.knoldus.assignmentmanagementsystem;

import com.knoldus.assignmentmanagementsystem.exception.ResourceNotFoundException;
import com.knoldus.assignmentmanagementsystem.model.InternMentorMap;
import com.knoldus.assignmentmanagementsystem.model.InternMentorMapId;
import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import com.knoldus.assignmentmanagementsystem.repository.InternMentorRepository;
import com.knoldus.assignmentmanagementsystem.repository.InternRepository;
import com.knoldus.assignmentmanagementsystem.repository.KipKupRepository;
import com.knoldus.assignmentmanagementsystem.repository.MentorRepository;
import com.knoldus.assignmentmanagementsystem.service.impl.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AdminServiceTest {
    @Mock
    private KipKupRepository kipKupRepository;


    @Mock
    private InternRepository internRepository;

    @Mock
    private MentorRepository mentorRepository;

    @Mock
    private InternMentorRepository internMentorRepository;


    @InjectMocks
    AdminServiceImpl adminService;

    @Test
    public void createPlan_WhenPlanIsCreated_ReturnSuccessMessage() {
        KipKupPlan kipKupPlan = new KipKupPlan();
        kipKupPlan.setSessionId(1);
        kipKupPlan.setDate(LocalDate.now());
        kipKupPlan.setTime("10:00 AM");
        kipKupPlan.setTopic("Java Basics");
        kipKupPlan.setMentorName("John Doe");
        kipKupPlan.setPlanType("Standard");

        // Call the adminService.createPlan() method
        String result = adminService.createPlan(kipKupPlan);

        // Verify the expected behavior
        assertNotNull(result);
        assertEquals("Created Plan", result);

        // Verify that the kipKupRepository.save() was called once with the correct kipKupPlan object
        Mockito.verify(kipKupRepository, times(1)).save(kipKupPlan);
    }

    @Test
    public void updateKipKupPlan_WhenPlanExists_ReturnSuccessMessage() {
        Integer sessionId = 1;
        KipKupPlan existingPlan = new KipKupPlan();
        existingPlan.setSessionId(sessionId);
        existingPlan.setDate(LocalDate.of(2023, 6, 27));
        existingPlan.setTime("10:00 AM");
        existingPlan.setTopic("Java Basics");
        existingPlan.setMentorName("John Doe");
        existingPlan.setPlanType("Standard");

        KipKupPlan updatedPlan = new KipKupPlan();
        updatedPlan.setSessionId(sessionId);
        updatedPlan.setDate(LocalDate.of(2023, 6, 28));
        updatedPlan.setTime("2:00 PM");
        updatedPlan.setTopic("Advanced Java");
        updatedPlan.setMentorName("Jane Smith");
        updatedPlan.setPlanType("Premium");

       when(kipKupRepository.findById(sessionId)).thenReturn(Optional.of(existingPlan));

        // Call the adminService.updateKipKupPlan() method
        String result = adminService.updateKipKupPlan(updatedPlan, sessionId);

        // Verify the expected behavior
        assertNotNull(result);
        assertEquals("Updated Plan", result);
        assertEquals(updatedPlan.getDate(), existingPlan.getDate());
        assertEquals(updatedPlan.getTopic(), existingPlan.getTopic());
        assertEquals(updatedPlan.getTime(), existingPlan.getTime());
        assertEquals(updatedPlan.getPlanType(), existingPlan.getPlanType());
        assertEquals(updatedPlan.getMentorName(), existingPlan.getMentorName());

        // Verify that the kipKupRepository.findById() was called once with the correct session ID
        Mockito.verify(kipKupRepository, times(1)).findById(sessionId);
        Mockito.verify(kipKupRepository,times(1)).save(existingPlan);
    }

    @Test
    public void updateKipKupPlan_WhenPlanDoesNotExist_ThrowResourceNotFoundException() {
        Integer sessionId = 1;
        KipKupPlan updatedPlan = new KipKupPlan();
        updatedPlan.setSessionId(sessionId);
        updatedPlan.setDate(LocalDate.of(2023, 6, 28));
        updatedPlan.setTime("2:00 PM");
        updatedPlan.setTopic("Advanced Java");
        updatedPlan.setMentorName("Jane Smith");
        updatedPlan.setPlanType("Premium");

        when(kipKupRepository.findById(sessionId)).thenReturn(Optional.empty());

        // Call the adminService.updateKipKupPlan() method and expect a ResourceNotFoundException
        assertThrows(ResourceNotFoundException.class, () -> adminService.updateKipKupPlan(updatedPlan, sessionId));

        // Verify that the kipKupRepository.findById() was called once with the correct session ID
       Mockito.verify(kipKupRepository, times(1)).findById(sessionId);
    }

    @Test
    public void assignMentorToIntern_WhenInternAndMentorExist_AssignMentorToIntern() {
        // Create an instance of InternMentorMap
        InternMentorMap internMentorMap = new InternMentorMap();
        internMentorMap.setInternId(1);
        internMentorMap.setMentorId(1);

        // Mock the behavior of the existById methods to return true
        when(internRepository.existsById(1)).thenReturn(true);
        when(mentorRepository.existsById(1)).thenReturn(true);

        // Call the assignMentorToIntern method and expect a successful assignment message
        String result = adminService.assignMentorToIntern(internMentorMap);

        // Verify that the internMentorRepository.save method was called
       Mockito.verify(internMentorRepository, times(1)).save(internMentorMap);

        // Assert the expected result message
        assertEquals("Assigned Mentor 1 to Intern 1", result);
    }

    @Test
    public void assignMentorToIntern_WhenMentorDoesNotExist_ThrowResourceNotFoundException() {
        // Create an instance of InternMentorMap
        InternMentorMap internMentorMap = new InternMentorMap();
        internMentorMap.setInternId(1);
        internMentorMap.setMentorId(1);

        // Mock the behavior of the existById methods to return false for mentor
        when(internRepository.existsById(1)).thenReturn(true);
        when(mentorRepository.existsById(1)).thenReturn(false);

        // Call the assignMentorToIntern method and expect a ResourceNotFoundException
        assertThrows(ResourceNotFoundException.class, () -> adminService.assignMentorToIntern(internMentorMap));

        // Verify that the internMentorRepository.save method was not called
        Mockito.verify(internMentorRepository, never()).save(internMentorMap);
    }

    @Test
    public void reassignMentor_WhenMentorInternMapExists_ReassignMentorToIntern() {
        // Create an instance of InternMentorMapId and InternMentorMap
        InternMentorMapId internMentorMapId = new InternMentorMapId(1, 1);
        InternMentorMap internMentorMap = new InternMentorMap();
        internMentorMap.setInternId(1);
        internMentorMap.setMentorId(2);

        // Mock the behavior of the existById method to return true
        when(internMentorRepository.existsById(internMentorMapId)).thenReturn(true);

        // Call the reassignMentor method and expect a successful reassignment message
        String result = adminService.reassignMentor(internMentorMapId, internMentorMap);

        // Verify that the internMentorRepository.save method was called
        verify(internMentorRepository, times(1)).save(internMentorMap);

        // Assert the expected result message
        assertEquals("Reassigned Mentor 2 to Intern 1", result);
    }
    @Test
    public void reassignMentor_WhenMentorInternMapDoesNotExist_ThrowResourceNotFoundException() {
        // Create an instance of InternMentorMapId and InternMentorMap
        InternMentorMapId internMentorMapId = new InternMentorMapId(1, 1);
        InternMentorMap internMentorMap = new InternMentorMap();
        internMentorMap.setInternId(1);
        internMentorMap.setMentorId(2);

        // Mock the behavior of the existById method to return false
        when(internMentorRepository.existsById(internMentorMapId)).thenReturn(false);

        // Call the reassignMentor method and expect a ResourceNotFoundException
        assertThrows(ResourceNotFoundException.class, () -> adminService.reassignMentor(internMentorMapId, internMentorMap));

        // Verify that the internMentorRepository.save method was not called
        verify(internMentorRepository, never()).save(internMentorMap);
    }

}
