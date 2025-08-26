package com.matias.backend_portfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matias.backend_portfolio.dtos.EducationProjectUpdateDTO;
import com.matias.backend_portfolio.dtos.EducationResourceUpdateDTO;
import com.matias.backend_portfolio.dtos.EducationUpdateDTO;
import com.matias.backend_portfolio.mappers.EducationMapper;
import com.matias.backend_portfolio.models.Education;
import com.matias.backend_portfolio.repositories.EducationRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private EducationMapper educationMapper;

    public List<Education> getAll() {
        return educationRepository.findAll();
    }

    public Education getById(Long id) {
        return educationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Education not found"));
    }

    public Education create(Education education) {
        // Set bidirectional relationships
        if (education.getResource() != null) {
            education.getResource().setEducation(education);
        }
        if (education.getProject() != null) {
            education.getProject().setEducation(education);
        }
        return educationRepository.save(education);
    }

    public Education update(Long id, EducationUpdateDTO educationUpdates) {
        Education existingEducation = educationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Education not found with id: " + id));

        updateEducationFields(existingEducation, educationUpdates);
        updateEducationResource(existingEducation, educationUpdates.getResource());
        updateEducationProject(existingEducation, educationUpdates.getProject());

        Education savedEducation = educationRepository.save(existingEducation);

        return savedEducation;
    }

    private void updateEducationFields(Education education, EducationUpdateDTO dto) {
        if (dto.getTitle() != null) {
            education.setTitle(dto.getTitle());
        }
        if (dto.getYearCompleted() != null && dto.getYearCompleted() != 0) {
            education.setYearCompleted(dto.getYearCompleted());
        }
        if (dto.getDescription() != null) {
            education.setDescription(dto.getDescription());
        }
    }

    private void updateEducationResource(Education education, EducationResourceUpdateDTO resourceDto) {
        if (resourceDto != null) {
            if (education.getResource() == null) {
                // Business logic: create new resource when needed
                education.setResource(educationMapper.createResourceFromDto(resourceDto, education));
            } else {
                // Business logic: update existing resource
                educationMapper.updateResourceFields(education.getResource(), resourceDto);
            }
        }
    }

    private void updateEducationProject(Education education, EducationProjectUpdateDTO projectDto) {
        if (projectDto != null) {
            if (education.getProject() == null) {
                // Business logic: create new project when needed
                education.setProject(educationMapper.createProjectFromDto(projectDto, education));
            } else {
                // Business logic: update existing project
                educationMapper.updateProjectFields(education.getProject(), projectDto);
            }
        }
    }

    public void delete(Long id) {
        if (!educationRepository.existsById(id)) {
            throw new EntityNotFoundException("Education not found");
        }
        educationRepository.deleteById(id);
    }
}
