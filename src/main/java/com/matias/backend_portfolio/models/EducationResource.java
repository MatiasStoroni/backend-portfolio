package com.matias.backend_portfolio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "education_resources")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EducationResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @Size(max = 50, message = "Type cannot exceed 50 characters")
    @NotBlank(message = "Resource type is required")
    private String type;

    @Column(nullable = false, length = 500)
    @Size(max = 500, message = "URL cannot exceed 500 characters")
    @NotBlank(message = "Resource URL is required")
    private String url;

    // One-to-One relationship with Education
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "education_id", nullable = false)
    @JsonIgnore
    private Education education;
}
