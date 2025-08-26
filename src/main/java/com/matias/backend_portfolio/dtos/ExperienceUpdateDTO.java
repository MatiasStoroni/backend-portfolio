package com.matias.backend_portfolio.dtos;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExperienceUpdateDTO {

    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;

    @Size(min = 5, max = 100, message = "Degree should be beween 5 and 100 characters")
    private String degree;

    @Size(min = 5, max = 5000, message = "Description should be beween 5 and 5000 characters")
    private String description;
}