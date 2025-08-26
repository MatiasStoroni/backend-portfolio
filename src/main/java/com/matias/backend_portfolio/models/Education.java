package com.matias.backend_portfolio.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "educations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 10, max = 100)
    @NotNull(message = "Title field is missing")
    private String title;

    @Min(value = 2015, message = "YearCompleted must be after 2015")
    @Max(value = 2030, message = "YearCompleted must be before 2030")
    private int yearCompleted;

    @Column(length = 5000, nullable = false)
    @Size(min = 5, max = 5000, message = "Description should be beween 5 and 5000 characters")
    @NotNull(message = "Description field is missing")
    private String description;

    @OneToOne(mappedBy = "education", cascade = CascadeType.ALL, orphanRemoval = true)
    private EducationResource resource;

    @OneToOne(mappedBy = "education", cascade = CascadeType.ALL, orphanRemoval = true)
    private EducationProject project;

}
