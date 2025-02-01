package com.linktic.project.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linktic.project.application.dto.ProductDTO;
import com.linktic.project.application.dto.request.StoreProductDTO;
import com.linktic.project.application.dto.response.ApiResponse;
import com.linktic.project.application.usecases.product.FindAllProductsByCompany;
import com.linktic.project.application.usecases.product.StoreProduct;
import com.linktic.project.infrastructure.abstracts.BaseController;

@RestController
@RequestMapping("api/v1/products")
public class ProductController extends BaseController {
    private final StoreProduct storeProduct;
    private final FindAllProductsByCompany findAllProductsByCompany;

    @Autowired
    public ProductController(StoreProduct storeProduct, FindAllProductsByCompany findAllProductsByCompany){
        this.storeProduct = storeProduct;
        this.findAllProductsByCompany = findAllProductsByCompany;
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getProductsByCompany(@PathVariable String companyNit) {
        try {
            List<ProductDTO> products = findAllProductsByCompany.execute(companyNit);
            return responseSuccess(products);
        } catch (Exception e) {
            return responseError(String.format("Error: %s", e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDTO>> store(@RequestBody StoreProductDTO storeProductDTO) {
        try {
            return responseSuccess(storeProduct.execute(storeProductDTO));
        } catch (Exception e) {
            return responseError(String.format("%s.", e.getMessage()));
        }
    }
}
