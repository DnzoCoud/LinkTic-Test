package com.linktic.project.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.linktic.project.domain.services.ITokenService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final ITokenService tokenService;
    public SecurityConfig(ITokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter(tokenService);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,  AuthFilter authFilter) throws Exception {
        http.authorizeHttpRequests(
                (authz) -> authz.requestMatchers("/api/v1/auth/login", "/api/v1/users")
                        .permitAll().anyRequest().authenticated())
                .csrf(csrf -> csrf.disable()).addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
