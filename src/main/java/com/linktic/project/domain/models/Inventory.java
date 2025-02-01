package com.linktic.project.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Inventory {
    private int id;
    private Product product;
    private int available_quantity;
    private String ubication;
}
