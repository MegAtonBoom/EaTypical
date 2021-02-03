<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>
<%@page import="logic.engineeringclasses.others.Session" %>
<%@page import="java.text.ParseException" %>
<%@page import="logic.engineeringclasses.others.BeanConverter" %>

<%
Session bs;
if( session.getAttribute("session")==null) 
{
bs=new Session(true);
}
else{
bs=(Session)session.getAttribute("session");
} %>


<%    	
    	if(request.getParameter("Logout")!=null) {   		
    		session.setAttribute("session", bs);
%>
			
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
		if(request.getParameter("See Notifications")!=null) {
			session.setAttribute("session", bs);
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
		}
    	if(request.getParameter("Schedule Trip HT")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant HT")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("See Your Favourite Restaurants")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("See Your Trip")!=null) {
    		try {
    			BeanConverter converter = new BeanConverter();
    			
    			session.setAttribute("city", converter.getCityFromScheduling(bs.getUser()));
    			session.setAttribute("scheduling", converter.convertScheduling(bs.getUser()));
    			session.setAttribute("session", bs);
%>
				<jsp:forward page="SeeTripView.jsp"/>
<%
    		}
    		catch(ParseException e) {
    			// To do
    				e.printStackTrace();
    		}
    	}
%>    
    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>Home page tourist</title>
	<link rel="stylesheet" type="text/css" href="HomePageTouristCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">

	
	<form action="HomePageTouristView.jsp" name="myform" method="get">
		<img id="fotoUtente" src="utente.jpg" alt="Photo"/>
		<label id="nomeUtente"><%=bs.getUser().getUsername()%></label>
		<div class="box">
			<p>Hi!</p>
		</div>
		<input id="chooseRestaurant" class="button" type="submit" name="Choose Restaurant HT" value="Choose Restaurant">
		<input id="scheduleTrip" class="button" type="submit" name="Schedule Trip HT" value="Schedule Trip">
		<input id="seeFavRestaurants" class="button" type="submit" name="See Your Favourite Restaurants" value="See Your Favourite Restaurants">
		<input id="seeTrip" class="button" type="submit" name="See Your Trip" value="See Your Trip">
		<input id="logout" class="button" type="submit" name="Logout" value="Logout">
		<input id="seeNotifications" class="button" type="submit" name="See Notifications" value="See Notifications">
	</form>
</div>
</body>
</html>