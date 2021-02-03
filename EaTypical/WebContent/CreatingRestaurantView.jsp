<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>
<%@page import="logic.engineeringclasses.others.Session" %>
<%@page import="logic.engineeringclasses.exceptions.EmptyFieldException" %>
<%@page import="logic.engineeringclasses.bean.sponsorrestaurant.BeanNewRestaurant" %>

<%
	Session bs = (Session)session.getAttribute("session");
	String errorString;
	if(session.getAttribute("errorStr")==null) 
	{
	errorString="";
	}
	else{
	errorString=(String)session.getAttribute("errorStr");
	}
%>

<%    	
    	if(request.getParameter("Home SR1")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="HomePageOwner.jsp"/>
<%
    	}
    	if(request.getParameter("Manage Menu SR1")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="RestaurantMenuview.jsp"/>
<%
    	}
    	if(request.getParameter("Back SR1")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="HomePageOwner.jsp"/>
<%
    	}
    	if(request.getParameter("Set Opening Hours")!=null) {
    		try {
    			String name = request.getParameter("Restaurant Name");
    			String address = request.getParameter("Restaurant Address");
    			String city = request.getParameter("Scroll");
    			
    			if(name.equals("") || address.equals("") || city.equals("")) {
    				throw new EmptyFieldException("You need to insert name, address and city of your restaurant before setting the opening hours");
    			}
    			
    			BeanNewRestaurant bnr = new BeanNewRestaurant(name, address, city, bs.getUser().getUsername());
    			
    			session.setAttribute("bean", bnr);
    			session.setAttribute("session", bs);
%>
				<jsp:forward page="SetOpeningHoursView.jsp"/>
<%
    		}
    		catch(EmptyFieldException e) {
    			errorString = "You need to insert name, address and city of your restaurant before setting the opening hours";
    		}
    		
    	}
%>    
    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>Restaurant creation</title>
	<link rel="stylesheet" type="text/css" href="CreatingRestaurantCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="CreatingRestaurantView" name="myform" method="get">
		<input id="home" type="submit" name="Home SR1" value="Home">
		<input id="sponsorRestaurant" type="submit" name="Sponsor Restaurant SR1" value="Sponsor Restaurant" disabled>
		<input id="manageMenu" type="submit" name="Manage Menu SR1" value="Manage Menu">
		<input id="back" type="submit" name="Back SR1" value="Back">
		<img id="fotoUtente" src="utente.jpg"/>
		<label id="nomeUtente"><%=bs.getUser().getUsername()%></label>
		<div class="box-1">
			<p>Please, insert name, address and city of your restaurant:</p>
		</div>
		<div class="box-2">
			<p>Click here to set the opening hours:</p>
		</div>
		<input id="restName" class="inputbox" type="text" placeholder="Restaurant name" name="Restaurant Name">
		<input id="restAddress" class="inputbox" type="text" placeholder="Restaurant address" name="Restaurant Address">
		<select id="scrollbar" class="inputbox" name="Scroll">
			<option disabled selected>City</option>
			<option value="AO">Aosta</option>
			<option value="TO">Torino</option>
			<option value="GE">Genova</option>
			<option value="MI">Milano</option>
			<option value="TN">Trento</option>
			<option value="VE">Venezia</option>
			<option value="TR">Trieste</option>
			<option value="BO">Bologna</option>
			<option value="FI">Firenze</option>
			<option value="AN">Ancona</option>
			<option value="PG">Perugia</option>
			<option value="RM">Roma</option>
			<option value="AQ">L'Aquila</option>
			<option value="CB">Campobasso</option>
			<option value="NA">Napoli</option>
			<option value="PZ">Potenza</option>
			<option value="BA">Bari</option>
			<option value="CZ">Catanzaro</option>
			<option value="PA">Palermo</option>
			<option value="CG">Cagliari</option>
		</select>
		<label id="errorMsg"><%=errorString%></label>
		<input id="setOpeningHours" type="submit" name="Set Opening Hours" value="Set Opening Hours">
	</form>
</div>
</body>
</html>