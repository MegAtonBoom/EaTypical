package logic.controller.guicontroller.Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import logic.engineeringclasses.others.SizedStack;

public class ServletAddDishView extends HttpServlet{

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
		String b5 = req.getParameter("continue");
		
		//leggo il ristorante in cui si andrà ad aggiungere il piatto
		String ristorante = req.getParameter("ristorante");
		//leggo il piatto da aggiunger
		String piatto = req.getParameter("piatto");
		//restituisce null se non ha cliccato, altrimenti restituisce il nome della checkbox
		//vedo se è un piatto per vegani
		String vegano = req.getParameter("c1");
		//restituisce null se non ha cliccato, altrimenti restituisce il nome della checkbox
		//vedo se è un piatto per celiaci
		String celiaco = req.getParameter("c2");
		//leggo la ricetta del piatto che vado ad aggiungere
		String ricetta = req.getParameter("ricetta");
		//leggo il prezzo del piatto che vado ad aggiungere
		String prezzo = req.getParameter("prezzo");
		
		
		//System.out.println(ristorante + piatto + vegano + celiaco + ricetta + prezzo);
		
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
		if(b5!=null) {
			
			
			SizedStack.getSizedStack(true).push("ConfirmMessage.jsp");
			//req.getRequestDispatcher("ConfirmMessage.jsp").forward(req, resp);
			resp.sendRedirect("ConfirmMessage.jsp?ristorante="+ristorante+"&ricetta="+ricetta+"&vegano="+vegano+"&celiaco="+celiaco+"&piatto="+piatto+"&prezzo="+prezzo);
			System.out.print("delete");
		}
	}

}


