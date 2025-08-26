package com.matias.backend_portfolio.models;

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
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    @NotNull(message = "Name field is missing")
    private String name;

    @Column(length = 100, nullable = false)
    @Size(min = 5, max = 100, message = "Degree should be beween 5 and 100 characters")
    @NotNull(message = "Degree field is missing")
    private String degree;

    @Column(length = 5000, nullable = false)
    @Size(min = 5, max = 5000, message = "Description should be beween 5 and 5000 characters")
    @NotNull(message = "Description field is missing")
    private String description;

}
