package yl3.extra;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.data.Incident;
import yl3.interf.IncidentService;
import yl3.service.IncidentSimulatorServiceImpl;

@WebServlet("/yl3/all")
public class DatabaseList extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        IncidentService iServ = new IncidentSimulatorServiceImpl();
        List<Incident> is = iServ.retrieveIncidents();
        for (Incident i : is)
            out.println("ID: " + i.getId()
              + "; O: " + i.getOpen()
              + "; C: " + i.getClose()
              + "; L: " + i.getLocation()
              + "; D: " + i.getDescription()
              + "; I: " + i.getInvolvedGuardCount()
              + "; S: " + i.getStatus()
              + ".");
        out.println("END OF LIST");
    }

}
