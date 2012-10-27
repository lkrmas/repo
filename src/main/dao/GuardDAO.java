package main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import main.data.Guard;

public class GuardDAO {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
	private EntityManager em;

	public GuardDAO() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

    public List<Guard> retrieveAllGuards() {
		TypedQuery<Guard> q = em.createNamedQuery("Guard.selectAll", Guard.class);
		List<Guard> guards = q.getResultList();
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
