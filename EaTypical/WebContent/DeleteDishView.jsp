<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>

<%
	if(request.getParameter("home7")!=null) {
		//SizedStack.getSizedStack(true).clearStack();
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu7")!=null) {
		//SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant7")!=null) {
		//SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("delete2")!=null) {
		//SizedStack.getSizedStack(true).push("ConfirmMessage.jsp");
		%>
		<jsp:forward page="ConfirmMessage.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("back7")!=null) {		
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%		
	}
%>    


<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="DeleteDish.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<form action="DeleteDishView.jsp" method="get">
		
			<input id="home" type="submit" name="home7" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu7" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant7" value="Sponsor Restaurant">
			<input id="back" type="submit" name="back7" value="Back">
			
			
			
			<img id="fotoUtente" alt="image" src="utente.jpg"/>
			
			<label id="n">NomeUtente</label>
			
			
			
			<div id="informazioni">
				<p>Select the dish you would like to delete:</p>
			</div>
			
			<div id="containerSelect">
				<select id="select">
					<option>opzione 1</option>
					<option>opzione 2</option>
				</select>
			</div>	
			
			<div id="cont">
				<select id="select">
					<option>opzione 1</option>
					<option>opzione 2</option>
				</select>
			</div>	
			
			<input id="delete" name="delete2" value="DELETE" type="submit">
			
			
			
			
			
		</form>
	</div>
</body>
</html>