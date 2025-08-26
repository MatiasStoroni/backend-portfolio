package com.matias.backend_portfolio.dtos;

import java.util.List;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducationProjectUpdateDTO {

    @Size(max = 200, message = "Title cannot exceed 200 characters")
    private String title;

    @Size(min = 5, max = 1000, message = "Summary should be beween 5 and 1000 characters")
    private String summary;

    @Size(max = 10, message = "TechStack cannot have more than 10 items")
    private List<String> techStack;

}
