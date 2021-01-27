package logic.controller.guicontroller.Web;

import logic.engineeringclasses.others.SizedStack;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletHomePageTourist
 */

@WebServlet("/ServletHomePageTourist")
public class ServletHomePageTourist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String s1 = request.getParameter("Choose Restaurant");
		String s2 = request.getParameter("Schedule Trip");
		String s3 = request.getParameter("See Your Favourite Restaurants");
		String s4 = request.getParameter("See Your Trips");
		String s5 = request.getParameter("Logout");
		
		if(s1!=null) {
			System.out.println("To do - Choose Restaurant");
			request.getRequestDispatcher("ItalianViewCity2.jsp").forward(request, response);
		}
		if(s2!=null) {
			SizedStack.getSizedStack(true).push("ItalianViewCity.jsp");
			request.getRequestDispatcher("ItalianViewCity.jsp").forward(request, response);
		}
		if(s3!=null) {
			System.out.println("To do - See Your Favourite Restaurants");
			request.getRequestDispatcher("HomePageTouristView.jsp").forward(request, response);
		}
		if(s4!=null) {
			System.out.println("To do - See Your Trips");
			request.getRequestDispatcher("HomePageTouristView.jsp").forward(request, response);
		}
		if(s5!=null) {
			System.out.println("To do - Logout");
			request.getRequestDispatcher("HomePageTouristView.jsp").forward(request, response);
		}
		
	}
	
}