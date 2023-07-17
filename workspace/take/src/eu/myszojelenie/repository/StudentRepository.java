package eu.myszojelenie.repository;

import eu.myszojelenie.entity.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class StudentRepository {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public Student add(Student student) {
        em.persist(student);
        return student;
    }

    public Student delete(Long studentId) {
        Optional<Student> stud = getStudent(studentId);
        if (!stud.isPresent()) {
            throw new IllegalArgumentException("Student does not exist!");
        }
        em.remove(stud.get());
        return stud.get();
    }

    // TODO: remove or change to index as String
    public Student deleteByIndex(Long index) {
        String statement = "SELECT s FROM Student s WHERE s.studentIndex = :index";
        TypedQuery<Student> query = em.createQuery(statement, Student.class);
        query.setParameter("index", index);
        List<Student> results = query.getResultList();
        Student student = results.stream().
                findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Student with %s index does not exist", index)));
        em.remove(student);
        return student;
    }

    public List<Student> findAll(){
        String statement = "SELECT s FROM Student s";
        TypedQuery<Student> query = em.createQuery(statement, Student.class);
        System.out.println(query.getResultList().size());
        return query.getResultList();
    }

    public Optional<Student> findByIndex(String index) {
        String statement = "SELECT s FROM Student s WHERE s.studentIndex = :index";
        TypedQuery<Student> query = em.createQuery(statement, Student.class);
        query.setParameter("index", index);
        List<Student> results = query.getResultList();
        return results.stream().findFirst();
    }

    public Student update(Student student) {
        if (!getStudent(student).isPresent()) {
            throw new IllegalArgumentException("Student does not exist in db!");
        }
        em.merge(student);
        return student;
    }

    private Optional<Student> getStudent(Student potentiallyInvalidStudentEntity) {
        return getStudent(potentiallyInvalidStudentEntity.getStudentId());
    }

    private Optional<Student> getStudent(Long id) {
        Student student = em.find(Student.class, id);
        return Optional.ofNullable(student);
    }


}
