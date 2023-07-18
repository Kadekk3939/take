package eu.myszojelenie.controller;

import eu.myszojelenie.controller.dto.student.NewStudentDto;
import eu.myszojelenie.controller.dto.student.StudentDto;
import eu.myszojelenie.controller.dto.student.StudentsDto;
import eu.myszojelenie.controller.dto.student.UpdateStudentDto;
import eu.myszojelenie.service.StudentService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Optional;

@Stateless
public class StudentControllerImpl implements StudentController {

    @EJB
    private StudentService studentService;

    @Override
    public StudentDto createStudent(NewStudentDto studentDto) {
        return studentService.addStudent(studentDto);
    }

    @Override
    public StudentDto updateStudent(UpdateStudentDto studentDto) {
        return null;
    }

    @Override
    public StudentDto getStudent(String index) {
        Optional<StudentDto> student = studentService.getStudentAtIndex(index);
        return student.orElseThrow(() -> new IllegalArgumentException("Student with given index does not exist!"));
    }

    @Override
    public StudentsDto getStudents() {
        return studentService.getAllStudents();
    }

    @Override
    public StudentDto approveStudentInternship(String index) {
        Optional<StudentDto> student = studentService.approveStudentInternship(index);
        return student.orElseThrow(() -> new IllegalArgumentException("Student with given index does not exist!"));
    }

    @Override
    public StudentDto finalizeStudentInternship(String index) {
        Optional<StudentDto> student = studentService.finalizeStudentInternship(index);
        return student.orElseThrow(() -> new IllegalArgumentException("Student with given index does not exist!"));
    }
    
    @Override
    public String testMethod() {
    	return "This is a drill!";
    }
}
