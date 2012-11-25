package main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import main.data.Guard;
import manage.Management;

public class GuardDAO {

    private EntityManager em;

    public GuardDAO() {
        em = Management.NewEntityManager();
        em.getTransaction().begin();
    }

    public List<Guard> retrieveAllGuards() {
        TypedQuery<Guard> q = em.createNamedQuery("Guard.selectAll", Guard.class);
        List<Guard> guards = q.getResultList();
        return guards;
    }

    public void insertGuard(Guard guard) {
    	em.persist(guard);

    }

    public void terminate() {
        em.getTransaction().commit();
        em.close();
    }
    
    public void modifyGuard(Guard guard) {
        if (em.find(Guard.class,guard.getId())!=null){
        	em.merge(guard);
        }
    }
    
    public Guard getGuard(int id) {
        return em.find(Guard.class,id);
    }
    
    public void deleteGuard(int id) {
        Guard in=em.find(Guard.class,id);
        em.remove(in);
        
    }
    


}
