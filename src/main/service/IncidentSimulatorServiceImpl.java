package main.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import main.dao.IncidentDAO;
import main.data.Incident;
import main.interf.IncidentService;

@Service
@Scope("singleton") // Kuna singleton skoop on default, pole see siin tingimata vajalik, aga kuna nii oli kirjas, siis on see ka spetsiifiliselt lisatud.
public class IncidentSimulatorServiceImpl implements IncidentService {

    public List<Incident> retrieveIncidents()
    {
        IncidentDAO dao = new IncidentDAO();
        List<Incident> is = dao.retrieveAllIncidents();
        dao.terminate();
        return is;
    }

    public List<Incident> getUnresolvedIncidents()
    {
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        Calendar cal = Calendar.getInstance();
        IncidentDAO dao = new IncidentDAO();
        List<Incident> is = new ArrayList<Incident>();
        Random rGen = new Random();
        int count = rGen.nextInt(10) + 1;
        for (int k = 0; k < count; k ++) {
            Incident i = new Incident();
            i.setOpen(new Date());
            i.setClose(new Date());
            i.setLocation("L" + (count - k));
            i.setDescription("#" + (k+1) + " " + df.format(cal.getTime()));
            i.setInvolvedGuardCount(k + 1);
            i.setStatus("S" + count);
            is.add(i);
        }
        dao.insertIncidents(is);
        dao.terminate();
        return is;
    }

    public List<Incident> addIncident(Incident in)
    {
        IncidentDAO dao = new IncidentDAO();
        List<Incident> is = new ArrayList<Incident>();
        is.add(in);
        dao.insertIncidents(is);
        dao.terminate();
        return is;
    }

}
