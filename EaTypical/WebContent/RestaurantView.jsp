<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.ArrayList"%>
	 
<%@page import="java.util.List" %>
 
<%@page import="logic.controller.applicationcontroller.ChooseRestaurant"%>
<%@page import="logic.engineeringclasses.bean.chooserestaurant.ChooseRestaurantBean"%>
<%@page import="logic.engineeringclasses.dao.FavouriteRestDAO"%>
 <%@page import="logic.engineeringclasses.others.Session" %>
 <%Session bs;
 bs=(Session)session.getAttribute("session"); %>
<%
	 
	 boolean genericError=false;
	 boolean loginError=false;
	 boolean notSelectedRest=false;
	 boolean celiacs=false;
	 boolean vegans=false;
	 String name;
	 List<ArrayList<String>> allRestaurants=new ArrayList<ArrayList<String>>();
	 List<ArrayList<String>> celiacRestaurants=new ArrayList<ArrayList<String>>();
	 List<ArrayList<String>> veganRestaurants=new ArrayList<ArrayList<String>>();
	 List<ArrayList<String>> bothRestaurants=new ArrayList<ArrayList<String>>();
	 String city=(String)session.getAttribute("city");
	 String addr="";
	 String vote="";
	 
	 ChooseRestaurant cr=new ChooseRestaurant();
		try {
			ChooseRestaurantBean cb=cr.getallRestaurants(city);
			allRestaurants=cb.getAllRestaurants();
			celiacRestaurants=cb.getCeliacRestaurants();
			veganRestaurants=cb.getVeganRestaurants();
			bothRestaurants=cb.getBothRestaurants();
		}
		catch(Exception e)
		{
			genericError=true;
		}
		
		
		
		celiacs= (request.getParameterValues("celFilter")!=null&&request.getParameterValues("celFilter")[0].equals("forCeliacs"));
		vegans= (request.getParameterValues("vegFilter")!=null&&request.getParameterValues("vegFilter")[0].equals("forVegans"));
%>   
<%    	
    	if(request.getParameter("Home restv")!=null) {
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant restv")!=null) {
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip restv")!=null) {
    		if(bs!=null&&bs.getUser()!=null){
    			
   		
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	else{
    		loginError=true;
    	    }
    	}
    		
    		
    		
    	if(request.getParameter("Back restv")!=null) {

%>
				<jsp:forward page="HomePageTouristView.jsp"/>
<%
			
    	}
    	if(request.getParameter("Update Rest val")!=null) {
    		celiacs= (request.getParameterValues("celFilter")!=null&&request.getParameterValues("celFilter")[0].equals("forCeliacs"));
    		vegans= (request.getParameterValues("vegFilter")!=null&&request.getParameterValues("vegFilter")[0].equals("forVegans"));    	   					
    	}
    	
    	if(request.getParameter("Update info val")!=null) {
    			   String rest=request.getParameter("restScroll");
    		   	   if(rest!=null){
    		   		  for(ArrayList<String> restName : allRestaurants){
    		   			  if(restName.get(0).equals(rest)){
    		   				  addr=restName.get(1);
    		   				  vote=restName.get(2);
    		   			  }
    		   			 
    		   		  }
    		   	   }
    	}
    	
    	if(request.getParameter("save Restaurant into Favourites restv")!=null) {
    		if(bs!=null||bs.getUser()==null){
				loginError=true;}
			else if(request.getParameter("restScroll")==null)
			{
				notSelectedRest=true;
			}
			else{
				try{
				String user=bs.getUser().getUsername();
				String restaurant=request.getParameter("restScroll");
				FavouriteRestDAO.insertFavourite(restaurant,user);
				}
				catch(Exception e)
				{
					genericError=true;
				}
    		%>
    		<%
			}
%>
			
<%
    	}
    	if(request.getParameter("Read Reviews restv")!=null) {
    		if(request.getParameter("restScroll")==null)
			{
				notSelectedRest=true;
			}
			else{
				String rest=request.getParameter("restScroll");
				session.setAttribute("restaurant",rest);			
    		%>
    			<jsp:forward page="ReadReviewsView.jsp"/>
    		<%
    					
    	    }
    	}
    	
    	
    	
    	if(request.getParameter("Write Review restv")!=null) {
			if(bs==null||bs.getUser()==null){
				loginError=true;}
			else if(request.getParameter("restScroll")==null)
			{
				notSelectedRest=true;
			}
			else{
				String rest=request.getParameter("restScroll");
				session.setAttribute("restaurant",rest);			
    		%>
    						<jsp:forward page="WriteReviewView.jsp"/>
    		<%
			}
    					
    	}
    	
    	
    	
    	
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Restaurant</title>
<link rel="stylesheet" type="text/css" href="RestaurantViewCSS.css">
</head>
<body>
	<div class="container">
		<form action="RestaurantView.jsp" class="button" name="myform" method="get">
			<input id="home" class="button" type="submit" name="Home restv" value="Home">
			<input id="scheduleTrip" class="button" type="submit" name="Schedule Trip restv" value="Schedule Trip">
			<input id="chooseRestaurant" class="button" type="submit" name="Choose Restaurant restv" value="Choose Restaurant">
			<input id="back" class="button" type="submit" name="Back restv" value="Back">
			<input id="saveFavourite" class="button" type="submit" name="Save Restaurant into Favourite restv" value="Save Restaurant into Favourites">
			<input id="readReviews" class="button" type="submit" name="Read Reviews restv" value="Read Reviews">
			<input id="writeReview" class="button" type="submit" name="Write Review restv" value="Write Review">
			<img id="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente"><%if(bs!=null&&bs.getUser()!=null){
					%>=bs.getUser().getUsername()<%
		}
		else{
		%>not logged<%		}	%></label>
			
			<input type="checkbox" id="celFilter" name="celFilter" value="forCeliacs">
			<input type="checkbox" id="vegFilter" name="vegFilter" value="forVegans">
			
			<label id="fcel">for Celiacs</label>
			<label id="fveg">for Vegans</label>
			
			<label id="rest">Restaurant Address</label>
			<label id="avg">Average Vote</label>
			
			<input id="updateRest" class="button" type="submit" name="Update Rest val" value="update restaurants">
			<input id="updateInfo" class="button" type="submit" name="Update info val" value="update info">
			
			<% if(genericError){
				%><label id="genericError">Please try again!</label><%
				
			}
			%>
			
			<% if(notSelectedRest){
				%><label id="notSelectedRest">You have to choose a restaurant!!</label><%				
			}
			%>
			
			<% if(loginError){
				%><label id="loginError">You must be logged to use this function!</label><%				
			}
			%>
			
			<select id="restaurantsScroll" name="restScroll">
			
			<% if(celiacs&&vegans)
				{
					for(ArrayList<String> rest: bothRestaurants)
					{
						name=rest.get(0);
						%>
				        <option value="<%=name %>"><%=name %></option>
				        <%				        
					}								
				}
			else if(celiacs&&!vegans)
			{
				for(ArrayList<String> rest: celiacRestaurants)
				{
					name=rest.get(0);
					%>
			        <option value="<%=name %>"><%=name %></option>
			        <%				        
				}								
			}
			else if(!celiacs&&vegans)
			{
				for(ArrayList<String> rest: veganRestaurants)
				{
					name=rest.get(0);
					%>
			        <option value="<%=name %>"><%=name %></option>
			        <%				        
				}								
			}
			else
			{
				for(ArrayList<String> rest: allRestaurants)
				{
					name=rest.get(0);
					%>
			        <option value="<%=name %>"><%=name %></option>
			        <%				        
				}								
			}
				
				
%>
			
			</select>
			
			<input type="text" id="addrtx" name="addrtx"  readonly value=<%=addr %>>
			<input type="text" id="votetx" name="votetx" readonly  value=<%=vote %>>
			
		</form>
	</div>

</body>
</html>