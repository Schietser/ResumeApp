package com.example.CV_Website.models.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class WorkExperienceEntity {

    @Id
    private String employer;
    private String jobTitle;
    private String timePeriod;
    private String description;

    @Override
    public String toString() {
        return "WorkExperienceEntity{" +
                "employer='" + employer + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", timePeriod='" + timePeriod + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
