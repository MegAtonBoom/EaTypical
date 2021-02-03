<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>
<%@page import="logic.engineeringclasses.others.Session" %>
<%@page import="logic.engineeringclasses.bean.scheduletrip.BeanOutputSchedule" %>

<%
	Session bs = (Session)session.getAttribute("session");
	String city = (String)session.getAttribute("city");
	BeanOutputSchedule[] scheduling = (BeanOutputSchedule[])session.getAttribute("scheduling");
	String errorString = "";
%>

<%    	
    	if(request.getParameter("Home See")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip See")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant See")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("Back See")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%    		
    	}
    	if(request.getParameter("Delete Scheduling")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="SchedulingView.jsp"/>
<%
    	}
%>
    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>Your scheduling</title>
	<link rel="stylesheet" type="text/css" href="SeeTripCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="SeeTripView.jsp" name="myform" method="get">
		<input id="home" type="submit" name="Home See" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip See" value="Schedule Trip">
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant See" value="Choose Restaurant">
		<input id="back" type="submit" name="Back See" value="Back">
		<img id="fotoUtente" src="utente.jpg" alt="Photo"/>
		<label id="nomeUtente"><%=bs.getUser().getUsername()%></label>
		<label id="citta"><%=city%></label>
		<label id="errorMsg"><%=errorString%></label>
		
		<input id="deleteScheduling" type="submit" name="Delete Scheduling" value="Delete Scheduling">
	</form>
</div>
</body>
</html>