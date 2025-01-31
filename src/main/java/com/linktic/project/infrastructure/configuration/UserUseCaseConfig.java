package com.linktic.project.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.linktic.project.application.usecases.role.GetRoleById;
import com.linktic.project.application.usecases.user.FindAllUsers;
import com.linktic.project.application.usecases.user.StoreUser;
import com.linktic.project.domain.services.IPasswordHashing;
import com.linktic.project.domain.services.IUserService;

@Configuration
public class UserUseCaseConfig {
    private final IUserService userService;
    private final GetRoleById getRoleById;
    private final IPasswordHashing passwordHashing;

    @Autowired
    public UserUseCaseConfig(
            IUserService userService,
            GetRoleById getRoleById,
            IPasswordHashing passwordHashing

    ) {
        this.userService = userService;
        this.getRoleById = getRoleById;
        this.passwordHashing = passwordHashing;
    }

    @Bean
    public StoreUser storeUser() {
        return new StoreUser(userService, passwordHashing, getRoleById);
    }

    @Bean
    public FindAllUsers findAllUsers() {
        return new FindAllUsers(userService);
    }
}
