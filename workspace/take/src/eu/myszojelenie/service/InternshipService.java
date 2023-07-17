package eu.myszojelenie.service;

import eu.myszojelenie.controller.dto.internship.InternshipDto;
import eu.myszojelenie.controller.dto.internship.InternshipStudentDto;
import eu.myszojelenie.controller.dto.internship.InternshipsDto;
import eu.myszojelenie.controller.dto.internship.NewInternshipDto;
import eu.myszojelenie.controller.dto.offer.OfferDto;
import eu.myszojelenie.entity.Internship;
import eu.myszojelenie.entity.Offer;
import eu.myszojelenie.entity.Student;
import eu.myszojelenie.repository.InternshipRepository;
import eu.myszojelenie.repository.OfferRepository;
import eu.myszojelenie.repository.StudentRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static eu.myszojelenie.util.DateParser.*;

@Stateless
public class InternshipService {

    @EJB
    private InternshipRepository internshipRepository;

    @EJB
    private OfferRepository offerRepository;

    @EJB
    private StudentRepository studentRepository;

    @EJB
    private OfferService offerService;

    public InternshipDto addInternship(NewInternshipDto internshipDto) {
        Offer offer = offerRepository.findById(internshipDto.getOfferId()).orElseThrow(() -> new IllegalArgumentException("Offer with given id does not exist!"));
        offer.bookOffer();
        Student student = studentRepository.findByIndex(internshipDto.getStudentIndex()).orElseThrow(() -> new IllegalArgumentException("Student with given index does not exist!"));
        student.setHasFoundInternship(true);

        Internship internship = mapToEntity(internshipDto, offer, student);
        Internship createdInternship = internshipRepository.create(internship);

        return mapToInternshipDto(createdInternship);
    }

    public Optional<InternshipDto> getById(Long id) {
        Optional<Internship> internship = internshipRepository.findById(id);
        return internship.map(this::mapToInternshipDto);
    }

    public InternshipsDto getAll() {
        List<Internship> internships = internshipRepository.findAll();
        List<InternshipDto> internshipsDto = internships.stream()
                .map(this::mapToInternshipDto)
                .collect(Collectors.toList());
        return new InternshipsDto(internshipsDto);
    }


    private InternshipDto mapToInternshipDto(Internship internship) {
        Offer offer = internship.getOffer();
        OfferDto offerDto = offerService.mapToDto(offer);

        Student student = internship.getStudent();
        InternshipStudentDto studentDto = mapToInternshipStudentDto(student);

        InternshipDto dto = new InternshipDto();
        dto.setInternshipId(internship.getInternshipId());
        dto.setStartingDate(internship.getStartingDate().toString());
        dto.setOffer(offerDto);
        dto.setStudent(studentDto);
        return dto;
    }

    private InternshipStudentDto mapToInternshipStudentDto(Student student) {
        InternshipStudentDto studentDto = new InternshipStudentDto();
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setId(student.getStudentId());
        studentDto.setApproved(student.getHasInternshipApproved());
        studentDto.setIndex(student.getStudentIndex());
        studentDto.setFinished(student.getHasInternshipFinished());
        return studentDto;
    }

    private Internship mapToEntity(NewInternshipDto internshipDto, Offer offer, Student student) {
        String date = internshipDto.getStartingDate();
        Internship internship = new Internship();
        internship.setOffer(offer);
        internship.setStudent(student);
        internship.setStartingDate(LocalDateTime.of(getYear(date), getMonth(date), getDay(date), 0, 0));
        return internship;
    }

}
