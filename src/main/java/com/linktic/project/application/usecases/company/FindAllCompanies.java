package com.linktic.project.application.usecases.company;

import java.util.List;
import java.util.stream.Collectors;

import com.linktic.project.application.dto.CompanyDTO;
import com.linktic.project.application.mappers.CompanyMapper;
import com.linktic.project.domain.services.ICompanyService;

public class FindAllCompanies {

    private final ICompanyService companyService;

    public FindAllCompanies(ICompanyService companyService) {
        this.companyService = companyService;
    }

    public List<CompanyDTO> execute() {
        return companyService.findAll().stream().map(CompanyMapper::toDto).collect(Collectors.toList());
    }
}
