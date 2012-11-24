package main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.data.Incident;
import main.dao.IncidentDAO;

@Service
public class IncidentService {

    public List<Incident> retrieveIncidents()
    {
        IncidentDAO dao = new IncidentDAO();
        List<Incident> is = dao.retrieveAllIncidents();
        dao.terminate();
        return is;
    }

    public List<Incident> addIncident(Incident in)
    {
        IncidentDAO dao = new IncidentDAO();
        dao.insertIncident(in);
        List<Incident> is = dao.retrieveAllIncidents();
        dao.terminate();
        return is;
    }

}
