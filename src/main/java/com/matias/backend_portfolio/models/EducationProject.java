package com.matias.backend_portfolio.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matias.backend_portfolio.utils.ListToJsonConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @Column(nullable = false, length = 100)
    @Size(max = 200, message = "Title cannot exceed 200 characters")
    @NotBlank(message = "Project title is required")
    private String title;

    @Column(length = 1000, nullable = false)
    @Size(min = 5, max = 1000, message = "Summary should be beween 5 and 1000 characters")
    @NotNull(message = "Summary field is missing")
    private String summary;

    @Column(length = 1000, name = "tech_stack")
    @Size(max = 10, message = "TechStack cannot have more than 10 items")
    @NotNull(message = "TechStack field is missing")
    @Convert(converter = ListToJsonConverter.class)
    private List<String> techStack;

    // One-to-One relationship with Education
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "education_id", nullable = false)
    @JsonIgnore
    private Education education;

}