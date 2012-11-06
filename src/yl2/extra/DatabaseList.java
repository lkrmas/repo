package yl2.extra;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yl2.data.Guard;
import yl2.service.GuardService;

@WebServlet("/yl2/all")
public class DatabaseList extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        GuardService gServ = new GuardService();
        List<Guard> gs = gServ.retrieveGuards();
        for (Guard g : gs)
            out.println("ID: " + g.getId() + "; Name: " + g.getName() + "; Age: " + g.getAge() + ".");
        out.println("END OF LIST");
    }

}
