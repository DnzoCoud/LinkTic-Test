package com.linktic.project.application.usecases.auth;

import com.linktic.project.application.dto.request.auth.LoginRequest;
import com.linktic.project.application.dto.response.auth.AuthResponse;
import com.linktic.project.application.exceptions.InvalidCredentialsException;
import com.linktic.project.application.mappers.UserMapper;
import com.linktic.project.domain.models.User;
import com.linktic.project.domain.services.IAuthService;
import com.linktic.project.domain.services.ITokenService;

public class LoginUseCase {
    private final IAuthService authService;
    private final ITokenService tokenService;

    public LoginUseCase(IAuthService authService, ITokenService tokenService) {
        this.authService = authService;
        this.tokenService = tokenService;
    }

    public AuthResponse execute(LoginRequest loginRequest) {
        if (loginRequest.getEmail() == null || loginRequest.getEmail().isEmpty()) {
            throw new InvalidCredentialsException("El email es obligatorio.");
        }
        User user = authService.login(loginRequest.getEmail(), loginRequest.getPassword());
        String token = tokenService.generateToken(user);
        return new AuthResponse(token, UserMapper.toDto(user));
    }
}
