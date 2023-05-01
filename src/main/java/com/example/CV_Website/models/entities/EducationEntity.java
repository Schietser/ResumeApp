package com.example.CV_Website.models.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class EducationEntity {

    @Id
    private String school;
    private String timePeriod;
    private String subject;
}
