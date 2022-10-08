package com.task1foralabs.Task1ForAlabs.repository;

import com.task1foralabs.Task1ForAlabs.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SpecialtyRepository extends JpaRepository<Specialty,Long> {
    List<Specialty> findAllByOrderByIdAsc();
}
