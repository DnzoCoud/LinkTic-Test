package com.linktic.project.application.mappers;

import com.linktic.project.application.dto.RoleDTO;
import com.linktic.project.domain.models.Role;

public final class RoleMapper {
    public static RoleDTO tDto(Role role) {
        return new RoleDTO(
                role.getId(),
                role.getName());
    }
}
