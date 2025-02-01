package com.linktic.project.application.usecases.product;

import java.util.List;
import java.util.stream.Collectors;

import com.linktic.project.application.dto.ProductDTO;
import com.linktic.project.application.mappers.ProductMapper;
import com.linktic.project.domain.services.IProductService;

public class FindAllProductsByCompany {
    private final IProductService productService;

    public FindAllProductsByCompany(IProductService productService){
        this.productService =productService;
    }

    public List<ProductDTO> execute(String nit){
        return productService.findAllByCompany(nit).stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }

}
