package eu.myszojelenie.controller.dto.student;

public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String studentIndex;
    private Boolean hasApprovedInternship;
    private Boolean hasFinishedInternship;
    private Boolean hasFoundInternship;
    private StudentInternshipDto internship;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentIndex() {
        return studentIndex;
    }

    public void setStudentIndex(String studentIndex) {
        this.studentIndex = studentIndex;
    }

    public Boolean getHasApprovedInternship() {
        return hasApprovedInternship;
    }

    public void setHasApprovedInternship(Boolean hasApprovedInternship) {
        this.hasApprovedInternship = hasApprovedInternship;
    }

    public Boolean getHasFinishedInternship() {
        return hasFinishedInternship;
    }

    public void setHasFinishedInternship(Boolean hasFinishedInternship) {
        this.hasFinishedInternship = hasFinishedInternship;
    }

    public StudentInternshipDto getInternship() {
        return internship;
    }

    public void setInternship(StudentInternshipDto internship) {
        this.internship = internship;
    }

    public Boolean getHasFoundInternship() {
        return hasFoundInternship;
    }

    public void setHasFoundInternship(Boolean hasFoundInternship) {
        this.hasFoundInternship = hasFoundInternship;
    }
}
