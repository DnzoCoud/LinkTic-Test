package com.linktic.project.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linktic.project.infrastructure.entities.RoleEntity;

public interface RoleRepositoryJpa extends JpaRepository<RoleEntity, Long> {
}
