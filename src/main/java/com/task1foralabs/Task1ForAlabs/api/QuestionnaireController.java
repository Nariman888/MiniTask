package com.task1foralabs.Task1ForAlabs.api;

import com.task1foralabs.Task1ForAlabs.entity.Company;
import com.task1foralabs.Task1ForAlabs.entity.Questionnaire;
import com.task1foralabs.Task1ForAlabs.entity.Specialty;
import com.task1foralabs.Task1ForAlabs.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/questionnaire")
public class QuestionnaireController {
    @Autowired
    QuestionnaireService questionnaireService;

    @PreAuthorize("hasAnyRole('ROLE_CANDIDATE')")
    @PostMapping
    public Questionnaire formUp(@RequestBody Questionnaire questionnaire){
        return questionnaireService.addQuestionnaire(questionnaire);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    @GetMapping
    public List<Questionnaire> getAll(){
        return questionnaireService.getAll();
    }
    @GetMapping(value = "/company/{id}")
    public List<Questionnaire> getByCompany(@PathVariable (name = "id") Long id){
        return questionnaireService.getByCompany(id);
    }
    @GetMapping(value = "/specialty/{id}")
    public List<Questionnaire> getBySpecialty(@PathVariable(name = "id") Long id){
        return questionnaireService.getBySpecialty(id);
    }
}
