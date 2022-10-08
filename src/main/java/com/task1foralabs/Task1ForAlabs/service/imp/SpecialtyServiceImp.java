package com.task1foralabs.Task1ForAlabs.service.imp;

import com.task1foralabs.Task1ForAlabs.entity.Specialty;
import com.task1foralabs.Task1ForAlabs.repository.SpecialtyRepository;
import com.task1foralabs.Task1ForAlabs.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyServiceImp implements SpecialtyService {
    @Autowired
    SpecialtyRepository specialtyRepository;
    @Override
    public Specialty addSpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public Specialty updateSpecialty(Specialty specialty) {
        if (specialty!=null){
        return specialtyRepository.save(specialty);
        }
        return null;
    }

    @Override
    public void deleteSpecialty(Long id) {
        specialtyRepository.deleteById(id);
    }

    @Override
    public List<Specialty> getSpecialities() {
        return specialtyRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Specialty getSpecialty(Long id) {
        return specialtyRepository.findById(id).orElseThrow();
    }
}
