package com.example.CV_Website.services.mappers;

import com.example.CV_Website.models.dto.CreateWorkExperience;
import com.example.CV_Website.models.entities.WorkExperienceEntity;

public interface WorkExperienceMapper {

    WorkExperienceEntity toEntity (CreateWorkExperience req);


}
