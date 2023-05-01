package com.example.CV_Website.models.repositories;

import com.example.CV_Website.models.entities.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<EducationEntity, String> {
}
