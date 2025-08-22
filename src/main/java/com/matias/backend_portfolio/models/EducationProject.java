package com.matias.backend_portfolio.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "education_projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project title is required")
    @Size(max = 200, message = "Title cannot exceed 200 characters")
    @Column(nullable = false, length = 200)
    private String title;

    @Size(max = 2000, message = "Summary cannot exceed 2000 characters")
    @Column(length = 2000)
    private String summary;

    // Store tech stack as comma-separated string
    @Size(max = 500, message = "Tech stack cannot exceed 500 characters")
    @Column(name = "tech_stack", length = 500)
    private String techStack; // e.g., "Java,Next.js,MySQL,Docker,Auth0,Python,AI"

    // One-to-One relationship with Education
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "education_id", nullable = false)
    private Education education;

    // Helper methods for tech stack
    public List<String> getTechList() {
        if (techStack == null || techStack.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return Arrays.asList(techStack.split(","));
    }

    public void setTechList(List<String> techList) {
        if (techList == null || techList.isEmpty()) {
            this.techStack = null;
        } else {
            this.techStack = String.join(",", techList);
        }
    }
}