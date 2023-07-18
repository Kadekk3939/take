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
        TypedQuery<Rental> query = em.createQuery(
            "SELECT r FROM Rentals r WHERE r.rentalId = :id",
            Rental.class
        );
        query.setParameter("id", id);
        return query.getResultList().stream().findFirst();
    }

    public List<Rental> findAll() {
        TypedQuery<Rental> query = em.createQuery(
            "SELECT r FROM Rentals r",
            Rental.class
        );
        return query.getResultList();
    }
    
}
