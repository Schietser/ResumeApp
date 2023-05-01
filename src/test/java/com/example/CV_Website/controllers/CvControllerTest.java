package com.example.CV_Website.controllers;

import com.example.CV_Website.models.entities.WorkExperienceEntity;
import com.example.CV_Website.services.flow.WorkExperienceService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Paths.get;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CvControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    private CvController cvController;

    @Mock
    private WorkExperienceService workExperienceService;

    @BeforeEach
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(cvController).build();

    }

    @Test
    public void testGreetingEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Welcome to my digital resume"));
    }

    @Test
    public void testShowAllEndpoint() throws Exception {

        // Create a list of work experiences for testing
        List<WorkExperienceEntity> workExperienceList = new ArrayList<>();
        workExperienceList.add(new WorkExperienceEntity("Employer1", "2021 - 2022", "Job Title", "Description"));
        workExperienceList.add(new WorkExperienceEntity("Employer2", "2020 - 2021", "Job Title", "Description"));
        workExperienceList.add(new WorkExperienceEntity("Employer3", "2019 - 2020", "Job Title", "Description"));

        // Configure the mock WorkExperienceService to return the list of work experiences
        Mockito.when(workExperienceService.showAllWorkexperience()).thenReturn(workExperienceList);

        // Perform a GET request to the "/workexperience" endpoint and verify the response
        mockMvc.perform(MockMvcRequestBuilders.get("/workexperience"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(workExperienceList.size()));
    }


//
//    @Test
//    void showAllEducations() {
//    }
//
//    @Test
//    void findEducationById() {
//    }
//
//    @Test
//    void createEducation() {
//    }
//
//    @Test
//    void returnById() {
//    }
//
//    @Test
//    void createWorkexperience() {
//    }
}