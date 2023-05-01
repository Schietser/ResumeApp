package com.example.CV_Website.controllers;

import com.example.CV_Website.models.dto.CreateEducationExperience;
import com.example.CV_Website.models.dto.CreateWorkExperience;
import com.example.CV_Website.models.entities.EducationEntity;
import com.example.CV_Website.models.entities.WorkExperienceEntity;
import com.example.CV_Website.services.flow.EducationService;
import com.example.CV_Website.services.flow.WorkExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class CvController {

    private final WorkExperienceService workService;
    private final EducationService educationService;

    @GetMapping("/greeting")
    public String greeting(){
        return "Welcome to my digital resume";
    }

    @GetMapping("/workexperience")
    public List<WorkExperienceEntity> showAll(){
        return workService.showAllWorkexperience();
    }

    @GetMapping("/education")
    public List<EducationEntity> ShowAllEducations(){
        return educationService.showAllEducation();
    }

    @GetMapping("/education/{school}")
    public EducationEntity findEducationById(@PathVariable String school){
        return educationService.findEducationById(school);
    }

    @PostMapping("/createEducation")
    public void createEducation(@RequestBody CreateEducationExperience req){
        educationService.createWorkExperience(req);
    }

    @GetMapping("/workexperience/{employer}")
    public WorkExperienceEntity returnById(@PathVariable String employer){
        return workService.findJobById(employer);
    }

    @PostMapping("/createWorkExperience")
    public void createWorkexperience(@RequestBody CreateWorkExperience req){
        workService.createWorkExperience(req);
    }
}
