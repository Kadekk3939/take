package eu.myszojelenie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;
    private String name;
    private String description;
    private Long positions;
    private Long leftPositions;
    private Long salary;
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToMany(mappedBy = "offer")
    private List<Internship> internships;

    public void bookOffer() {
        if(!active) {
            throw new IllegalStateException("Cannot book offer, offer is inactive!");
        }
        if(leftPositions < 1) {
            throw new IllegalStateException("There are no positions left!");
        }
        leftPositions -= 1;
        if(leftPositions == 0) {
            active = false;
        }
    }

    public void markAsInactive() {
        this.active = false;
    }

    public void markAsActive() {
        if(this.leftPositions < 1){
            throw new IllegalStateException("Cannot mark offer as active, there are no positions left!");
        }
        this.active = true;
    }

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Internship> getInternships() {
        return internships;
    }

    public void setInternships(List<Internship> internships) {
        this.internships = internships;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
