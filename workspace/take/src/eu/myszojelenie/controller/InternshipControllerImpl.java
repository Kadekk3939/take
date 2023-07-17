package eu.myszojelenie.controller;

import eu.myszojelenie.controller.dto.internship.InternshipDto;
import eu.myszojelenie.controller.dto.internship.InternshipsDto;
import eu.myszojelenie.controller.dto.internship.NewInternshipDto;
import eu.myszojelenie.service.InternshipService;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class InternshipControllerImpl implements InternshipController {

    @EJB
    private InternshipService internshipService;

    @Override
    public InternshipDto create(NewInternshipDto internship) {
        return internshipService.addInternship(internship);
    }

    @Override
    public InternshipDto getById(Long id) {
        return internshipService.getById(id).orElseThrow(() -> new IllegalArgumentException("Internship with given id does not exist!"));
    }

    @Override
    public InternshipsDto getAll() {
        return internshipService.getAll();
    }
}
