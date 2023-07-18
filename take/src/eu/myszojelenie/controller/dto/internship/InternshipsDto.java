package eu.myszojelenie.controller.dto.internship;

import java.util.List;

public class InternshipsDto {
    private List<InternshipDto> internships;

    public InternshipsDto(List<InternshipDto> internships) {
        this.internships = internships;
    }

    public List<InternshipDto> getInternships() {
        return internships;
    }
}