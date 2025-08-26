package com.matias.backend_portfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matias.backend_portfolio.dtos.ExperienceUpdateDTO;
import com.matias.backend_portfolio.models.Experience;
import com.matias.backend_portfolio.repositories.ExperienceRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    public List<Experience> getAll() {
        return experienceRepository.findAll();
    }

    public Experience getById(Long id) {
        return experienceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Experience not found"));
    }

    public Experience create(Experience experience) {
        return experienceRepository.save(experience);
    }

    public Experience update(Long id, ExperienceUpdateDTO experienceUpdates) {
        Experience existingExperience = experienceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Experience not found"));

        // Update only fields that are provided
        if (experienceUpdates.getTitle() != null) {
            existingExperience.setTitle(experienceUpdates.getTitle());
        }

        if (experienceUpdates.getCompany() != null) {
            existingExperience.setCompany(experienceUpdates.getCompany());
        }

        if (experienceUpdates.getPeriod() != null) {
            existingExperience.setPeriod(experienceUpdates.getPeriod());
        }

        if (experienceUpdates.getResponsibilities() != null) {
            existingExperience.setResponsibilities(experienceUpdates.getResponsibilities());
        }

        if (experienceUpdates.getTools() != null) {
            existingExperience.setTools(experienceUpdates.getTools());
        }

        return experienceRepository.save(existingExperience);
    }

    public void delete(Long id) {
        if (!experienceRepository.existsById(id)) {
            throw new EntityNotFoundException("Experience not found");
        }
        experienceRepository.deleteById(id);
    }
}
