package eu.myszojelenie.service;

import eu.myszojelenie.controller.dto.company.CompanyCollectionDto;
import eu.myszojelenie.controller.dto.company.CompanyDto;
import eu.myszojelenie.controller.dto.company.NewCompanyDto;
import eu.myszojelenie.controller.dto.offer.OfferDto;
import eu.myszojelenie.controller.dto.offer.OffersDto;
import eu.myszojelenie.entity.Company;
import eu.myszojelenie.repository.CompanyRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class CompanyService {

    @EJB
    CompanyRepository companyRepository;

    @EJB
    OfferService offerService;

    public CompanyDto create(NewCompanyDto companyDto) {
        Company company = new Company();
        company.setCity(companyDto.getCity());
        company.setBuildingNumber(companyDto.getBuildingNumber());
        company.setName(companyDto.getName());
        company.setZipCode(companyDto.getZipCode());
        company.setStreet(companyDto.getStreet());
        Company createdCompany = companyRepository.addCompany(company);
        return mapToDto(createdCompany);
    }

    public Optional<CompanyDto> findCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.map(this::mapToDto);
    }

    public CompanyCollectionDto findAll() {
        List<Company> companies = companyRepository.findAll();
        List<CompanyDto> dtos = companies.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
        return new CompanyCollectionDto(dtos);
    }

    private CompanyDto mapToDto(Company company) {
        CompanyDto dto = new CompanyDto();
        dto.setCompanyId(company.getCompanyId());
        dto.setCity(company.getCity());
        dto.setName(company.getName());
        dto.setStreet(company.getStreet());
        dto.setZipCode(company.getZipCode());
        dto.setBuildingNumber(company.getBuildingNumber());
        List<OfferDto> offersDto = mapOffers(company);
        dto.setCreatedOffers(new OffersDto(offersDto));
        return dto;
    }

    private List<OfferDto> mapOffers(Company company) {
        List<OfferDto> offers = new ArrayList<>();
        if(company.getCreatedOffers() != null){
            offers = company.getCreatedOffers().stream()
                    .map(o -> offerService.mapToDto(o))
                    .collect(Collectors.toList());
        }
        return offers;
    }

}
