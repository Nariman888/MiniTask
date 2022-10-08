package com.task1foralabs.Task1ForAlabs.service.imp;

import com.task1foralabs.Task1ForAlabs.entity.Role;
import com.task1foralabs.Task1ForAlabs.repository.RoleRepository;
import com.task1foralabs.Task1ForAlabs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Role addRole(String role) {
        return roleRepository.findRoleByRole(role);
    }
}
