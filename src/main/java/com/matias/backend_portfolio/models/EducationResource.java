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

    @NotBlank(message = "Resource type is required")
    @Size(max = 50, message = "Type cannot exceed 50 characters")
    @Column(nullable = false, length = 50)
    private String type;

    @NotBlank(message = "Resource label is required")
    @Size(max = 200, message = "Label cannot exceed 200 characters")
    @Column(nullable = false, length = 200)
    private String label;

    @NotBlank(message = "Resource URL is required")
    @Size(max = 500, message = "URL cannot exceed 500 characters")
    @Column(nullable = false, length = 500)
    private String url;

    // One-to-One relationship with Education
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "education_id", nullable = false)
    @JsonIgnore
    private Education education;
}
