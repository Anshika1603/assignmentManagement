package com.knoldus.assignmentmanagementsystem;

import com.knoldus.assignmentmanagementsystem.exception.ResourceNotFoundException;
import com.knoldus.assignmentmanagementsystem.model.Intern;
import com.knoldus.assignmentmanagementsystem.repository.InternRepository;
import com.knoldus.assignmentmanagementsystem.service.impl.InternServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class InternServiceTest {
    @Mock
    InternRepository internRepository;
    @InjectMocks
    InternServiceImpl internService;

    @Test
    public void addIntern_WhenInternIsValid_ReturnSavedIntern() {
        // Create a mock intern object
        Intern mockIntern = new Intern(2, "EMP002", "Python Development", "Jane", "Smith", "Python, Django", LocalDate.of(2023, 6, 30), LocalDate.of(2023, 6, 30));

        // Mock the behavior of the InternRepository to return the saved intern
        when(internRepository.save(mockIntern)).thenReturn(mockIntern);

        // Call the internService.addIntern() method
        Intern savedIntern = internService.addIntern(mockIntern);

        // Verify the expected behavior
        assertNotNull(savedIntern);
        assertEquals(mockIntern.getInternId(), savedIntern.getInternId());
        assertEquals(mockIntern.getFirstName(), savedIntern.getFirstName());
        assertEquals(mockIntern.getLastName(), mockIntern.getLastName());

        // Verify that the internRepository.save() was called once with the correct intern object
        Mockito.verify(internRepository, times(1)).save(mockIntern);
    }

    @Test
    public void updateIntern_WhenInternExists_UpdateInternDetailsAndReturnSuccessMessage() {
        Integer internId = 1;
        Intern mockExistingIntern = new Intern(1, "EMP001", "Java Development", "John", "Doe", "Java, Spring, Hibernate", LocalDate.of(2023, 6, 29), LocalDate.of(2023, 6, 29));
        Intern updatedIntern = new Intern(2, "EMP002", "Python Development", "Jane", "Smith", "Python, Django", LocalDate.of(2023, 6, 30), LocalDate.of(2023, 6, 30));

        // Mock the behavior of the InternRepository to return the existing intern
        when(internRepository.findById(internId)).thenReturn(Optional.of(mockExistingIntern));

        // Call the internService.updateIntern() method
        String result = internService.updateIntern(updatedIntern, internId);

        // Verify the expected behavior
        assertEquals("Updated Record of Intern", result);
        assertEquals(updatedIntern.getFirstName(), mockExistingIntern.getFirstName());
        assertEquals(updatedIntern.getLastName(), mockExistingIntern.getLastName());
        assertEquals(updatedIntern.getEmpId(), mockExistingIntern.getEmpId());
        assertEquals(updatedIntern.getCompetencyName(), mockExistingIntern.getCompetencyName());
        assertEquals(updatedIntern.getSkills(), mockExistingIntern.getSkills());

        // Verify that the internRepository.findById() was called once with the correct intern ID
        verify(internRepository, times(1)).findById(internId);
    }


    @Test
    public void updateIntern_WhenInternDoesNotExist_ThrowException() {
        Integer internId = 1;
        Intern updatedIntern = new Intern(2, "EMP002", "Python Development", "Jane", "Smith", "Python, Django", LocalDate.of(2023, 6, 30), LocalDate.of(2023, 6, 30));

        // Mock the behavior of the InternRepository to return an empty Optional
        when(internRepository.findById(internId)).thenReturn(Optional.empty());

        // Call the internService.updateIntern() method and expect a ResourceNotFoundException
        assertThrows(ResourceNotFoundException.class, () -> internService.updateIntern(updatedIntern, internId));

        // Verify that the internRepository.findById() was called once with the correct intern ID
        verify(internRepository, times(1)).findById(internId);
    }


    @Test
    public void getDetails_WhenInternExists_ReturnInternOptional() {
        Integer internId = 1;
        Intern mockIntern = new Intern(2, "EMP002", "Python Development", "Jane", "Smith", "Python, Django", LocalDate.of(2023, 6, 30), LocalDate.of(2023, 6, 30));

        // Mock the behavior of the InternRepository to return a non-empty Optional
        when(internRepository.findById(internId)).thenReturn(Optional.of(mockIntern));

        // Call the internService.getDetails() method
        Optional<Intern> result = internService.getDetails(internId);

        // Verify the expected behavior
        assertTrue(result.isPresent());
        assertEquals(mockIntern, result.get());

        // Verify that the internRepository.findById() was called once with the correct intern ID
        verify(internRepository, times(1)).findById(internId);
    }

    @Test
    public void getDetails_WhenInternDoesNotExist_ReturnEmptyOptional() {
        Integer internId = 1;

        // Mock the behavior of the InternRepository to return an empty Optional
        when(internRepository.findById(internId)).thenReturn(Optional.empty());

        // Call the internService.getDetails() method
        Optional<Intern> result = internService.getDetails(internId);

        // Verify the expected behavior
        assertFalse(result.isPresent());

        // Verify that the internRepository.findById() was called once with the correct intern ID
        verify(internRepository, times(1)).findById(internId);
    }

    @Test
    public void deleteIntern_WhenInternExists_ReturnSuccessMessage() {
        Integer internId = 1;
        when(internRepository.findById(internId)).thenReturn(Optional.of(new Intern(2, "EMP002", "Python Development", "Jane", "Smith", "Python, Django", LocalDate.of(2023, 6, 30), LocalDate.of(2023, 6, 30))));

        String result = internService.deleteIntern(internId);

        assertNotNull(result);
        assertEquals("Deleted Record of Intern with Id = " + internId, result);

        verify(internRepository, times(1)).deleteById(internId);
    }


    @Test
    public void deleteIntern_WhenInternDoesNotExist_ThrowResourceNotFoundException() {
        Integer internId = 1;
        when(internRepository.findById(internId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> internService.deleteIntern(internId));

        verify(internRepository, never()).deleteById(internId);
    }

}



