package com.linktic.project.infrastructure.configuration;

import com.linktic.project.application.usecases.auth.LoginUseCase;
import com.linktic.project.domain.services.IAuthService;
import com.linktic.project.domain.services.ITokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthUseCaseConfig {
    private final IAuthService authService;
    private final ITokenService tokenService;

    @Autowired
    public AuthUseCaseConfig(IAuthService authService, ITokenService tokenService) {
        this.authService = authService;
        this.tokenService = tokenService;
    }

    @Bean
    public LoginUseCase loginUseCase() {
        return new LoginUseCase(authService, tokenService);
    }
}
