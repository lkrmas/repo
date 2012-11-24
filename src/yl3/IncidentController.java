package yl3;

import java.util.List;

import main.data.Incident;
import yl3.interf.IncidentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("yl3IncidentController")
@RequestMapping("/yl3")
public class IncidentController {

    @Autowired
    private IncidentService iServ;

    @RequestMapping("/incident/all")
    public ModelAndView retrieve() {
        List<Incident> incidents = iServ.retrieveIncidents();
        return new ModelAndView("yl3/incidentTable", "dataList", incidents);
    }

    @RequestMapping("/incident/listAll")
    public ModelAndView generate() {
        List<Incident> incidents = iServ.getUnresolvedIncidents();
        return new ModelAndView("yl3/incidentTable", "dataList", incidents);
    }

    @RequestMapping(value = "/incident/reportIncident", method = RequestMethod.GET)
    public ModelAndView incident() {
        return new ModelAndView("yl3/incidentForm", "incident", new Incident());
    }

    @RequestMapping(value = "/incident/addIncident", method = RequestMethod.POST)
    public ModelAndView addIncident(@ModelAttribute("SpringWeb") Incident incident, ModelMap model) {
        List<Incident> incidents = iServ.addIncident(incident);
        return new ModelAndView("yl3/incidentTable", "dataList", incidents);
    }

}