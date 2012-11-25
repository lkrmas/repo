package main.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.format.annotation.DateTimeFormat;

import main.data.Guard;
import main.data.Incident;
import manage.Management;

public class IncidentDAO {

    private EntityManager em;

    public IncidentDAO() {
        em = Management.NewEntityManager();
        em.getTransaction().begin();
    }

    public List<Incident> retrieveAllIncidents() {
        TypedQuery<Incident> q = em.createNamedQuery("Incident.selectAll", Incident.class);
        List<Incident> incidents = q.getResultList();
        return incidents;
    }

    public void insertIncident(Incident incident) {
    	em.persist(incident);
    }

    public void terminate() {
        em.getTransaction().commit();
        em.close();
    }
    
    public void modifyIncident(Incident in) {
        if (em.find(Incident.class,in.getId())!=null){
        	em.merge(in);
        }
    }
    
    public Incident getIncident(int id) {
        return em.find(Incident.class,id);
    }
    
    public void deleteIncident(int id) {
        Incident in=em.find(Incident.class,id);
        em.remove(in);
        
    }
    


}
