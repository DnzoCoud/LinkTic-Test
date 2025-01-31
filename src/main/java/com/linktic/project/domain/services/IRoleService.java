package com.linktic.project.domain.services;

import java.util.List;
import java.util.Optional;

import com.linktic.project.domain.models.Role;

public interface IRoleService {
    Optional<Role> find(Long id);

    List<Role> findAll();
}
