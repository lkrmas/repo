package main.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.format.annotation.DateTimeFormat;


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
    	if (em.find(Guard.class,guard.getId())!=null){
    		em.merge(guard);	
    	} else {
    		em.persist(guard);
    	}
    }

    public void terminate() {
        em.getTransaction().commit();
        em.close();
    }
    
    public void modifyGuard(Guard in) {
        Guard in1 = em.find(Guard.class,in.getId());
        in1=in;
        em.merge(in1);
    }
    
    public Guard getGuard(int id) {
        return em.find(Guard.class,id);
    }
    
    public void deleteGuard(int id) {
        Guard in=em.find(Guard.class,id);
        em.remove(in);
        
    }
    


}
