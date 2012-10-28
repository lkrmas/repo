package main.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import main.dao.GuardDAO;
import main.data.Guard;

public class GuardService {

	public List<Guard> retrieveGuards()
    {
        GuardDAO dao = new GuardDAO();
        List<Guard> gs = dao.retrieveAllGuards();
        dao.terminate();
        return gs;
    }
	
	public List<Guard> retrieveGuardsByNameAge(String name, Integer age)
    {
        GuardDAO dao = new GuardDAO();
        List<Guard> gs = dao.retrieveGuards(name, age);
        dao.terminate();
        return gs;
    }

	public List<Guard> generateGuards(int count)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        List<Guard> gs = new ArrayList<Guard>();
		for (int i = 0; i < count; i ++) {
	        Guard g = new Guard();
	        g.setName("Generated #" + i + " on " + df.format(cal.getTime()));
	        g.setAge(0);
	        gs.add(g);
		}
        GuardDAO dao = new GuardDAO();
        dao.insertGuards(gs);
        dao.terminate();
        return gs;
    }

}
