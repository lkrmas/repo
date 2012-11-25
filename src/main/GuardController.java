package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import main.data.Guard;
import main.service.GuardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/guard")
public class GuardController {

    @Autowired
    private GuardService iServ;

    private static final String ENTITY = "guard";
    private static final String LIST = "dataList";
    private static final String FORM = "guardForm";
    private static final String FORM_MODIFY = "guardFormModify";
    private static final String TABLE = "guardTable";

    @RequestMapping("/read")
    public ModelAndView read() {
        List<Guard> guards = iServ.retrieveGuards();
        return new ModelAndView(TABLE, LIST, guards);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView(FORM, ENTITY, new Guard());
    }

    @RequestMapping(value = "/addGuard", method = RequestMethod.POST)
    public ModelAndView addGuard(@Valid Guard guard, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView(FORM, ENTITY, guard);
        }
        else {
            List<Guard> guards = iServ.addGuard(guard);
            return new ModelAndView(TABLE, LIST, guards);
        }
    }
    
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public ModelAndView modify(HttpSession session, HttpServletRequest request) {
    	Guard gu = new Guard();
    	try {
    		int id=Integer.parseInt(request.getParameter("id"));
    		gu=iServ.getGuard(id);
    		
    				
    	} catch (NumberFormatException e){    		
    	}
        return new ModelAndView(FORM_MODIFY, ENTITY, gu);
    }
    
    @RequestMapping(value = "/modifyGuard", method = RequestMethod.POST)
    public ModelAndView modifyGuard(@Valid Guard guard, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView(FORM, ENTITY, guard);
        }
        else {
            List<Guard> guards = iServ.modifyGuard(guard);
            return new ModelAndView(TABLE, LIST, guards);
        }
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(HttpSession session, HttpServletRequest request) {
    	try {
    		int id=Integer.parseInt(request.getParameter("id"));
    		iServ.deleteGuard(id);
    				
    	} catch (NumberFormatException e){    		
    	}
        List<Guard> guards = iServ.retrieveGuards();
        return new ModelAndView(TABLE, LIST, guards);
    }

}
