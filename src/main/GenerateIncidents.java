package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.data.Incident;
import main.interf.IncidentService;
import main.service.IncidentSimulatorServiceImpl;

@WebServlet("/gis")
public class GenerateIncidents extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        IncidentService iServ = new IncidentSimulatorServiceImpl();
        List<Incident> is = iServ.getUnresolvedIncidents();
        out.println("GENERATED INCIDENTS");
        for (Incident i : is)
            out.println("ID: " + i.getId()
              + "; O: " + i.getOpen()
              + "; C: " + i.getClose()
              + "; L: " + i.getLocation()
              + "; D: " + i.getDescription()
              + "; I: " + i.getInvolvedGuardCount()
              + "; S: " + i.getStatus()
              + ".");
    }

}
