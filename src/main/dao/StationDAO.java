package main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import main.data.Station;
import manage.Management;

public class StationDAO {

    private EntityManager em;

    public StationDAO() {
        em = Management.NewEntityManager();
        em.getTransaction().begin();
    }

    public List<Station> retrieveAllStations() {
        TypedQuery<Station> q = em.createNamedQuery("Station.selectAll", Station.class);
        List<Station> stations = q.getResultList();
        return stations;
    }

    public void insertStation(Station station) {
    	em.persist(station);
    }

    public void terminate() {
        em.getTransaction().commit();
        em.close();
    }
    
    public void modifyStation(Station in) {
        if (em.find(Station.class,in.getId())!=null){
        	em.merge(in);
        }
    }
    
    public Station getStation(int id) {
        return em.find(Station.class,id);
    }
    
    public void deleteStation(int id) {
        Station in=em.find(Station.class,id);
        em.remove(in);
        
    }
    


}
