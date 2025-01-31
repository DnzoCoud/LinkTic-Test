package com.linktic.project.application.usecases.user;

import java.util.List;
import java.util.stream.Collectors;

import com.linktic.project.application.dto.UserDTO;
import com.linktic.project.application.mappers.UserMapper;
import com.linktic.project.domain.services.IUserService;

public class FindAllUsers {

    private final IUserService userService;

    public FindAllUsers(IUserService userService) {
        this.userService = userService;
    }

    public List<UserDTO> execute() {
        return this.userService.findAll().stream().map(UserMapper::toDto).collect(Collectors.toList());
    }
}
