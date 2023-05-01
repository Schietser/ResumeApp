package com.example.CV_Website.models.repositories;

import com.example.CV_Website.models.entities.WorkExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceRepository extends JpaRepository <WorkExperienceEntity, String> {

}
