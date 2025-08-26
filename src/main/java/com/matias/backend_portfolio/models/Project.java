package com.matias.backend_portfolio.models;

import java.util.List;

import com.matias.backend_portfolio.utils.ListToJsonConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 100, message = "Title should be between 2 and 100 characters")
    @NotNull(message = "Title field is missing")
    private String title;

    @Column(length = 5000, nullable = false)
    @Size(min = 5, max = 5000, message = "Description should be beween 5 and 5000 characters")
    @NotNull(message = "Description field is missing")
    private String description;

    @Column(length = 1000)
    @Size(max = 10, message = "TechStack cannot have more than 10 items")
    @Convert(converter = ListToJsonConverter.class)
    private List<String> techStack;

    @Column(name = "image_url", nullable = false)
    @Size(max = 300, message = "ImageUrl should not exceed 300 characters")
    @NotNull(message = "ImageUrl field is missing")
    private String imageUrl;

    @Column(name = "repository_url", nullable = true)
    @Size(max = 100, message = "RepositoryUrl should not exceed 100 characters")
    private String repositoryUrl;

    @Column(name = "live_demo_url", nullable = true)
    @Size(max = 100, message = "LiveDemoUrl should not exceed 100 characters")
    private String liveDemoUrl;

}
