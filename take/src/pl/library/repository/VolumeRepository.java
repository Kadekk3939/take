package pl.library.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.library.entity.Volume;

public class VolumeRepository {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public Volume addVolume(Volume volume) {
        em.persist(volume);
        return volume;
    }

    public Optional<Volume> findById(Long id) {
        TypedQuery<Volume> query = em.createQuery(
            "SELECT v FROM Volumes v WHERE v.volumeId = :id",
            Volume.class
        );
        query.setParameter("id", id);
        return query.getResultList().stream().findFirst();
    }

    public List<Volume> findAll() {
        TypedQuery<Volume> query = em.createQuery(
            "SELECT v FROM Volumes v",
            Volume.class
        );
        return query.getResultList();
    }
    
}
