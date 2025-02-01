package com.linktic.project.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product {
    private String code;
    private String name;
    private String features;
    private Company company;
}
