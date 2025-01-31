package com.linktic.project.application.usecases.user;

import com.linktic.project.application.dto.UserDTO;
import com.linktic.project.application.dto.request.StoreUserRequestDTO;
import com.linktic.project.application.exceptions.FailOperationException;
import com.linktic.project.domain.services.IUserService;

public class StoreUser {
    private final IUserService userService;

    public StoreUser(IUserService userService) {
        this.userService = userService;
    }

}
