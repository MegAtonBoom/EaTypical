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

@WebServlet("/ServletHomePageOwner")
public class ServletHomePageOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String s1 = request.getParameter("manage");
		String s2 = request.getParameter("sponsor");
		String s3 = request.getParameter("logout");
		
		
		if(s1!=null) {
			SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
			request.getRequestDispatcher("RestaurantMenuview.jsp").forward(request, response);
		}
		if(s2!=null) {
			SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
			request.getRequestDispatcher("CreatingRestaurantView.jsp").forward(request, response);
		}
		if(s3!=null) {
			
			request.getRequestDispatcher("HomePageOwner.jsp").forward(request, response);
		}
		
		
	}
	
}