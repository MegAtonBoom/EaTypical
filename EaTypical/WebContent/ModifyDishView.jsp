<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>

<%
	if(request.getParameter("home4")!=null) {
		SizedStack.getSizedStack(true).clearStack();
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu4")!=null) {
		//SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant4")!=null) {
		SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("continue4")!=null) {
		//SizedStack.getSizedStack(true).push("ConfirmMessage.jsp");
		%>
		<jsp:forward page="ConfirmMessage.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("back4")!=null) {		
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%		
	}
%>    
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="modifyDish.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="ModifyDishView.jsp" name="myform" method="get">
		
			<input id="home" type="submit" name="home4" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu4" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant4" value="Sponsor Restaurant">
			<input id="back" type="submit" name="back4" value="Back">
			
			<img id="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente">NomeUtente</label>  
			
			
			
			<div id="informazioni">
				<p>Please, select the dish you would like to modify:</p>							
			</div>
			
			<div id="containerSelect">
				<select id="select">
					<option>opzione 1</option>
					<option>opzione 2</option>
				</select>
			</div>	
			
			<div id="contR">
				<select id="sel">
					<option>opzione 1</option>
					<option>opzione 2</option>
				</select>
			</div>
			
			<div id="price">
				<input type="text" id="priceInput" name="priceInput" >
			</div>
			
			<div>
				<textarea id = "area" rows="15" cols="76">Inserire la nuova ricetta ...</textarea>	
			</div>
			
			<div id="check">
				<input type="checkbox"  id="c1" name="c1" value="Vegan" >
  				<label for="c1" id="l1"> Vegan</label><br>
  				<input type="checkbox" id="c2" name="c2" value="Celiac">
  				<label for="c2" id="l2"> Celiac</label><br>			
			</div>
			
			<div>
				<input type="submit" id="continue" value="CONTINUE" name="continue4">
			</div>
			
		</form>
		
	</div>
</body>
</html>