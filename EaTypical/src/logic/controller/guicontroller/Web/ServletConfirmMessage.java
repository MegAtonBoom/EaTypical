package logic.controller.guicontroller.Web;
import logic.controller.applicationcontroller.*;
import logic.model.*;
import logic.engineeringclasses.others.SizedStack;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfirmMessage extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String b1 = req.getParameter("home");
		String b2 = req.getParameter("manageMenu");
		String b3 = req.getParameter("sponsorRestaurant");
		String b4 = req.getParameter("back");
		
		String b5 = req.getParameter("Done");
		String b6 = req.getParameter("Discard");
		String b7 = req.getParameter("keep");
		
		String b8 = req.getParameter("piatto")+req.getParameter("prezzo")+req.getParameter("ricetta");
		System.out.println(b8);
		
		if(b1!=null) {
			SizedStack.getSizedStack(true).push("HomePageOwner.jsp");
			req.getRequestDispatcher("HomePageOwner.jsp").forward(req, resp);
			System.out.print("home");
		}
		if(b2!=null) {
			SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
			req.getRequestDispatcher("RestaurantMenuview.jsp").forward(req, resp);
			System.out.print("manageMenu");
		}
		if(b3!=null) {
			SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
			req.getRequestDispatcher("CreatingRestaurantView.jsp").forward(req, resp);
			System.out.print("sponsor");
		}
		if(b4!=null) {
			String page = SizedStack.getSizedStack(true).pop();
			req.getRequestDispatcher(page).forward(req, resp);
			System.out.print("back");
		}
		
		//preme il tasto Done con name="Done"
		if(b5!=null) {
			SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
			
			//implementa collegamento logica applicativa
			req.getRequestDispatcher("NewFile.jsp").forward(req, resp);
			System.out.print("done");
		}
		if(b6!=null) {
			SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
			//implementa collegamento logica applicativa
			req.getRequestDispatcher("RestaurantMenuview.jsp").forward(req, resp);
			System.out.print("discard");
		}
		if(b7!=null) {
			SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
			//implementa collegamento logica applicativa
			req.getRequestDispatcher("RestaurantMenuview.jsp").forward(req, resp);
			System.out.print("keep");
		}
		
	}

}
