package com.example.CV_Website.services.flow;

import com.example.CV_Website.models.dto.CreateWorkExperience;
import com.example.CV_Website.models.entities.WorkExperienceEntity;
import com.example.CV_Website.models.repositories.WorkExperienceRepository;
import com.example.CV_Website.services.mappers.WorkExperienceMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WorkExperienceServiceTest {

        @Mock
        private WorkExperienceRepository workExperienceRepository;

        @Mock
        private WorkExperienceMapperImpl workExperienceMapper;

        @InjectMocks
        private WorkExperienceService workExperienceService;

        @BeforeEach
        public void init() {
            MockitoAnnotations.openMocks(this);
            workExperienceService = new WorkExperienceService(workExperienceRepository, workExperienceMapper);
        }

    @Test
    public void testCreateWorkExperience() {
        // Mock input
        CreateWorkExperience createWorkExperience = new CreateWorkExperience();
        createWorkExperience.setEmployer("Acme Inc.");
        createWorkExperience.setJobTitle("Software Developer");
        createWorkExperience.setTimePeriod("2018-2021");
        createWorkExperience.setDescription("Worked on a project to build a new website");

        // Mock output
        WorkExperienceEntity workExperienceEntity = new WorkExperienceEntity();
        workExperienceEntity.setEmployer("Acme Inc.");
        workExperienceEntity.setJobTitle("Software Developer");
        workExperienceEntity.setTimePeriod("2018-2021");
        workExperienceEntity.setDescription("Worked on a project to build a new website");

        Mockito.when(workExperienceMapper.toEntity(createWorkExperience)).thenReturn(workExperienceEntity);

        // Call the method being tested
        workExperienceService.createWorkExperience(createWorkExperience);

        // Verify that the save method was called with the correct input
        verify(workExperienceRepository, times(1)).save(workExperienceEntity);
    }

    @Test
    public void testShowAllWorkExperience() {
        // Mock output
        WorkExperienceEntity workExperienceEntity1 = new WorkExperienceEntity();
        workExperienceEntity1.setEmployer("Acme Inc.");
        workExperienceEntity1.setJobTitle("Software Developer");
        workExperienceEntity1.setTimePeriod("2018-2021");
        workExperienceEntity1.setDescription("Worked on a project to build a new website");

        WorkExperienceEntity workExperienceEntity2 = new WorkExperienceEntity();
        workExperienceEntity2.setEmployer("Widget Corp.");
        workExperienceEntity2.setJobTitle("Data Analyst");
        workExperienceEntity2.setTimePeriod("2015-2018");
        workExperienceEntity2.setDescription("Analyzed data for marketing campaigns");

        List<WorkExperienceEntity> expectedOutput = Arrays.asList(workExperienceEntity1, workExperienceEntity2);

        Mockito.when(workExperienceRepository.findAll()).thenReturn(expectedOutput);

        // Call the method being tested
        List<WorkExperienceEntity> actualOutput = workExperienceService.showAllWorkexperience();

        // Verify that the output matches the expected output
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testFindJobById() {
        // Arrange
        String jobId = "1";
        WorkExperienceEntity jobEntity = new WorkExperienceEntity();
        jobEntity.setEmployer("Acme Inc.");
        jobEntity.setJobTitle("Software Engineer");
        jobEntity.setTimePeriod("2020-2022");
        jobEntity.setDescription("Developed software solutions for clients");

        Mockito.when(workExperienceRepository.findById(jobId)).thenReturn(Optional.of(jobEntity));

        // Act
        WorkExperienceEntity result = workExperienceService.findJobById(jobId);

        // Assert
        assertEquals(jobEntity.getEmployer(), result.getEmployer());
        assertEquals(jobEntity.getJobTitle(), result.getJobTitle());
        assertEquals(jobEntity.getTimePeriod(), result.getTimePeriod());
        assertEquals(jobEntity.getDescription(), result.getDescription());

        Mockito.verify(workExperienceRepository, Mockito.times(1)).findById(jobId);
    }
}