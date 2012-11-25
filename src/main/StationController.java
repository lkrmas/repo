package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import main.data.Station;
import main.service.StationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationService iServ;

    private static final String ENTITY = "station";
    private static final String LIST = "dataList";
    private static final String FORM = "stationForm";
    private static final String FORM_MODIFY = "stationFormModify";
    private static final String TABLE = "stationTable";

    @RequestMapping("/read")
    public ModelAndView read() {
        List<Station> stations = iServ.retrieveStations();
        return new ModelAndView(TABLE, LIST, stations);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView(FORM, ENTITY, new Station());
    }

    @RequestMapping(value = "/addStation", method = RequestMethod.POST)
    public ModelAndView addStation(@Valid Station station, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView(FORM, ENTITY, station);
        }
        else {
            List<Station> stations = iServ.addStation(station);
            return new ModelAndView(TABLE, LIST, stations);
        }
    }
    
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public ModelAndView modify(HttpSession session, HttpServletRequest request) {
    	Station in = new Station();
    	try {
    		int id=Integer.parseInt(request.getParameter("id"));
    		in=iServ.getStation(id);
    				
    	} catch (NumberFormatException e){    		
    	}
        return new ModelAndView(FORM_MODIFY, ENTITY, in);
    }
    
    @RequestMapping(value = "/modifyStation", method = RequestMethod.POST)
    public ModelAndView modifyStation(@Valid Station station, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView(FORM, ENTITY, station);
        }
        else {
            List<Station> stations = iServ.modifyStation(station);
            return new ModelAndView(TABLE, LIST, stations);
        }
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(HttpSession session, HttpServletRequest request) {
    	try {
    		int id=Integer.parseInt(request.getParameter("id"));
    		iServ.deleteStation(id);
    				
    	} catch (NumberFormatException e){    		
    	}
        List<Station> stations = iServ.retrieveStations();
        return new ModelAndView(TABLE, LIST, stations);
    }

}
