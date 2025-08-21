package com.matias.backend_portfolio.mappers;

import com.matias.backend_portfolio.dtos.request.UserRequestDTO;
import com.matias.backend_portfolio.dtos.response.UserResponseDTO;
import com.matias.backend_portfolio.models.User;

public class UserMapper {
    // Convert RequestDTO to Entity
    public static User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setDegree(dto.getDegree());
        return user;
    }
    
    // Convert Entity to ResponseDTO
    public static UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getName(),
            user.getDegree(),
            user.getCreatedAt(),
            user.getUpdatedAt()
        );
    }
    
    // Update Entity from RequestDTO (for PUT operations)
    public static void updateEntityFromDTO(User user, UserRequestDTO dto) {
        user.setName(dto.getName());
        user.setDegree(dto.getDegree());
    }
}
