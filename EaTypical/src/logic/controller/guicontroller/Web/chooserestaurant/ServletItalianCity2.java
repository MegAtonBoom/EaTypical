package logic.controller.guicontroller.Web.chooserestaurant;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.engineeringclasses.others.SizedStack;


@WebServlet("/ServletItalianCity2")
public class ServletItalianCity2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s1 = request.getParameter("Home");
    	String s2 = request.getParameter("Schedule Trip");
    	String s3 = request.getParameter("Choose Restaurant");
    	String s4 = request.getParameter("Back");
    	String s5 = request.getParameter("Continue");
    	
    	if(s1!=null) {
    		SizedStack.getSizedStack(true).push("HomePageTouristView.jsp");
    		request.getRequestDispatcher("HomePageTouristView.jsp").forward(request, response);
    	}
    	if(s2!=null) {
    		SizedStack.getSizedStack(true).push("ItalianViewCity.jsp");
    		request.getRequestDispatcher("ItalianViewCity.jsp").forward(request, response);
    	}
    	if(s3!=null) {
    		SizedStack.getSizedStack(true).push("ItalianViewCity2.jsp");
    		request.getRequestDispatcher("ItalianViewCity2.jsp").forward(request, response);
    	}
    	if(s4!=null) {
    		String page = SizedStack.getSizedStack(true).pop();
    		request.getRequestDispatcher(page).forward(request, response);
    	}
    	if(s5!=null) {
    		System.out.print("test");
    		SizedStack.getSizedStack(true).push("RestaurantView.jsp");
    		request.getRequestDispatcher("RestaurantView.jsp").forward(request, response);
    	}
	}


}
