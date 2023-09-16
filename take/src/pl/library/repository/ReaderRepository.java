package pl.library.repository;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.library.entity.Reader;

@Stateless
public class ReaderRepository {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public Reader addReader(Reader reader) {
        em.persist(reader);
        return reader;
    }

    public Optional<Reader> findById(Long id) {
        return Optional.ofNullable(em.find(Reader.class, id));
    }

    public Optional<Reader> findByLogin(String login) {
        TypedQuery<Reader> query = em.createQuery(
            "SELECT r FROM Reader r WHERE r.login = :login",
            Reader.class
        );
        query.setParameter("login", login);
        return query.getResultList().stream().findFirst();
    }
    
    public List<Reader> findAll() {
        TypedQuery<Reader> query = em.createQuery(
            "SELECT r FROM Reader r",
            Reader.class
        );
        return query.getResultList();
    }

    public Optional<Reader> updateReader(Reader reader) {
        Optional<Reader> toUpdate = findById(reader.getReaderId()); 
        if (toUpdate.isPresent()) {
            em.merge(reader);
            return Optional.of(reader);
        }
        return Optional.ofNullable(null);
    }

    public Optional<Reader> deleteReader(Reader reader) {
        Optional<Reader> toDelete = findById(reader.getReaderId()); 
        if (toDelete.isPresent()) {
            em.remove(toDelete);
            return toDelete;
        }
        return Optional.ofNullable(null);
    }
}
