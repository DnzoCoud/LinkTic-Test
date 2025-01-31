package com.linktic.project.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreUserRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long roleId;
}
