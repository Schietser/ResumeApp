package com.example.CV_Website.services.mappers;

import com.example.CV_Website.models.dto.CreateWorkExperience;
import com.example.CV_Website.models.entities.WorkExperienceEntity;
import org.springframework.stereotype.Component;

@Component
public class WorkExperienceMapperImpl implements WorkExperienceMapper{


    @Override
    public WorkExperienceEntity toEntity(CreateWorkExperience req) {

        WorkExperienceEntity workEntity = new WorkExperienceEntity();
        workEntity.setEmployer(req.getEmployer());
        workEntity.setDescription(req.getDescription());
        workEntity.setTimePeriod(req.getTimePeriod());
        workEntity.setJobTitle(req.getJobTitle());

        return workEntity;
    }
}
