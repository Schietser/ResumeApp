package com.example.CV_Website.services.flow;

import com.example.CV_Website.models.dto.CreateWorkExperience;
import com.example.CV_Website.models.entities.WorkExperienceEntity;
import com.example.CV_Website.models.repositories.WorkExperienceRepository;
import com.example.CV_Website.services.mappers.WorkExperienceMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkExperienceService {

    private final WorkExperienceRepository workExperienceRepository;
    private final WorkExperienceMapperImpl workExperienceMapper;

    public void createWorkExperience (CreateWorkExperience req){

        workExperienceRepository.save(workExperienceMapper.toEntity(req));

    }

    public List<WorkExperienceEntity> showAllWorkexperience(){
        return workExperienceRepository.findAll();
    }

    public WorkExperienceEntity findJobById(String id){

        WorkExperienceEntity jobEntity = workExperienceRepository.findById(id).get();

        return jobEntity;

    }


}
