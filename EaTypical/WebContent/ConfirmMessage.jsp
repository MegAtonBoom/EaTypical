<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%request.setAttribute("piatto",request.getAttribute("piatto")); %>
 
 <%@page import="logic.engineeringclasses.others.SizedStack" %>

<%
	if(request.getParameter("home3")!=null) {
		SizedStack.getSizedStack(true).clearStack();
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu3")!=null) {
		SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant3")!=null) {
		SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("Discard")!=null) {
		//SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("back3")!=null) {		
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%		
	}
%>


<%
	if(request.getParameter("Done")!=null) {
		//SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("keep")!=null) {	
		//SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%		
	}
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home page tourist</title>
	<link rel="stylesheet" type="text/css" href="confirmMessage.css">
	
</head>

<body>

<div class="container">

	
	<form action="ConfirmMessage.jsp" name="myform" method="get">
	
		<input id="home" type="submit" name="home3" value="Home">
		<input id="manageMenu" type="submit" name="manageMenu3" value="Manage Menu">
		<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant3" value="Sponsor Restaurant">
		<input id="back" type="submit" name="back3" value="Back">
			
		<img id="fotoUtente" src="utente.jpg"/>
		
		<label id="nomeUtente">nomeUtente</label>
<%
String ristorante = (String)request.getParameter("ristorante");
String ricetta = (String)request.getParameter("ricetta");
String piatto = (String)request.getParameter("piatto");
String vegano=(String)request.getParameter("vegano");
String celiaco=(String)request.getParameter("celiaco");
String prezzo=(String)request.getParameter("prezzo");
out.print(ristorante+piatto+ricetta+prezzo+vegano+celiaco);
%>
		<div id="informazioni">
			<p>What would you like to do?</p>
		</div>
		
		<div id="doneBut">
			<input id="Done" class="button" type="submit" name="Done" value="Done">
		</div>
		<div id="DiscardBut">
			<input id="Discard" class="button" type="submit" name="Discard" value="Discard All The Changes">
		</div>
		<div id="keepBut">
			<input id="keep" class="button" type="submit" name="keep" value="Keep Managing Menu">
		</div>
		
		
	</form>
</div>
</body>
</html>