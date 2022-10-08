package com.task1foralabs.Task1ForAlabs.service;

import com.task1foralabs.Task1ForAlabs.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getCompanies();
    Company addCompany(Company company);
    void deleteCompany(Long id);
    Company updateCompany(Company company);
    Company getCompany(Long id);
}
