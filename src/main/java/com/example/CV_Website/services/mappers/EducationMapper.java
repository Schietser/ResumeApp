package com.example.CV_Website.services.mappers;

import com.example.CV_Website.models.dto.CreateEducationExperience;
import com.example.CV_Website.models.dto.CreateWorkExperience;
import com.example.CV_Website.models.entities.EducationEntity;
import com.example.CV_Website.models.entities.WorkExperienceEntity;

public interface EducationMapper {

    EducationEntity toEntity (CreateEducationExperience req);
}
