package com.linktic.project.application.usecases.role;

import com.linktic.project.application.exceptions.ResourceNotFoundException;
import com.linktic.project.domain.models.Role;
import com.linktic.project.domain.services.IRoleService;

public class GetRoleById {

    private final IRoleService roleService;

    public GetRoleById(IRoleService roleService) {
        this.roleService = roleService;
    }

    public Role execute(Long id) {
        return roleService.find(id).orElseThrow(() -> new ResourceNotFoundException("El rol no existe."));
    }
}
