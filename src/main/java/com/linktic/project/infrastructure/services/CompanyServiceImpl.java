package com.linktic.project.infrastructure.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.project.domain.models.Company;
import com.linktic.project.domain.services.ICompanyService;
import com.linktic.project.infrastructure.entities.CompanyEntity;
import com.linktic.project.infrastructure.mappers.CompanyEntityMapper;
import com.linktic.project.infrastructure.persistence.CompanyRepositoryJpa;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CompanyServiceImpl implements ICompanyService {
    private final CompanyRepositoryJpa companyRepositoryJpa;

    @Autowired
    public CompanyServiceImpl(CompanyRepositoryJpa companyRepositoryJpa) {
        this.companyRepositoryJpa = companyRepositoryJpa;
    }

    @Override
    public Optional<Company> find(String nit) {
        Optional<CompanyEntity> userEntity = companyRepositoryJpa.findById(nit);
        return userEntity.map(CompanyEntityMapper::toDomain);
    }

    @Override
    public List<Company> findAll() {
        List<CompanyEntity> userEntities = companyRepositoryJpa.findAll();
        return userEntities.stream().map(CompanyEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Company store(Company company) {
        CompanyEntity newCompany = companyRepositoryJpa.save(CompanyEntityMapper.toEntity(company));
        return CompanyEntityMapper.toDomain(newCompany);
    }

}
