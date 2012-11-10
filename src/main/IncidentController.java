package main;

import java.util.List;

import main.data.Incident;
import main.interf.IncidentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IncidentController {

    @Autowired
    private IncidentService iServ;

    @RequestMapping("/incident/all")
    public ModelAndView retrieve() {
        List<Incident> incidents = iServ.retrieveIncidents();
        return new ModelAndView("incidentTable", "dataList", incidents);
    }

    @RequestMapping("/incident/listAll")
    public ModelAndView generate() {
        List<Incident> incidents = iServ.getUnresolvedIncidents();
        return new ModelAndView("incidentTable", "dataList", incidents);
    }

}
