package com.linktic.project.application.usecases.user;

import com.linktic.project.application.dto.UserDTO;
import com.linktic.project.application.dto.request.StoreUserRequestDTO;
import com.linktic.project.application.exceptions.FailOperationException;
import com.linktic.project.application.mappers.UserMapper;
import com.linktic.project.application.usecases.role.GetRoleById;
import com.linktic.project.domain.models.Role;
import com.linktic.project.domain.models.User;
import com.linktic.project.domain.services.IPasswordHashing;
import com.linktic.project.domain.services.IUserService;

public class StoreUser {
    private final IUserService userService;
    private final IPasswordHashing passwordHashing;
    private final GetRoleById getRoleById;

    public StoreUser(IUserService userService, IPasswordHashing passwordHashing, GetRoleById getRoleById) {
        this.userService = userService;
        this.passwordHashing = passwordHashing;
        this.getRoleById = getRoleById;
    }

    public UserDTO execute(StoreUserRequestDTO storeUserRequestDTO) {
        try {
            Role existRole = getRoleById.execute(storeUserRequestDTO.getRoleId());
            String salt = passwordHashing.generateSalt();
            String hashedPassword = passwordHashing.hashPassword(storeUserRequestDTO.getPassword(), salt);

            User userToAdd = new User(
                    null,
                    storeUserRequestDTO.getFirstName(),
                    storeUserRequestDTO.getLastName(),
                    storeUserRequestDTO.getEmail(),
                    hashedPassword,
                    salt,
                    existRole);

            userToAdd = userService.store(userToAdd);
            return UserMapper.toDto(userToAdd);
        } catch (Exception e) {
            throw new FailOperationException(e.getMessage());
        }
    }
}
