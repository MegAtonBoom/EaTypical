<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>

<%
	if(request.getParameter("home2")!=null) {
		SizedStack.getSizedStack(true).clearStack();
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu2")!=null) {
		SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant2")!=null) {
		SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("continue2")!=null) {
		SizedStack.getSizedStack(true).push("ConfirmMessage.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("back2")!=null) {		
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%		
	}
%>    



    
    
<!DOCTYPE html>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="styleAdviceView.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
		<form action="AdviceView.jsp" name="myform" method="get">
		
			<input id="home" type="submit" name="home2" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu2" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant2" value="Sponsor Restaurant">
			<input id="back" type="submit" name="back2" value="Back">
			
			<img id="fotoUtente" alt="foto_utente" src="utente.jpg"/>
			<label id="nomeUtente">NomeUtente</label>  
			
			
			<div>
				<textarea id="area" rows="35" cols="120" readonly><% %></textarea>
			</div>
			
			
			<div>
				<input type="submit" id="continue" value="DONE" name="continue2">
			</div>
			
			
			
		</form>
	</div>
</body>
</html>