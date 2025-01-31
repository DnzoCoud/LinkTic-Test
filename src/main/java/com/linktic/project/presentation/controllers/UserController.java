package com.linktic.project.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linktic.project.application.dto.UserDTO;
import com.linktic.project.application.dto.request.StoreUserRequestDTO;
import com.linktic.project.application.dto.response.ApiResponse;
import com.linktic.project.application.usecases.user.FindAllUsers;
import com.linktic.project.application.usecases.user.StoreUser;
import com.linktic.project.infrastructure.abstracts.BaseController;

@RestController
@RequestMapping("api/v1/users")
public class UserController extends BaseController {

    private final StoreUser storeUser;
    private final FindAllUsers findAllUsers;

    @Autowired
    public UserController(StoreUser storeUser, FindAllUsers findAllUsers) {
        this.storeUser = storeUser;
        this.findAllUsers = findAllUsers;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDTO>>> findAll() {
        try {
            return responseSuccess(findAllUsers.execute());
        } catch (Exception e) {
            return responseError(String.format("%s.", e.getMessage()));
        }
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
