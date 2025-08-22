package com.matias.backend_portfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matias.backend_portfolio.dtos.request.UserRequestDTO;
import com.matias.backend_portfolio.mappers.UserMapper;
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
        return userRepository.getReferenceById(id);
    }

    public User create(UserRequestDTO userDto) {
        User user = UserMapper.toEntity(userDto);
        return userRepository.save(user);
    }

    public User update(Long id, UserRequestDTO userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        UserMapper.updateEntityFromDTO(user, userDto);
        return userRepository.save(user);
    }

}
