package com.linktic.project.application.mappers;

import com.linktic.project.application.dto.UserDTO;
import com.linktic.project.domain.models.User;

public final class UserMapper {
    public static UserDTO toDto(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                RoleMapper.tDto(user.getRole()));
    }
}
