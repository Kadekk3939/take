package eu.myszojelenie.service;

import eu.myszojelenie.controller.dto.offer.NewOfferDto;
import eu.myszojelenie.controller.dto.offer.OfferDto;
import eu.myszojelenie.controller.dto.offer.OffersDto;
import eu.myszojelenie.entity.Company;
import eu.myszojelenie.entity.Offer;
import eu.myszojelenie.repository.CompanyRepository;
import eu.myszojelenie.repository.OfferRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class OfferService {

    @EJB
    private OfferRepository offerRepository;

    @EJB
    private CompanyRepository companyRepository;

    public OfferDto createOffer(NewOfferDto dto) {
        Company company = companyRepository.findById(dto.getCompanyId()).orElseThrow(() -> new IllegalArgumentException("Company does not exist!"));
        Offer offer = mapToEntity(dto, company);
        Offer createdOffer = offerRepository.createOffer(offer);
        return mapToDto(createdOffer);
    }

    public Optional<OfferDto> getOfferById(Long id) {
        Optional<Offer> offer = offerRepository.findById(id);
        return offer.map(this::mapToDto);
    }

    public OffersDto getAllOffers(Boolean withRemoved) {
        List<Offer> offers = offerRepository.findAll(withRemoved);
        List<OfferDto> dtos = offers.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
        return new OffersDto(dtos);
    }

    public void inactiveOffer(Long offerId) {
        offerRepository.findById(offerId).ifPresent(Offer::markAsInactive);
    }

    public Optional<OfferDto> activateOfer(Long offerId) {
        Optional<Offer> offer = offerRepository.findById(offerId);
        offer.ifPresent(Offer::markAsActive);
        return offer.map(this::mapToDto);
    }

    public OfferDto mapToDto(Offer offer) {
        OfferDto dto = new OfferDto();
        dto.setDescription(offer.getDescription());
        dto.setLeftPositions(offer.getLeftPositions());
        dto.setName(offer.getName());
        dto.setPositions(offer.getPositions());
        dto.setSalary(offer.getSalary());
        dto.setOfferId(offer.getOfferId());
        dto.setCompanyName(offer.getCompany().getName());
        dto.setCity(offer.getCompany().getCity());
        dto.setActive(offer.getActive());
        return dto;
    }

    private Offer mapToEntity(NewOfferDto dto, Company company) {
        Offer offer = new Offer();
        offer.setActive(true);
        offer.setCompany(company);
        offer.setDescription(dto.getDescription());
        offer.setLeftPositions(dto.getPositions());
        offer.setPositions(dto.getPositions());
        offer.setName(dto.getName());
        offer.setSalary(dto.getSalary());
        return offer;
    }

}
