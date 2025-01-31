package com.linktic.project.application.dto.response.auth;

import com.linktic.project.application.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private String token;
    private UserDTO user;
}
