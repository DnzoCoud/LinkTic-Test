package com.linktic.project.domain.services;

import java.util.List;
import java.util.Optional;

import com.linktic.project.domain.models.User;

public interface IUserService {
    Optional<User> find(Long id);

    List<User> findAll();

    User store(User user);
}