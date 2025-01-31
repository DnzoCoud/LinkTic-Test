package com.linktic.project.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linktic.project.infrastructure.entities.UserEntity;

public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long> {
}
