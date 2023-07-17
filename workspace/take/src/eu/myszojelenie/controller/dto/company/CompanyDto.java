package eu.myszojelenie.controller.dto.company;

import eu.myszojelenie.controller.dto.offer.OffersDto;

public class CompanyDto {
    private Long companyId;
    private String name;
    private String city;
    private String zipCode;
    private String street;
    private Integer buildingNumber;
    private OffersDto createdOffers;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public OffersDto getCreatedOffers() {
        return createdOffers;
    }

    public void setCreatedOffers(OffersDto createdOffers) {
        this.createdOffers = createdOffers;
    }
}
