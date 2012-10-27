package yl1;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dataview")
public class Mediator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<GuardPost> guardPostDAO;

	public ArrayList<GuardPost> getGuardPostDAO() {
		return guardPostDAO;
	}

	public void setGuardPostDAO(ArrayList<GuardPost> guardPostDAO) {
		this.guardPostDAO = guardPostDAO;
	}

	public void init() throws ServletException {
		guardPostDAO = new ArrayList<GuardPost>();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		int count = 0;
		try {
			count = Integer.parseInt(request.getParameter("guardCount"));
			GuardPost guardPost = new GuardPost();
			guardPost.setName(name);
			guardPost.setAddress(address);
			guardPost.setGuardCount(count);
			guardPostDAO.add(guardPost);
			response.sendRedirect("addGuardPost.jsp");
		} catch (NumberFormatException e) {
			response.sendRedirect("addGuardPost.jsp");

		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("dataList", guardPostDAO);
		request.getRequestDispatcher("guardTable.jsp").forward(request,
				response);

	}
}
