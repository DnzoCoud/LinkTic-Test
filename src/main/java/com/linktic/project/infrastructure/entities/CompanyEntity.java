package com.linktic.project.infrastructure.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "companies", uniqueConstraints = @UniqueConstraint(columnNames = { "nit" }))
public class CompanyEntity extends AuditableEntity {
    @Id
    private String nit;
    private String socialReason;
    private String direction;
    private String phone;

    @OneToMany(mappedBy = "company")
    private List<ProductEntity> products = new ArrayList<>();

}
