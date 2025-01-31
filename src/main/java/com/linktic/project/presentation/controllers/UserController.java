package com.linktic.project.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linktic.project.application.dto.UserDTO;
import com.linktic.project.application.dto.request.StoreUserRequestDTO;
import com.linktic.project.application.dto.response.ApiResponse;
import com.linktic.project.application.usecases.user.StoreUser;
import com.linktic.project.infrastructure.abstracts.BaseController;

@RestController
@RequestMapping("api/v1/users")
public class UserController extends BaseController {

    private final StoreUser storeUser;

    @Autowired
    public UserController(StoreUser storeUser) {
        this.storeUser = storeUser;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserDTO>> store(@RequestBody StoreUserRequestDTO storeUserRequestDTO) {
        try {
            return responseSuccess(storeUser.execute(storeUserRequestDTO));
        } catch (Exception e) {
            return responseError(String.format("%s.", e.getMessage()));
        }
    }
}
