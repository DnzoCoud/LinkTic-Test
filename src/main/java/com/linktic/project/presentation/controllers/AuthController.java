package com.linktic.project.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linktic.project.application.dto.request.auth.LoginRequest;
import com.linktic.project.application.dto.response.ApiResponse;
import com.linktic.project.application.dto.response.auth.AuthResponse;
import com.linktic.project.application.usecases.auth.LoginUseCase;
import com.linktic.project.infrastructure.abstracts.BaseController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController extends BaseController {
    private final LoginUseCase loginUseCase;

    @Autowired
    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody LoginRequest loginRequest) {
        try {
            AuthResponse auth = loginUseCase.execute(loginRequest);
            return responseSuccess(auth);
        } catch (Exception e) {
            return responseError(e.getMessage());
        }
    }
}
