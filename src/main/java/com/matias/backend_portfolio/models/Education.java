package com.matias.backend_portfolio.models;

import java.util.Map;

import jakarta.persistence.Column;
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
    @NotNull(message = "Description field is missing")
    private String title;

    @Column(nullable = false)
    @NotNull(message = "Description field is missing")
    private int year;

    @Column(nullable = false)
    @Size(min = 10, max = 1000)
    @NotNull(message = "Description field is missing")
    private String description;

}
