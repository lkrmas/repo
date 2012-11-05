package yl2;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yl2.service.GuardService;


@WebServlet("/yl2/updateGuard")
public class UpdateGuard extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		GuardService gServ = new GuardService();
		String name=request.getParameter("name");
		Integer age=null;
		Integer id=null;
		try {
		 age=Integer.parseInt(request.getParameter("age"));
		 
		} catch (NumberFormatException e){
			age=null;
		}
		try {
			id=Integer.parseInt(request.getParameter("id"));	
			gServ.updateGuard(id,name,age);
			out.println("ID: " + id + "; Name: " + name + "; Age: " + age + ".");
		}catch (NumberFormatException e){
			out.println("Parameter ID must be an integer!");
		}
	}

}