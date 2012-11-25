package main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.data.Station;
import main.dao.StationDAO;

@Service
public class StationService {

    public List<Station> retrieveStations()
    {
        StationDAO dao = new StationDAO();
        List<Station> is = dao.retrieveAllStations();
        dao.terminate();
        return is;
    }

    public List<Station> addStation(Station in)
    {
        StationDAO dao = new StationDAO();
        dao.insertStation(in);
        List<Station> is = dao.retrieveAllStations();
        dao.terminate();
        return is;
    }
    
    public List<Station> modifyStation(Station in)
    {
        StationDAO dao = new StationDAO();
        dao.modifyStation(in);
        List<Station> is = dao.retrieveAllStations();
        dao.terminate();
        return is;
    }
    
    public void deleteStation(int id)
    {
        StationDAO dao = new StationDAO();
        dao.deleteStation(id);
        dao.terminate();

    }
    
    public Station getStation(int id)
    {
        StationDAO dao = new StationDAO();
        Station in=dao.getStation(id);
        dao.terminate();
        return in;
    }

}
