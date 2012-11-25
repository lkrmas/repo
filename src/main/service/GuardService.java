package main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.data.Guard;
import main.dao.GuardDAO;

@Service
public class GuardService {

    public List<Guard> retrieveGuards()
    {
    	GuardDAO dao = new GuardDAO();
        List<Guard> is = dao.retrieveAllGuards();
        dao.terminate();
        return is;
    }

    public List<Guard> addGuard(Guard in)
    {
    	GuardDAO dao = new GuardDAO();
        dao.insertGuard(in);
        List<Guard> is = dao.retrieveAllGuards();
        dao.terminate();
        return is;
    }
    
    public void modifyGuard(Guard in)
    {
    	GuardDAO dao = new GuardDAO();
        dao.modifyGuard(in);
        List<Guard> is = dao.retrieveAllGuards();
        dao.terminate();
    }
    
    public void deleteGuard(int id)
    {
    	GuardDAO dao = new GuardDAO();
        dao.deleteGuard(id);
        dao.terminate();

    }
    
    public Guard getGuard(int id)
    {
    	GuardDAO dao = new GuardDAO();
    	Guard in=dao.getGuard(id);
        dao.terminate();
        return in;
    }

}
