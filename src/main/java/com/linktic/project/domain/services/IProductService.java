package com.linktic.project.domain.services;

import java.util.List;
import java.util.Optional;

import com.linktic.project.domain.models.Product;

public interface IProductService {
    Optional<Product> find(String nit);

    List<Product> findAll();

    List<Product> findAllByCompany(String nit);


    Product store(Product company);

    boolean existsByCode(String code);
}
