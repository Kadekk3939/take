package pl.library.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.library.entity.Reader;

public class ReaderRepository {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public Reader addReader(Reader reader) {
        em.persist(reader);
        return reader;
    }

    public Optional<Reader> findById(Long id) {
        TypedQuery<Reader> query = em.createQuery(
            "SELECT r FROM Readers r WHERE r.readerId = :id",
            Reader.class
        );
        query.setParameter("id", id);
        return query.getResultList().stream().findFirst();
    }

    public List<Reader> findAll() {
        TypedQuery<Reader> query = em.createQuery(
            "SELECT r FROM Readers r",
            Reader.class
        );
        return query.getResultList();
    }
}
