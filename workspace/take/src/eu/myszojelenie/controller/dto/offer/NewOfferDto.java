package eu.myszojelenie.controller.dto.offer;

public class NewOfferDto {
    private String name;
    private String description;
    private Long positions;
    private Long salary;
    private Long companyId;

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

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
