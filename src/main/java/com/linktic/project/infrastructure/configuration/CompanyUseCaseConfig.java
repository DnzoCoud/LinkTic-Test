package com.linktic.project.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.linktic.project.application.usecases.company.FindAllCompanies;
import com.linktic.project.application.usecases.company.StoreCompany;
import com.linktic.project.domain.services.ICompanyService;

@Configuration
public class CompanyUseCaseConfig {
    private final ICompanyService companyService;

    @Autowired
    public CompanyUseCaseConfig(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @Bean
    public StoreCompany storeCompany() {
        return new StoreCompany(companyService);
    }

    @Bean
    public FindAllCompanies findAllCompanies() {
        return new FindAllCompanies(companyService);
    }
}
