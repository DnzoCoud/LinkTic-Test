package com.linktic.project.application.mappers;

import com.linktic.project.application.dto.ProductDTO;
import com.linktic.project.domain.models.Product;

public class ProductMapper {
    public static ProductDTO toDto(Product product){
        return new ProductDTO(
            product.getCode(),
            product.getName(),
            product.getFeatures(),
            CompanyMapper.toDto(product.getCompany())
        );
    }
}
