package com.linktic.project.application.usecases.company;

import com.linktic.project.application.dto.CompanyDTO;
import com.linktic.project.application.dto.request.StoreCompanyDTO;
import com.linktic.project.application.mappers.CompanyMapper;
import com.linktic.project.domain.models.Company;
import com.linktic.project.domain.services.ICompanyService;

public class StoreCompany {
    private final ICompanyService companyService;

    public StoreCompany(ICompanyService companyService) {
        this.companyService = companyService;
    }

    public CompanyDTO execute(StoreCompanyDTO storeCompanyDTO) {
        Company companyToAdd = new Company(
                storeCompanyDTO.getNit(),
                storeCompanyDTO.getSocialReason(),
                storeCompanyDTO.getDirection(),
                storeCompanyDTO.getPhone());

        companyToAdd = companyService.store(companyToAdd);
        return CompanyMapper.toDto(companyToAdd);
    }
}
