package com.task1foralabs.Task1ForAlabs.service.imp;

import com.task1foralabs.Task1ForAlabs.entity.Company;
import com.task1foralabs.Task1ForAlabs.entity.Questionnaire;
import com.task1foralabs.Task1ForAlabs.entity.Specialty;
import com.task1foralabs.Task1ForAlabs.repository.QuestionnaireRepository;
import com.task1foralabs.Task1ForAlabs.service.QuestionnaireService;
import com.task1foralabs.Task1ForAlabs.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionnaireServiceImp implements QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;
    private final UserService userService;


    @Override
    public Questionnaire addQuestionnaire(Questionnaire questionnaire) {
            questionnaire.setUser(userService.getCurrentUser());
            return questionnaireRepository.save(questionnaire);

    }
    @Override
    public List<Questionnaire> getAll() {
        return questionnaireRepository.findAll();
    }

    @Override
    public List<Questionnaire> getByCompany(Long id) {
        return questionnaireRepository.findAllByCompanyId(id);
    }

    @Override
    public List<Questionnaire> getBySpecialty(Long id) {
        return questionnaireRepository.findAllBySpecialtyId(id);
    }

}
