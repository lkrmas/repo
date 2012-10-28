package main.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import main.data.Guard;

public class GuardDAO {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("PU");
	private EntityManager em;

	public GuardDAO() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

	public List<Guard> retrieveAllGuards() {
		TypedQuery<Guard> q = em.createNamedQuery("Guard.selectAll",
				Guard.class);
		List<Guard> guards = q.getResultList();
		return guards;
	}

	public List<Guard> retrieveGuards(String name, Integer age) {
		List<Predicate> predicateList = new ArrayList<Predicate>();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Guard> query = cb.createQuery(Guard.class);
		Root<Guard> guard = query.from(Guard.class);
		if (name != null && (!name.isEmpty())) {
			predicateList.add(cb.equal(guard.get("name"), name));
		}
		if (age != null) {
			predicateList.add(cb.equal(guard.get("age"), age));
		}
	    Predicate[] predicates = new Predicate[predicateList.size()];
	    predicateList.toArray(predicates);
	    query.where(predicates);
		List<Guard> guards = em.createQuery(query).getResultList();

		return guards;
	}



	public void insertGuards(List<Guard> guards) {
		for (Guard guard : guards)
			em.persist(guard);
	}

	public void terminate() {
		em.getTransaction().commit();
		em.close();
	}

}
