package eu.myszojelenie.repository;

import eu.myszojelenie.entity.Offer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class OfferRepository {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public Offer createOffer(Offer offer) {
        em.persist(offer);
        return offer;
    }

    public Optional<Offer> findById(Long id) {
        String statement = "SELECT o FROM Offer o WHERE o.offerId = :id";
        TypedQuery<Offer> query = em.createQuery(statement, Offer.class);
        query.setParameter("id", id);
        List<Offer> results = query.getResultList();
        return results.stream().findFirst();
    }

    public List<Offer> findAll(Boolean withRemoved) {
        String statement = "SELECT o FROM Offer o";
        if(!withRemoved){
            statement += " where o.active = true";
        }
        TypedQuery<Offer> query = em.createQuery(statement, Offer.class);
        return query.getResultList();
    }

}
