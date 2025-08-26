package com.matias.backend_portfolio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.backend_portfolio.dtos.EducationUpdateDTO;
import com.matias.backend_portfolio.models.Education;
import com.matias.backend_portfolio.services.EducationService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/educations")
public class EducationController {

    @Autowired
    EducationService educationService;

    @GetMapping
    public ResponseEntity<List<Education>> getAllEducations() {
        return ResponseEntity.ok(educationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducation(@PathVariable Long id) {
        return ResponseEntity.ok(educationService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> createEducation(@Valid @RequestBody Education education) {
        Education created = educationService.create(education);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEducation(@PathVariable Long id,
            @Valid @RequestBody EducationUpdateDTO educationDto) {
        return ResponseEntity.ok(educationService.update(id, educationDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable Long id) {
        educationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
