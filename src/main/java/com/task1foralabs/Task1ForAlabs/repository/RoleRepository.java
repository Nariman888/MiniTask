package com.task1foralabs.Task1ForAlabs.repository;

import com.task1foralabs.Task1ForAlabs.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByRole(String role);
}
