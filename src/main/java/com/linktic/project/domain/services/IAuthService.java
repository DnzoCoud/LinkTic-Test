package com.linktic.project.domain.services;

import com.linktic.project.domain.models.User;

public interface IAuthService {
    User login(String email, String password);
}
