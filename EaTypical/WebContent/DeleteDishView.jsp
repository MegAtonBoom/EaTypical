<%@page import="logic.engineeringclasses.bean.manageMenu.BeanDishWeb"%>
<%@page import="java.util.ArrayList"%>
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
		
		
		String ristorante = request.getParameter("ristorante");
		String piatto = request.getParameter("piatto");
		
		
		
		
		BeanDishWeb beanWebDish = new BeanDishWeb(piatto,ristorante,(String)request.getParameter("ricetta"),false,false,-1,2);
		request.setAttribute("bean", beanWebDish);
		
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
<html lang="en">
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
				<select id="select" name="piatto">
				<%

		ArrayList<String> obs1 = (ArrayList<String>) request.getAttribute("listaPiatti");
		String value1;
		while(!obs1.isEmpty()){
			value1 = obs1.get(0);
			obs1.remove(0);
			%>
			<option><%=value1%></option>
			<%
}
		
%>
				</select>
			</div>	
			
			<div id="cont">
				<select id="select" name="ristorante">
				<%
		
			ArrayList<String> obs2 = (ArrayList<String>)request.getAttribute("listaRistoranti");
			String value2;
			while(!obs2.isEmpty()){
				value2 = obs2.get(0);
				obs2.remove(0);
				%>
				<option><%=value2%></option>
				<%
			}
			
		
%>
				</select>
			</div>	
			
			<input id="delete" name="delete2" value="DELETE" type="submit">
			
			
			
			
			
		</form>
	</div>
</body>
</html>