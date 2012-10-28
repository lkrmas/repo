package main;

import java.io.IOException;
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

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GuardService gServ = new GuardService();
		String name = request.getParameter("name");
		Integer age = null;
		try {
			age = Integer.parseInt(request.getParameter("age"));
		} catch (NumberFormatException e) {
			age = null;
		}
		List<Guard> gs = gServ.retrieveGuardsByNameAge(name, age);
		request.setAttribute("dataList", gs);
		request.getRequestDispatcher("guardTable.jsp").forward(request,
				response);
	}

}