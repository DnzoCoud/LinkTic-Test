package com.linktic.project.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreProductDTO {
    private String code;
    private String name;
    private String features;
    private String companyNit;
}
