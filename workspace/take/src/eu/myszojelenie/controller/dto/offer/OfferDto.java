package eu.myszojelenie.controller.dto.offer;

public class OfferDto {

    private Long offerId;
    private String name;
    private String description;
    private String companyName;
    private String city;
    private Long positions;
    private Long leftPositions;
    private Long salary;
    private Boolean active;

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPositions() {
        return positions;
    }

    public void setPositions(Long positions) {
        this.positions = positions;
    }

    public Long getLeftPositions() {
        return leftPositions;
    }

    public void setLeftPositions(Long leftPositions) {
        this.leftPositions = leftPositions;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
