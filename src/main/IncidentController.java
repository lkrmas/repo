package main;

import java.util.List;

import javax.validation.Valid;

import main.data.Incident;
import main.service.IncidentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/incident")
public class IncidentController {

    @Autowired
    private IncidentService iServ;

    private static final String ENTITY = "incident";
    private static final String LIST = "dataList";
    private static final String FORM = "incidentForm";
    private static final String TABLE = "incidentTable";

    @RequestMapping("/read")
    public ModelAndView read() {
        List<Incident> incidents = iServ.retrieveIncidents();
        return new ModelAndView(TABLE, LIST, incidents);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView(FORM, ENTITY, new Incident());
    }

    @RequestMapping(value = "/addIncident", method = RequestMethod.POST)
    public ModelAndView addIncident(@Valid Incident incident, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView(FORM, ENTITY, incident);
        }
        else {
            List<Incident> incidents = iServ.addIncident(incident);
            return new ModelAndView(TABLE, LIST, incidents);
        }
    }

}
