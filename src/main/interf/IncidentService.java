package main.interf;

import java.util.List;

import main.data.Incident;

public interface IncidentService {

    public List<Incident> retrieveIncidents();
    public List<Incident> getUnresolvedIncidents();

}
