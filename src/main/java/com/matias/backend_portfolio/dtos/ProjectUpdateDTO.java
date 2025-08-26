package com.matias.backend_portfolio.dtos;

import java.util.List;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectUpdateDTO {

    @Size(min = 2, max = 100, message = "Title should be between 2 and 100 characters")
    private String title;

    @Size(min = 5, max = 5000, message = "Description should be beween 5 and 5000 characters")
    private String description;

    @Size(max = 10, message = "TechStack cannot have more than 10 items")
    private List<String> techStack;

    @Size(max = 300, message = "ImageUrl should not exceed 300 characters")
    private String imageUrl;

    @Size(max = 100, message = "RepositoryUrl should not exceed 100 characters")
    private String repositoryUrl;

    @Size(max = 100, message = "LiveDemoUrl should not exceed 100 characters")
    private String liveDemoUrl;
}