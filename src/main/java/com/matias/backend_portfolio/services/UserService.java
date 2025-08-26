package com.matias.backend_portfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matias.backend_portfolio.dtos.UserUpdateDTO;
import com.matias.backend_portfolio.models.User;
import com.matias.backend_portfolio.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, UserUpdateDTO userUpdates) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        // Only update fields that are provided (non-null)
        if (userUpdates.getName() != null) {
            existingUser.setName(userUpdates.getName());
        }
        if (userUpdates.getDegree() != null) {
            existingUser.setDegree(userUpdates.getDegree());
        }

        if (userUpdates.getDescription() != null) {
            existingUser.setDescription(userUpdates.getDescription());
        }

        return userRepository.save(existingUser);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }
}
