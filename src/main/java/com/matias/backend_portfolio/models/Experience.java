package com.matias.backend_portfolio.models;

import java.util.List;

import com.matias.backend_portfolio.utils.ListToJsonConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
@Table(name = "experiences")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 100)
    @NotNull(message = "Title field is missing")
    private String title;

    @Column(nullable = false)
    @Size(min = 2, max = 100)
    @NotNull(message = "Company field is missing")
    private String company;

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    @NotNull(message = "Period field is missing")
    private String period;

    @Column(length = 2000)
    @Size(max = 6, message = "Responsibilities cannot have more than 6 items")
    @Convert(converter = ListToJsonConverter.class)
    private List<String> responsibilities;

    @Column(length = 1000)
    @Size(max = 10, message = "Tools cannot have more than 10 items")
    @Convert(converter = ListToJsonConverter.class)
    private List<String> tools;

}