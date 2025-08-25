package com.matias.backend_portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matias.backend_portfolio.models.Experience;
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long>{
    
}
