package com.linktic.project.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Currency {
    private int id;
    private String code, name;
}
