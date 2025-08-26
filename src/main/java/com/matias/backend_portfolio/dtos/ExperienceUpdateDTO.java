package com.matias.backend_portfolio.dtos;

import java.util.List;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExperienceUpdateDTO {

    @Size(min = 2, max = 100)
    private String title;

    @Size(min = 2, max = 100)
    private String company;

    @Size(min = 2, max = 50)
    private String period;

    @Size(max = 6, message = "Responsibilities cannot have more than 6 items")
    private List<String> responsibilities;

    @Size(max = 10, message = "Tools cannot have more than 10 items")
    private List<String> tools;
}