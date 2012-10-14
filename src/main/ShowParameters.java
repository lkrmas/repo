package main;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showparameters")
public class ShowParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> params = request.getParameterMap();
		Iterator<String> i = params.keySet().iterator();
		response.setContentType("text/html");
		StringBuffer html= new StringBuffer("<html><head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><title>Parameters</title></head><body><ul>");

		while ( i.hasNext() ) {
		    String key = (String) i.next();
		    String value = ((String[]) params.get( key ))[ 0 ];
		    String out="<li>"+key+": "+value+"</li>";
		    html.append(out);
		}
		html.append("</ul></body></html>");

		response.getOutputStream().write(html.toString().getBytes());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
