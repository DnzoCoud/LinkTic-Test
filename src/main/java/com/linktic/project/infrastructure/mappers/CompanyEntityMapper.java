package com.linktic.project.infrastructure.mappers;

import com.linktic.project.domain.models.Company;
import com.linktic.project.infrastructure.entities.CompanyEntity;

public final class CompanyEntityMapper {
    public static Company toDomain(CompanyEntity companyEntity) {
        return new Company(
                companyEntity.getNit(),
                companyEntity.getSocialReason(),
                companyEntity.getDirection(),
                companyEntity.getPhone());
    }

    public static CompanyEntity toEntity(Company company) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setNit(company.getNit());
        companyEntity.setSocialReason(company.getSocialReason());
        companyEntity.setDirection(company.getDirection());
        companyEntity.setPhone(company.getPhone());
        return companyEntity;
    }
}
