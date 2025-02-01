package com.linktic.project.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linktic.project.infrastructure.entities.CompanyEntity;

public interface CompanyRepositoryJpa extends JpaRepository<CompanyEntity, String> {
    boolean existsByNit(String nit);
}
