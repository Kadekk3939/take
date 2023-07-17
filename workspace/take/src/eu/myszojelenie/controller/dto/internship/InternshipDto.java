package eu.myszojelenie.controller.dto.internship;

import eu.myszojelenie.controller.dto.offer.OfferDto;

import java.time.LocalDateTime;

public class InternshipDto {
    private Long internshipId;
    private String startingDate;
    private OfferDto offer;
    private InternshipStudentDto student;

    public Long getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Long internshipId) {
        this.internshipId = internshipId;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public OfferDto getOffer() {
        return offer;
    }

    public void setOffer(OfferDto offer) {
        this.offer = offer;
    }

    public InternshipStudentDto getStudent() {
        return student;
    }

    public void setStudent(InternshipStudentDto student) {
        this.student = student;
    }
}
