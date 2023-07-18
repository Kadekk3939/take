package pl.library.repository;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.library.entity.Title;

@Stateless
public class TitleRepository {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public Title addTitle(Title title) {
        em.persist(title);
        return title;
    }

    public Optional<Title> findById(Long id) {
        TypedQuery<Title> query = em.createQuery(
            "SELECT t FROM Titles t WHERE t.titleId = :id",
            Title.class
        );
        query.setParameter("id", id);
        return query.getResultList().stream().findFirst();
    }

    public Optional<Title> findByName(String name) {
        TypedQuery<Title> query = em.createQuery(
            "SELECT t FROM Titles t WHERE t.name = :name",
            Title.class
        );
        query.setParameter("name", name);
        return query.getResultList().stream().findFirst();
    }
    
    public List<Title> findAll() {
        TypedQuery<Title> query = em.createQuery(
            "SELECT t FROM Titles t",
            Title.class
        );
        return query.getResultList();
    }

    
}
