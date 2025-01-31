package com.linktic.project.application.mappers;

import com.linktic.project.application.dto.CompanyDTO;
import com.linktic.project.domain.models.Company;

public final class CompanyMapper {
    public static CompanyDTO toDto(Company company) {
        return new CompanyDTO(
                company.getNit(),
                company.getSocialReason(),
                company.getDirection(),
                company.getPhone());
    }
}
