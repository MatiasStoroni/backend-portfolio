package com.matias.backend_portfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matias.backend_portfolio.models.Education;
import com.matias.backend_portfolio.repositories.EducationRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public List<Education> getAll() {
        return educationRepository.findAll();
    }

    public Education getById(Long id) {
        return educationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Education not found"));
    }

    public Education create(Education education) {
        return educationRepository.save(education);
    }

    public Education update(Long id, Education educationUpdates) {
        Education existingEducation = educationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Education not found"));

        // Only update fields that are provided (non-null)
        if (educationUpdates.getTitle() != null) {
            existingEducation.setTitle(educationUpdates.getTitle());
        }
        if (educationUpdates.getDescription() != null) {
            existingEducation.setDescription(educationUpdates.getDescription());
        }

        return educationRepository.save(existingEducation);
    }

    public void delete(Long id) {
        if (!educationRepository.existsById(id)) {
            throw new EntityNotFoundException("Education not found");
        }
        educationRepository.deleteById(id);
    }
}
