package pl.library.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.library.entity.Rental;

import java.util.List;
import java.util.Optional;

@Stateless
public class RentalRepository {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public Rental addRental(Rental rental) {
        em.persist(rental);
        return rental;
    }

    public Optional<Rental> findById(Long id) {
        return Optional.ofNullable(em.find(Rental.class, id));
    }
    
    public List<Rental> findAll() {
        TypedQuery<Rental> query = em.createQuery(
            "SELECT r FROM Rental r",
            Rental.class
        );
        return query.getResultList();
    }

    public Optional<Rental> updateRental(Rental rental) {
        Optional<Rental> toUpdate = findById(rental.getRentalId()); 
        if (toUpdate.isPresent()) {
            em.merge(rental);
            return Optional.of(rental);
        }
        return Optional.ofNullable(null);
    }

    
}
