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

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    @NotNull(message = "Name field is missing")
    private String name;

    @Column(nullable = false)
    @Size(min = 10, max = 100)
    @NotNull(message = "Degree field is missing")
    private String degree;

    @Column(nullable = false, columnDefinition = "TEXT")
    @NotNull(message = "Description field is missing")
    private String description;

}
