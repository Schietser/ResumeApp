package com.example.CV_Website.services.flow;

import com.example.CV_Website.models.dto.CreateEducationExperience;
import com.example.CV_Website.models.dto.CreateWorkExperience;
import com.example.CV_Website.models.entities.EducationEntity;
import com.example.CV_Website.models.entities.WorkExperienceEntity;
import com.example.CV_Website.models.repositories.EducationRepository;
import com.example.CV_Website.models.repositories.WorkExperienceRepository;
import com.example.CV_Website.services.mappers.EducationMapperImpl;
import com.example.CV_Website.services.mappers.WorkExperienceMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationRepository educationRepository;
    private final EducationMapperImpl educationMapper;

    public void createWorkExperience (CreateEducationExperience req){

        educationRepository.save(educationMapper.toEntity(req));

    }

    public List<EducationEntity> showAllEducation(){
        return educationRepository.findAll();
    }

    public EducationEntity findEducationById(String id){

        EducationEntity educationEntity = educationRepository.findById(id).get();

        return educationEntity;

    }


}
