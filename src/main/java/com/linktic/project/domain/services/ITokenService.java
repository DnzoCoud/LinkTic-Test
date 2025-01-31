package com.linktic.project.domain.services;

import com.linktic.project.domain.models.User;

public interface ITokenService {
    String generateToken(User user);

    boolean validateToken(String token);

    <T> T validateTokenAndReturnClaims(String token);
}
