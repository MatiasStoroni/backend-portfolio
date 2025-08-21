package com.matias.backend_portfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matias.backend_portfolio.dtos.request.UserRequestDTO;
import com.matias.backend_portfolio.models.User;
import com.matias.backend_portfolio.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
         // Validation: check if name is null or empty
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        
        // Validation: check if degree is null or empty
        if (user.getDegree() == null || user.getDegree().trim().isEmpty()) {
            throw new IllegalArgumentException("Degree cannot be empty");
        }
        
        // Clean up the data
        user.setName(user.getName().trim());
        user.setDegree(user.getDegree().trim());
        
        return userRepository.save(user);
    }
}
