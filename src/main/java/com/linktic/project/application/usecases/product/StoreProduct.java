package com.linktic.project.application.usecases.product;

import java.util.Optional;

import com.linktic.project.application.dto.ProductDTO;
import com.linktic.project.application.dto.request.StoreProductDTO;
import com.linktic.project.application.exceptions.DuplicatedResouceException;
import com.linktic.project.application.mappers.ProductMapper;
import com.linktic.project.domain.models.Company;
import com.linktic.project.domain.models.Product;
import com.linktic.project.domain.services.ICompanyService;
import com.linktic.project.domain.services.IProductService;

public class StoreProduct {
    private final IProductService productService;
    private final ICompanyService companyService;

    public StoreProduct(IProductService productService, ICompanyService companyService){
        this.productService = productService;
        this.companyService = companyService;
    }

    public ProductDTO execute(StoreProductDTO storeProductDTO){
        Optional<Company> company = companyService.find(storeProductDTO.getCompanyNit());
        if(!company.isPresent()){
            throw new DuplicatedResouceException("Esta empresa ya existe");
        }

        Product productToSave = new Product(
            storeProductDTO.getCode(),
            storeProductDTO.getName(),
            storeProductDTO.getFeatures(),
            company.get());

        productToSave = productService.store(productToSave);
        return ProductMapper.toDto(productToSave);
    }
}
