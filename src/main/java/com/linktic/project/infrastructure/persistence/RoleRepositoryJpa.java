package com.linktic.project.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linktic.project.infrastructure.entities.RoleEntity;

@Repository
public interface RoleRepositoryJpa extends JpaRepository<RoleEntity, Long> {
}
