package com.matias.backend_portfolio.mappers;

import org.springframework.stereotype.Component;

import com.matias.backend_portfolio.dtos.EducationProjectUpdateDTO;
import com.matias.backend_portfolio.dtos.EducationResourceUpdateDTO;
import com.matias.backend_portfolio.models.Education;
import com.matias.backend_portfolio.models.EducationProject;
import com.matias.backend_portfolio.models.EducationResource;

@Component
public class EducationMapper {
    // This mapper is required to correctly handle relationships when using DTOs

    public EducationResource createResourceFromDto(EducationResourceUpdateDTO dto, Education education) {
        EducationResource resource = new EducationResource();
        updateResourceFields(resource, dto);
        resource.setEducation(education);
        return resource;
    }

    public EducationProject createProjectFromDto(EducationProjectUpdateDTO dto, Education education) {
        EducationProject project = new EducationProject();
        updateProjectFields(project, dto);
        project.setEducation(education);
        return project;
    }

    // Pure field mapping - no business logic
    public void updateResourceFields(EducationResource resource, EducationResourceUpdateDTO dto) {
        if (dto.getType() != null) {
            resource.setType(dto.getType());
        }
        if (dto.getUrl() != null) {
            resource.setUrl(dto.getUrl());
        }
    }

    public void updateProjectFields(EducationProject project, EducationProjectUpdateDTO dto) {
        if (dto.getTitle() != null) {
            project.setTitle(dto.getTitle());
        }
        if (dto.getSummary() != null) {
            project.setSummary(dto.getSummary());
        }
        if (dto.getTechStack() != null) {
            project.setTechStack(dto.getTechStack());
        }
    }
}