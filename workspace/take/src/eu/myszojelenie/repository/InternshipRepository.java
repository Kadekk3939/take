package eu.myszojelenie.repository;

import eu.myszojelenie.entity.Internship;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;


@Stateless
public class InternshipRepository {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public Internship create(Internship internship) {
        em.persist(internship);
        return internship;
    }

    public Optional<Internship> findById(Long internshipId) {
        String statement = "SELECT i FROM Internship i WHERE i.internshipId = :id";
        TypedQuery<Internship> query = em.createQuery(statement, Internship.class);
        query.setParameter("id", internshipId);
        List<Internship> results = query.getResultList();
        return results.stream().findFirst();
    }

    public List<Internship> findAll() {
        String statement = "SELECT i FROM Internship i";
        TypedQuery<Internship> query = em.createQuery(statement, Internship.class);
        return query.getResultList();
    }


}
