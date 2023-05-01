package com.example.CV_Website.services.mappers;

import com.example.CV_Website.models.dto.CreateEducationExperience;
import com.example.CV_Website.models.entities.EducationEntity;
import org.springframework.stereotype.Component;

@Component
public class EducationMapperImpl implements EducationMapper{
    @Override
    public EducationEntity toEntity(CreateEducationExperience req) {

        EducationEntity educationEntity = new EducationEntity();
        educationEntity.setSchool(req.getSchool());
        educationEntity.setSubject(req.getSubject());
        educationEntity.setTimePeriod(req.getTimePeriod());

        return educationEntity;
    }
}
