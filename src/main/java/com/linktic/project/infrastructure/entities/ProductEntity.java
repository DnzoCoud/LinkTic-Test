package com.linktic.project.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products", uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class ProductEntity {
    @Id
    private String code;
    private String name;
    private String features;
    @ManyToOne
    @JoinColumn(name = "company_nit")
    private CompanyEntity company;
}
