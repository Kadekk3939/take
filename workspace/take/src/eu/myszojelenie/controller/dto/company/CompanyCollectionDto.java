package eu.myszojelenie.controller.dto.company;

import java.util.List;

public class CompanyCollectionDto {
    private List<CompanyDto> companies;

    public CompanyCollectionDto(List<CompanyDto> companies) {
        this.companies = companies;
    }

    public List<CompanyDto> getCompanies() {
        return companies;
    }
}
