package com.task1foralabs.Task1ForAlabs.service.imp;

import com.task1foralabs.Task1ForAlabs.entity.Company;
import com.task1foralabs.Task1ForAlabs.repository.CompanyRepository;
import com.task1foralabs.Task1ForAlabs.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImp implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company updateCompany(Company company) {
        if (company!=null){
        return companyRepository.save(company);
        }
        return null;
    }

    @Override
    public List<Company> getCompanies() {
        return companyRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElseThrow();
    }
}
