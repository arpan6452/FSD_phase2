package flyaway;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "This is the Hello World Servlet. Used to test the application.", urlPatterns = {
		"/FlightDetails" })
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public FlightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String flightName = request.getParameter("flightName");
			String start = request.getParameter("start");
			String duration = request.getParameter("duration");
			String destination = request.getParameter("destination");
			String price = request.getParameter("price");
		} catch (Exception e) {
		}
		response.getWriter().println(flightName + start + duration + destination + price);
	}

}
