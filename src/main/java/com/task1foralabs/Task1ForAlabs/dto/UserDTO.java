package com.task1foralabs.Task1ForAlabs.dto;

import com.task1foralabs.Task1ForAlabs.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String fullName;
    private List<Role> roles;
}
