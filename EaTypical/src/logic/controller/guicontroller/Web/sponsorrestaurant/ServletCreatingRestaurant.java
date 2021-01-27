package logic.controller.guicontroller.Web.sponsorrestaurant;

//import logic.engineeringclasses.others.SizedStack;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCreatingRestaurant
 */

@WebServlet("/ServletCreatingRestaurant")
public class ServletCreatingRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String s1 = request.getParameter("Home");
    	String s2 = request.getParameter("Manage Menu");
    	String s3 = request.getParameter("Sponsor Restaurant");
    	String s4 = request.getParameter("Back");
    	String s5 = request.getParameter("Add Dish");
    	String s6 = request.getParameter("Done");
    	
    	if(s1!=null) {
    		//SizedStack.getSizedStack(true).push("HomePageTouristView.jsp");
    		//request.getRequestDispatcher("HomePageTouristView.jsp").forward(request, response);
    	}
    	if(s2!=null) {
    		//SizedStack.getSizedStack(true).push("ItalianViewCity.jsp");
    		//request.getRequestDispatcher("ItalianViewCity.jsp").forward(request, response);
    	}
    	if(s3!=null) {
    		//System.out.println("To do - Choose Restaurant");
    		//request.getRequestDispatcher("ItalianViewCity.jsp").forward(request, response);
    	}
    	if(s4!=null) {
    		//String page = SizedStack.getSizedStack(true).pop();
    		//request.getRequestDispatcher(page).forward(request, response);
    	}
    	if(s5!=null) {
    		//SizedStack.getSizedStack(true).push("TripSettingsView.jsp");
    		//request.getRequestDispatcher("TripSettingsView.jsp").forward(request, response);
    	}
    	
    	if(s6!=null) {
    		// To do
    	}
    	
	}

}
