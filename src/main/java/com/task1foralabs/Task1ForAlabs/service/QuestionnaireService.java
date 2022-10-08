package com.task1foralabs.Task1ForAlabs.service;

import com.task1foralabs.Task1ForAlabs.entity.Company;
import com.task1foralabs.Task1ForAlabs.entity.Questionnaire;
import com.task1foralabs.Task1ForAlabs.entity.Specialty;

import java.util.List;

public interface QuestionnaireService {
    Questionnaire addQuestionnaire(Questionnaire questionnaire);
    List<Questionnaire> getAll();
    List<Questionnaire> getByCompany(Long id);
    List<Questionnaire> getBySpecialty(Long id);
}
