package com.matias.backend_portfolio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matias.backend_portfolio.dtos.request.UserRequestDTO;
import com.matias.backend_portfolio.dtos.response.UserResponseDTO;
import com.matias.backend_portfolio.mappers.UserMapper;
import com.matias.backend_portfolio.models.User;
import com.matias.backend_portfolio.services.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {

        List<User> users = userService.getAll();

        List<UserResponseDTO> userDTOs = users.stream()
                .map(UserMapper::toResponseDTO)
                .toList();

        return ResponseEntity.ok(userDTOs);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) {
        try {
            User user = userService.getById(id);
            UserResponseDTO responseDTO = UserMapper.toResponseDTO(user);
            return ResponseEntity.ok(responseDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequestDTO dto) {
        User user = userService.create(dto);
        return ResponseEntity.ok(UserMapper.toResponseDTO(user));
    }
}
