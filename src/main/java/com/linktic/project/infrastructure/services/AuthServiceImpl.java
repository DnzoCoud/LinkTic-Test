package com.linktic.project.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.project.domain.models.User;
import com.linktic.project.domain.services.IAuthService;
import com.linktic.project.domain.services.IPasswordHashing;
import com.linktic.project.infrastructure.entities.UserEntity;
import com.linktic.project.infrastructure.mappers.UserEntityMapper;
import com.linktic.project.infrastructure.persistence.UserRepositoryJpa;

import jakarta.transaction.Transactional;

@Service
public class AuthServiceImpl implements IAuthService {
    private final UserRepositoryJpa userRepositoryJpa;
    private final IPasswordHashing passwordHashing;

    @Autowired
    public AuthServiceImpl(UserRepositoryJpa userRepository, IPasswordHashing passwordHashing) {
        this.userRepositoryJpa = userRepository;
        this.passwordHashing = passwordHashing;
    }

    @Override
    @Transactional
    public User login(String email, String password) {
        UserEntity user = userRepositoryJpa.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no existe o esta inactivo."));

        if (!passwordHashing.veirfyPassword(password, user.getSalt(), user.getPassword())) {
            throw new RuntimeException("Credenciales invalidas");
        }
        return UserEntityMapper.toDomain(user);
    }
}
