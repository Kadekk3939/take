package pl.library.repository;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.library.entity.Volume;

@Stateless
public class VolumeRepository {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public Volume addVolume(Volume volume) {
        em.persist(volume);
        return volume;
    }

    public Optional<Volume> findById(Long id) {
        return Optional.ofNullable(em.find(Volume.class, id));
    }
    
    public List<Volume> findAll() {
        TypedQuery<Volume> query = em.createQuery(
            "SELECT v FROM Volume v",
            Volume.class
        );
        return query.getResultList();
    }

    public Optional<Volume> updateVolume(Volume volume) {
        Optional<Volume> toUpdate = findById(volume.getVolumeId()); 
        if (toUpdate.isPresent()) {
            em.merge(volume);
            return Optional.of(volume);
        }
        return Optional.ofNullable(null);
    }

    public Optional<Volume> deleteVolume(Volume volume) {
        Optional<Volume> toDelete = findById(volume.getVolumeId()); 
        if (toDelete.isPresent()) {
            em.remove(toDelete);
            return toDelete;
        }
        return Optional.ofNullable(null);
    }
    
}
