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
        return Optional.ofNullable(em.find(Title.class, id));
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

    public Optional<Title> updateTitle(Title title) {
        Optional<Title> toUpdate = findById(title.getTitleId()); 
        if (toUpdate.isPresent()) {
            em.merge(title);
            return Optional.of(title);
        }
        return Optional.ofNullable(null);
    }

    public Optional<Title> deleteTitle(Title title) {
        Optional<Title> toDelete = findById(title.getTitleId()); 
        if (toDelete.isPresent()) {
            em.remove(toDelete);
            return toDelete;
        }
        return Optional.ofNullable(null);
    }

}
