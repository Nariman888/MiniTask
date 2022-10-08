package com.task1foralabs.Task1ForAlabs.repository;

import com.task1foralabs.Task1ForAlabs.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}
