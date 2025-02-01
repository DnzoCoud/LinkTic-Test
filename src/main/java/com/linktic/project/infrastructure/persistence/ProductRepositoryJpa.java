package com.linktic.project.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linktic.project.infrastructure.entities.ProductEntity;

public interface ProductRepositoryJpa extends JpaRepository<ProductEntity , String>{
    boolean existsByCode(String code);
    List<ProductEntity> findAllByCompany_Nit(String nit);
}
