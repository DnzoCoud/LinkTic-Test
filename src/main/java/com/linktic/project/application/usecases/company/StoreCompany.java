package com.linktic.project.application.usecases.company;

import com.linktic.project.application.dto.CompanyDTO;
import com.linktic.project.application.dto.request.StoreCompanyDTO;
import com.linktic.project.application.exceptions.DuplicatedResouceException;
import com.linktic.project.application.mappers.CompanyMapper;
import com.linktic.project.domain.models.Company;
import com.linktic.project.domain.services.ICompanyService;

public class StoreCompany {
    private final ICompanyService companyService;

    public StoreCompany(ICompanyService companyService) {
        this.companyService = companyService;
    }

    public CompanyDTO execute(StoreCompanyDTO storeCompanyDTO) {
        if (storeCompanyDTO.getNit() == null || storeCompanyDTO.getNit().length() > 10) {
            throw new IllegalArgumentException("El NIT debe tener un máximo de 10 caracteres.");
        }
        if(companyService.existsByNit(storeCompanyDTO.getNit())){
            throw new DuplicatedResouceException("Esta empresa ya existe");
        }
        Company companyToAdd = new Company(
                storeCompanyDTO.getNit(),
                storeCompanyDTO.getSocialReason(),
                storeCompanyDTO.getDirection(),
                storeCompanyDTO.getPhone());

        companyToAdd = companyService.store(companyToAdd);
        return CompanyMapper.toDto(companyToAdd);
    }
}
