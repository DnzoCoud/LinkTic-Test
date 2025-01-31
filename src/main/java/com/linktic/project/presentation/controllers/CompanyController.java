package com.linktic.project.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linktic.project.application.dto.CompanyDTO;
import com.linktic.project.application.dto.request.StoreCompanyDTO;
import com.linktic.project.application.dto.response.ApiResponse;
import com.linktic.project.application.usecases.company.FindAllCompanies;
import com.linktic.project.application.usecases.company.StoreCompany;
import com.linktic.project.infrastructure.abstracts.BaseController;

@RestController
@RequestMapping("api/v1/companies")
public class CompanyController extends BaseController {
    private final StoreCompany storeCompany;
    private final FindAllCompanies findAllCompanies;

    @Autowired
    public CompanyController(StoreCompany storeCompany, FindAllCompanies findAllCompanies) {
        this.storeCompany = storeCompany;
        this.findAllCompanies = findAllCompanies;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CompanyDTO>>> findAll() {
        try {
            return responseSuccess(findAllCompanies.execute());
        } catch (Exception e) {
            return responseError(String.format("%s.", e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CompanyDTO>> store(@RequestBody StoreCompanyDTO storeCompanyDTO) {
        try {
            return responseSuccess(storeCompany.execute(storeCompanyDTO));
        } catch (Exception e) {
            return responseError(String.format("%s.", e.getMessage()));
        }
    }
}
