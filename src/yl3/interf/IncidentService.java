package yl3.interf;

import java.util.List;

import main.data.Incident;

public interface IncidentService {

    public List<Incident> retrieveIncidents();
    public List<Incident> getUnresolvedIncidents();
    public List<Incident> addIncident(Incident in);

}