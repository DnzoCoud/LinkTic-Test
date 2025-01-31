package com.linktic.project.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String salt;
}
