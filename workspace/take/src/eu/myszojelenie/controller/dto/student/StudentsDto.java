package eu.myszojelenie.controller.dto.student;

import java.util.List;

public class StudentsDto {
    private List<StudentDto> students;
    private Long allStudents;
    private Long studentsWithApprovedInternship;
    private Long studentsWithoutApprovedInternship;
    private Long studentsWithApprovedInternshipButNotFinished;
    private Long studentsWithFinishedInternship;

    public StudentsDto(List<StudentDto> students){
        this.students = students;
        this.allStudents = (long) students.size();
        setStats();
    }

    private void setStats() {
        this.studentsWithApprovedInternship = students.stream()
                .filter(StudentDto::getHasApprovedInternship)
                .count();
        this.studentsWithoutApprovedInternship = allStudents - studentsWithApprovedInternship;
        this.studentsWithFinishedInternship = students.stream()
                .filter(StudentDto::getHasFinishedInternship)
                .count();
        this.studentsWithApprovedInternshipButNotFinished = students.stream()
                .filter(StudentDto::getHasApprovedInternship)
                .filter(s -> !s.getHasFinishedInternship())
                .count();
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public Long getAllStudents() {
        return allStudents;
    }

    public Long getStudentsWithApprovedInternship() {
        return studentsWithApprovedInternship;
    }

    public Long getStudentsWithoutApprovedInternship() {
        return studentsWithoutApprovedInternship;
    }

    public Long getStudentsWithApprovedInternshipButNotFinished() {
        return studentsWithApprovedInternshipButNotFinished;
    }

    public Long getStudentsWithFinishedInternship() {
        return studentsWithFinishedInternship;
    }
}
