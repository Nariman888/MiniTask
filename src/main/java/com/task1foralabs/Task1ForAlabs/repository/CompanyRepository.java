package com.task1foralabs.Task1ForAlabs.repository;

import com.task1foralabs.Task1ForAlabs.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company,Long> {
    List<Company> findAllByOrderByIdAsc();
}
