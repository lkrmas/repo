package main;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.data.Guard;
import main.service.GuardService;

@WebServlet("/searchGuard")
public class SearchGuard extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		GuardService gServ = new GuardService();
		String name=request.getParameter("name");
		Integer age=null;
		try {
		 age=Integer.parseInt(request.getParameter("age"));
		} catch (NumberFormatException e){
			age=null;
		}
		List<Guard> gs = gServ.retrieveGuardsByNameAge(name,age);
		//for (Guard g : gs)
		//	out.println("ID: " + g.getId() + "; Name: " + g.getName() + "; Age: " + g.getAge() + ".");
		//out.println("END OF LIST");
		request.setAttribute("dataList", gs);
		request.getRequestDispatcher("guardTable.jsp").forward(request, response);
	}

}