package com.task1foralabs.Task1ForAlabs.service;

import com.task1foralabs.Task1ForAlabs.entity.Specialty;

import java.util.List;

public interface SpecialtyService {
    Specialty addSpecialty(Specialty specialty);
    Specialty updateSpecialty(Specialty specialty);
    void deleteSpecialty(Long id);
    List<Specialty> getSpecialities();
    Specialty getSpecialty(Long id);
}
