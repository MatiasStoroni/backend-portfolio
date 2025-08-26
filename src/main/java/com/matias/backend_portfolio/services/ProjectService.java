package com.matias.backend_portfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matias.backend_portfolio.dtos.ProjectUpdateDTO;
import com.matias.backend_portfolio.models.Project;
import com.matias.backend_portfolio.repositories.ProjectRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Project getById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));
    }

    public Project create(Project project) {
        return projectRepository.save(project);
    }

    public Project update(Long id, ProjectUpdateDTO projectUpdates) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));

        // Update project fields
        if (projectUpdates.getTitle() != null) {
            existingProject.setTitle(projectUpdates.getTitle());
        }
        if (projectUpdates.getTechStack() != null) {
            existingProject.setTechStack(projectUpdates.getTechStack());
        }
        if (projectUpdates.getImageUrl() != null) {
            existingProject.setImageUrl(projectUpdates.getImageUrl());
        }
        if (projectUpdates.getRepositoryUrl() != null) {
            existingProject.setRepositoryUrl(projectUpdates.getRepositoryUrl());
        }
        if (projectUpdates.getLiveDemoUrl() != null) {
            existingProject.setLiveDemoUrl(projectUpdates.getLiveDemoUrl());
        }

        return projectRepository.save(existingProject);
    }

    public void delete(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new EntityNotFoundException("Project not found");
        }
        projectRepository.deleteById(id);
    }

}
