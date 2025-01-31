package com.linktic.project.infrastructure.mappers;

import com.linktic.project.domain.models.Role;
import com.linktic.project.infrastructure.entities.RoleEntity;

public final class RoleEntityMapper {
    public static Role toDomain(RoleEntity roleEntity) {
        return new Role(roleEntity.getId(),
                roleEntity.getName());
    }

    public static RoleEntity toEntity(Role role) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(role.getId());
        roleEntity.setName(role.getName());
        return roleEntity;
    }
}
