package com.linktic.project.infrastructure.mappers;

import com.linktic.project.domain.models.User;
import com.linktic.project.infrastructure.entities.UserEntity;

public final class UserEntityMapper {
    public static User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getSalt(),
                RoleEntityMapper.toDomain(userEntity.getRole()));
    }

    public static UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setSalt(user.getSalt());
        userEntity.setRole(RoleEntityMapper.toEntity(user.getRole()));
        return userEntity;
    }
}
