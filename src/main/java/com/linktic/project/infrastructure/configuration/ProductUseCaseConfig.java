package com.linktic.project.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.linktic.project.application.usecases.product.FindAllProductsByCompany;
import com.linktic.project.application.usecases.product.StoreProduct;
import com.linktic.project.domain.services.ICompanyService;
import com.linktic.project.domain.services.IProductService;

@Configuration
public class ProductUseCaseConfig {
    private final IProductService productService;
    private final ICompanyService companyService;

    @Autowired
    public ProductUseCaseConfig(IProductService productService, ICompanyService companyService){
        this.productService=productService;
        this.companyService=companyService;
    }

    @Bean
    public FindAllProductsByCompany findAllProductsByCompany(){
        return new FindAllProductsByCompany(productService);
    }

    @Bean
    public StoreProduct storeProduct(){
        return new StoreProduct(productService, companyService);
    }
    
}