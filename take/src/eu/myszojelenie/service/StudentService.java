package eu.myszojelenie.service;

import eu.myszojelenie.controller.dto.student.StudentInternshipDto;
import eu.myszojelenie.controller.dto.student.NewStudentDto;
import eu.myszojelenie.controller.dto.student.StudentDto;
import eu.myszojelenie.controller.dto.student.StudentsDto;
import eu.myszojelenie.entity.Internship;
import eu.myszojelenie.entity.Student;
import eu.myszojelenie.repository.StudentRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class StudentService {

    @EJB
    private StudentRepository studentRepository;

    public StudentDto addStudent(NewStudentDto studentDto) {
        Student student = new Student();
        student.setStudentIndex(studentDto.getStudentIndex());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setHasFoundInternship(false);
        student.setHasInternshipApproved(false);
        student.setHasInternshipFinished(false);
        Student createdStudent = studentRepository.add(student);
        return mapToStudentDto(createdStudent);
    }

    public Optional<StudentDto> getStudentAtIndex(String index) {
        Optional<Student> student = studentRepository.findByIndex(index);
        return student.map(this::mapToStudentDto);
    }

    public StudentsDto getAllStudents() {
        List<Student> allStudents = studentRepository.findAll();
        List<StudentDto> studentsDto = allStudents.stream()
                .map(this::mapToStudentDto)
                .collect(Collectors.toList());
        return new StudentsDto(studentsDto);
    }

    public Optional<StudentDto> approveStudentInternship(String index) {
        Optional<Student> student = studentRepository.findByIndex(index);
        student.ifPresent(Student::approveInternship);
        return student.map(this::mapToStudentDto);
    }

    public Optional<StudentDto> finalizeStudentInternship(String index) {
        Optional<Student> student = studentRepository.findByIndex(index);
        student.ifPresent(Student::markInternshipAsFinished);
        return student.map(this::mapToStudentDto);
    }

    private StudentDto mapToStudentDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setFirstName(student.getFirstName());
        dto.setStudentIndex(student.getStudentIndex());
        dto.setLastName(student.getLastName());
        dto.setId(student.getStudentId());
        dto.setHasApprovedInternship(student.getHasInternshipApproved());
        dto.setHasFinishedInternship(student.getHasInternshipFinished());
        dto.setHasFoundInternship(student.getHasFoundInternship());
        if (student.getInternship() != null)
            dto.setInternship(mapToInternshipDto(student.getInternship()));
        return dto;
    }

    private StudentInternshipDto mapToInternshipDto(Internship internship) {
        StudentInternshipDto dto = new StudentInternshipDto();
        dto.setId(internship.getInternshipId());
        dto.setCompanyName(internship.getOffer() != null ? internship.getOffer().getCompany().getName() : "---");
        dto.setOfferName(internship.getOffer() != null ? internship.getOffer().getName() : "---");
        return dto;
    }


}
