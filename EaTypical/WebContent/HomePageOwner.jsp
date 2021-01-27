<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
 <%@page import="logic.engineeringclasses.others.SizedStack" %>

<%

	System.out.println("-----------------------------------------------------------------------------");
	if(request.getParameter("manage6")!=null) {
		
		SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsor6")!=null) {
		SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("logout")!=null) {
		SizedStack.getSizedStack(true).push("HomePageOwner.jsp");
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>



<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home page tourist</title>
	<link rel="stylesheet" type="text/css" href="HomePageOwner.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="HomePageOwner.jsp" name="myform" method="get">
		<img id="fotoUtente" alt="" src="utente.jpg"/>
		<label id="nomeUtente">nomeUtente</label>
		<div class="box">
			<p>Hi!</p>
		</div>
		<input id="Manage" class="button" type="submit" name="manage6" value="Manage Menu">
		<input id="Sponsor" class="button" type="submit" name="sponsor6" value="Sponsor Restaurant">
		
		<input id="logout" class="button" type="submit" name="logout" value="Logout">
	</form>
</div>
</body>
</html>