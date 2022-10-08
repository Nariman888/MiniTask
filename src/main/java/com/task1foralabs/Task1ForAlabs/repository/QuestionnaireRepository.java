package com.task1foralabs.Task1ForAlabs.repository;

import com.task1foralabs.Task1ForAlabs.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface QuestionnaireRepository extends JpaRepository<Questionnaire,Long> {
    List<Questionnaire> findAllByCompanyId(Long id);
    List<Questionnaire> findAllBySpecialtyId(Long id);
}
