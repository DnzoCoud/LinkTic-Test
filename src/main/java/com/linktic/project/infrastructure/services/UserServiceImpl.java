package com.linktic.project.infrastructure.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.project.domain.models.User;
import com.linktic.project.domain.services.IUserService;
import com.linktic.project.infrastructure.entities.UserEntity;
import com.linktic.project.infrastructure.mappers.UserEntityMapper;
import com.linktic.project.infrastructure.persistence.UserRepositoryJpa;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    private final UserRepositoryJpa userRepositoryJpa;

    @Autowired
    public UserServiceImpl(UserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    @Override
    public Optional<User> find(Long id) {
        Optional<UserEntity> userEntity = userRepositoryJpa.findById(id);
        return userEntity.map(UserEntityMapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = userRepositoryJpa.findAll();
        return userEntities.stream().map(UserEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public User store(User usuario) {
        UserEntity newUser = userRepositoryJpa.save(UserEntityMapper.toEntity(usuario));
        return UserEntityMapper.toDomain(newUser);
    }
}
