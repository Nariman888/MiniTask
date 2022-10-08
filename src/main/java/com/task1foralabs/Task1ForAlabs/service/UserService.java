package com.task1foralabs.Task1ForAlabs.service;

import com.task1foralabs.Task1ForAlabs.dto.UserDTO;
import com.task1foralabs.Task1ForAlabs.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Users addUser(Users user, String rePassword);
    Users getCurrentUser();
}
