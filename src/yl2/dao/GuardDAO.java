package yl2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import yl2.data.Guard;

import manage.Management;

public class GuardDAO {

	private EntityManager em;

	public GuardDAO() {
		em = Management.NewEntityManager();
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
	
	public void updateGuard(Integer id, String name, Integer age) {
		Guard g1 = em.find(Guard.class,id);
		if (age != null) {
			g1.setAge(age);
		}
		if (name != null) {
			g1.setName(name);
		}
		em.merge(g1);
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
