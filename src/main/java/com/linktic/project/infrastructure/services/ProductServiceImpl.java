package com.linktic.project.infrastructure.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.project.domain.models.Product;
import com.linktic.project.domain.services.IProductService;
import com.linktic.project.infrastructure.entities.ProductEntity;
import com.linktic.project.infrastructure.mappers.ProductEntityMapper;
import com.linktic.project.infrastructure.persistence.ProductRepositoryJpa;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    private final ProductRepositoryJpa productRepositoryJpa;

    @Autowired
    public ProductServiceImpl(ProductRepositoryJpa productRepositoryJpa) {
        this.productRepositoryJpa = productRepositoryJpa;
    }

    @Override
    public Optional<Product> find(String code) {
        Optional<ProductEntity> productEntity = productRepositoryJpa.findById(code);
        return productEntity.map(ProductEntityMapper::toDomain);
    }

    @Override
    public List<Product> findAll() {
        List<ProductEntity> productEntities = productRepositoryJpa.findAll();
        return productEntities.stream().map(ProductEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Product store(Product product) {
        ProductEntity newProduct = productRepositoryJpa.save(ProductEntityMapper.toEntity(product));
        return ProductEntityMapper.toDomain(newProduct);
    }

    @Override
    public boolean existsByCode(String code) {
        return productRepositoryJpa.existsByCode(code);
    }

    @Override
    public List<Product> findAllByCompany(String nit) {
        return productRepositoryJpa.findAllByCompany_Nit(nit)
                .stream()
                .map(ProductEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
