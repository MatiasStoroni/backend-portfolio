package com.matias.backend_portfolio.mappers;

import com.matias.backend_portfolio.dtos.request.UserRequestDTO;
import com.matias.backend_portfolio.dtos.response.UserResponseDTO;
import com.matias.backend_portfolio.models.User;
import com.matias.backend_portfolio.utils.DataCleaningUtils;

public class UserMapper {
    
    public static User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setName(DataCleaningUtils.trimToNullOrThrow(dto.getName(), "Name"));
        return user;
    }
   
    public static UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getName()
        );
    }
   
    public static void updateEntityFromDTO(User user, UserRequestDTO dto) {
        user.setName(DataCleaningUtils.trimToNullOrThrow(dto.getName(), "Name"));
    }
}