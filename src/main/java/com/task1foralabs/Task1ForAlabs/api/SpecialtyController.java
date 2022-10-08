package com.task1foralabs.Task1ForAlabs.api;

import com.task1foralabs.Task1ForAlabs.entity.Questionnaire;
import com.task1foralabs.Task1ForAlabs.entity.Specialty;
import com.task1foralabs.Task1ForAlabs.service.QuestionnaireService;
import com.task1foralabs.Task1ForAlabs.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/admin/specialty")
public class SpecialtyController {
    @Autowired
    SpecialtyService specialtyService;


    @GetMapping
    public List<Specialty> getAllSpecialty(){
        return specialtyService.getSpecialities();
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    public Specialty addSpecialty(@RequestBody Specialty specialty){
        return specialtyService.addSpecialty(specialty);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "{id}")
    public void deleteSpecialtyFromList(@PathVariable(name = "id") Long id){
        specialtyService.deleteSpecialty(id);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "{id}")
    public Specialty getSpecialtyDetails(@PathVariable(name = "id") Long id) {
        return specialtyService.getSpecialty(id);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping
    public Specialty updateSpecialty( @RequestBody Specialty specialty){
        return specialtyService.updateSpecialty(specialty);
    }
}
