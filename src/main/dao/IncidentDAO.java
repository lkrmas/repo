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
    	if (em.find(Incident.class,incident.getId())!=null){
    		em.merge(incident);	
    	} else {
    		em.persist(incident);
    	}
    }

    public void terminate() {
        em.getTransaction().commit();
        em.close();
    }
    
    public void modifyIncident(Incident in) {
        /*private Date open;
        @DateTimeFormat(pattern="dd.MM.yyyy")
        private Date close;
        private String location;
        private String description;
        private int involvedGuardCount;
        private String status;*/
        Incident in1 = em.find(Incident.class,in.getId());
        in1=in;
        em.merge(in1);
    }
    
    public Incident getIncident(int id) {
        return em.find(Incident.class,id);
    }
    
    public void deleteIncident(int id) {
        Incident in=em.find(Incident.class,id);
        em.remove(in);
        
    }
    


}
