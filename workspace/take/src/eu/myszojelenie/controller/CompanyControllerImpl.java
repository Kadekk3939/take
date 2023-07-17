package eu.myszojelenie.controller;

import eu.myszojelenie.controller.dto.company.CompanyCollectionDto;
import eu.myszojelenie.controller.dto.company.CompanyDto;
import eu.myszojelenie.controller.dto.company.NewCompanyDto;
import eu.myszojelenie.service.CompanyService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Optional;

@Stateless
public class CompanyControllerImpl implements CompanyController {

    @EJB
    CompanyService companyService;

    @Override
    public CompanyDto createCompany(NewCompanyDto dto) {
        return companyService.create(dto);
    }

    @Override
    public CompanyDto getCompany(Long id) {
        Optional<CompanyDto> company = companyService.findCompanyById(id);
        return company.orElseThrow(() -> new IllegalArgumentException("Company with given id does not exist!"));
    }

    @Override
    public CompanyCollectionDto getAllCompanies() {
        return companyService.findAll();
    }
}
