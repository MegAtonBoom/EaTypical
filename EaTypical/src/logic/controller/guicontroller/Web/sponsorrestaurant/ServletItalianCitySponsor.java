package logic.controller.guicontroller.Web.sponsorrestaurant;

//import logic.engineeringclasses.others.SizedStack;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletItalianCitySponsor
 */

@WebServlet("/ServletItalianCitySponsor")
public class ServletItalianCitySponsor extends HttpServlet {
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
    	String s5 = request.getParameter("Continue");
    	
    	String s6 = request.getParameter("Aosta");
    	String s7 = request.getParameter("Torino");
    	String s8 = request.getParameter("Genova");
    	String s9 = request.getParameter("Milano");
    	String s10 = request.getParameter("Trento");
    	String s11 = request.getParameter("Venezia");
    	String s12 = request.getParameter("Trieste");
    	String s13 = request.getParameter("Bologna");
    	String s14 = request.getParameter("Firenze");
    	String s15 = request.getParameter("Ancona");
    	String s16 = request.getParameter("Perugia");
    	String s17 = request.getParameter("Roma");
    	String s18 = request.getParameter("L'Aquila");
    	String s19 = request.getParameter("Campobasso");
    	String s20 = request.getParameter("Napoli");
    	String s21 = request.getParameter("Potenza");
    	String s22 = request.getParameter("Bari");
    	String s23 = request.getParameter("Catanzaro");
    	String s24 = request.getParameter("Palermo");
    	String s25 = request.getParameter("Cagliari");
    	
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
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s7!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s8!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s9!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s10!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s11!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s12!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s13!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s14!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s15!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s16!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s17!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s18!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s19!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s20!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s21!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s22!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s23!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s24!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}
    	if(s25!=null) {
    		request.getRequestDispatcher("ItalianCitySponsorView.jsp").forward(request, response);
    	}    	
	}

}
