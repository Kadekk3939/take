package eu.myszojelenie.repository;

import eu.myszojelenie.entity.Company;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class CompanyRepository {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public Company addCompany(Company company) {
        em.persist(company);
        return company;
    }

    public Optional<Company> findById(Long id) {
        String statement = "SELECT c FROM Company c WHERE c.companyId = :id";
        TypedQuery<Company> query = em.createQuery(statement, Company.class);
        query.setParameter("id", id);
        List<Company> results = query.getResultList();
        return results.stream().findFirst();
    }

    public List<Company> findAll() {
        String statement = "SELECT c FROM Company c";
        TypedQuery<Company> query = em.createQuery(statement, Company.class);
        return query.getResultList();
    }





}
