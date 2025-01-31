package com.linktic.project.infrastructure.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.project.domain.models.Role;
import com.linktic.project.domain.services.IRoleService;
import com.linktic.project.infrastructure.entities.RoleEntity;
import com.linktic.project.infrastructure.mappers.RoleEntityMapper;
import com.linktic.project.infrastructure.persistence.RoleRepositoryJpa;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    private final RoleRepositoryJpa roleRepositoryJpa;

    @Autowired
    public RoleServiceImpl(RoleRepositoryJpa roleRepositoryJpa) {
        this.roleRepositoryJpa = roleRepositoryJpa;
    }

    @Override
    public Optional<Role> find(Long id) {
        Optional<RoleEntity> roleEntity = roleRepositoryJpa.findById(id);
        return roleEntity.map(RoleEntityMapper::toDomain);
    }

    @Override
    public List<Role> findAll() {
        List<RoleEntity> entities = roleRepositoryJpa.findAll();
        return entities.stream().map(RoleEntityMapper::toDomain).collect(Collectors.toList());
    }
}
