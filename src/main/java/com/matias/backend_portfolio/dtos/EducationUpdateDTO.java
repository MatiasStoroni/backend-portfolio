package com.matias.backend_portfolio.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducationUpdateDTO {

    @Size(min = 10, max = 100)
    private String title;

    @Min(value = 2015, message = "YearCompleted must be after 2015")
    @Max(value = 2030, message = "YearCompleted must be before 2030")
    private Integer yearCompleted; // Integer can be null whereas int defaults to 0

    @Size(min = 5, max = 5000, message = "Description should be beween 5 and 5000 characters")
    private String description;

    @Valid
    private EducationResourceUpdateDTO resource;

    @Valid
    private EducationProjectUpdateDTO project;
}