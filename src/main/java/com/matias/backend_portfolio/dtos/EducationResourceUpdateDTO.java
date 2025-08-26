package com.matias.backend_portfolio.dtos;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducationResourceUpdateDTO {

    @Size(max = 50, message = "Type cannot exceed 50 characters")
    private String type;

    @Size(max = 500, message = "URL cannot exceed 500 characters")
    private String url;
}
