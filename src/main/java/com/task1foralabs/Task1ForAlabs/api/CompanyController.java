package com.task1foralabs.Task1ForAlabs.api;

import com.task1foralabs.Task1ForAlabs.entity.Company;
import com.task1foralabs.Task1ForAlabs.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/admin/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    public Company addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }
    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getCompanies();
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "{id}")
    public void deleteCompanyFromList(@PathVariable(name = "id") Long id){
        companyService.deleteCompany(id);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "{id}")
    public Company getCompanyDetails(@PathVariable(name = "id") Long id) {
        return companyService.getCompany(id);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping
    public Company updateCompany( @RequestBody Company company){
        return companyService.updateCompany(company);
    }

}
