package com.linktic.project.infrastructure.mappers;

import com.linktic.project.domain.models.Product;
import com.linktic.project.infrastructure.entities.ProductEntity;

public final class ProductEntityMapper {
    public static Product toDomain(ProductEntity productEntity) {
        return new Product(
                productEntity.getCode(),
                productEntity.getName(),
                productEntity.getFeatures(),
                CompanyEntityMapper.toDomain(productEntity.getCompany()));
    }

    public static ProductEntity toEntity(Product product){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCode(product.getCode());
        productEntity.setName(product.getName());
        productEntity.setFeatures(product.getFeatures());
        productEntity.setCompany(CompanyEntityMapper.toEntity(product.getCompany()));
        return productEntity;
    }
}
