package com.linktic.project.domain.services;

import java.util.List;
import java.util.Optional;

import com.linktic.project.domain.models.Company;

public interface ICompanyService {
    Optional<Company> find(String nit);

    List<Company> findAll();

    Company store(Company company);

    boolean existsByNit(String nit);
}
