package eu.myszojelenie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String studentIndex;
    @OneToOne(mappedBy = "student")
    private Internship internship;
    private Boolean hasFoundInternship;
    private Boolean hasInternshipApproved;
    private Boolean hasInternshipFinished;

    public void approveInternship() {
        if (internship == null) {
            throw new IllegalStateException("Student has not applied for internship!");
        }
        hasInternshipApproved = true;
    }

    public void markInternshipAsFinished() {
        if (internship == null) {
            throw new IllegalStateException("Student has not applied for internship!");
        } else if (!hasInternshipApproved) {
            throw new IllegalStateException("Cannot mark not approved internship as finished!");
        }
        hasInternshipFinished = true;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public String getStudentIndex() {
        return studentIndex;
    }

    public void setStudentIndex(String studentIndex) {
        this.studentIndex = studentIndex;
    }

    public Boolean getHasInternshipApproved() {
        return hasInternshipApproved;
    }

    public void setHasInternshipApproved(Boolean hasInternshipApproved) {
        this.hasInternshipApproved = hasInternshipApproved;
    }

    public Boolean getHasInternshipFinished() {
        return hasInternshipFinished;
    }

    public void setHasInternshipFinished(Boolean hasInternshipFinished) {
        this.hasInternshipFinished = hasInternshipFinished;
    }

    public Boolean getHasFoundInternship() {
        return hasFoundInternship;
    }

    public void setHasFoundInternship(Boolean hasFoundInternship) {
        if(this.hasFoundInternship != null && this.hasFoundInternship){
            throw new IllegalStateException("Student already has internship!");
        }
        this.hasFoundInternship = hasFoundInternship;
    }
}
