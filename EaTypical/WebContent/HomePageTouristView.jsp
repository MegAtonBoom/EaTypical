<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>

<%    	
    	if(request.getParameter("Logout")!=null) {
    		System.out.println("To do - Logout");
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip HT")!=null) {
    		SizedStack.getSizedStack(true).push("ItalianViewCity.jsp");
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant HT")!=null) {
    		SizedStack.getSizedStack(true).push("ItalianViewCity2.jsp");
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("See Your Favourite Restaurants")!=null) {
    		System.out.println("To do - See Your Favourite Restaurants");
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("See Your Trip")!=null) {
    		System.out.println("To do - See Your Trip");
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
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
		<label id="nomeUtente">nomeUtente</label>
		<div class="box">
			<p>Hi!</p>
		</div>
		<input id="chooseRestaurant" class="button" type="submit" name="Choose Restaurant HT" value="Choose Restaurant">
		<input id="scheduleTrip" class="button" type="submit" name="Schedule Trip HT" value="Schedule Trip">
		<input id="seeFavRestaurants" class="button" type="submit" name="See Your Favourite Restaurants" value="See Your Favourite Restaurants">
		<input id="seeTrip" class="button" type="submit" name="See Your Trip" value="See Your Trip">
		<input id="logout" class="button" type="submit" name="Logout" value="Logout">
	</form>
</div>
</body>
</html>