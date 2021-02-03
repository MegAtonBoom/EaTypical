<%@page import="logic.engineeringclasses.exceptions.InvalidDishDelete"%>
<%@page import="logic.engineeringclasses.bean.manageMenu.BeanDeleteDish"%>
<%@page import="logic.engineeringclasses.exceptions.InvalidDishModify"%>
<%@page import="logic.engineeringclasses.exceptions.DishAlreadyExists"%>
<%@page import="logic.controller.applicationcontroller.ManageMenu"%>
<%@page import="logic.engineeringclasses.bean.manageMenu.BeanDishWeb"%>
<%@page import="com.mysql.cj.Session.SessionEventListener"%>
<%@page import="logic.engineeringclasses.bean.manageMenu.BeanAddDish"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

 
 <%@page import="logic.engineeringclasses.others.SizedStack" %>

<%
	if(request.getParameter("home3")!=null) {
		//SizedStack.getSizedStack(true).clearStack();
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu3")!=null) {
		//SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant3")!=null) {
		//SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
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
		ManageMenu m = new ManageMenu();
		BeanDishWeb b = (BeanDishWeb)session.getAttribute("beanrefresh");
		System.out.print(b.getTipoModifica());
		if(b.getTipoModifica() == 0){
			BeanAddDish beanAddDish = new BeanAddDish(b.getPiatto(),b.getRistorante(),b.getContenuto(),b.isVegano(),b.isCeliaco(),b.getPrezzo(),0);
			
			try{
				m.addDish(beanAddDish);
			}catch(DishAlreadyExists e){
				System.out.print("Gia esiste\n");
			}
		}else if(b.getTipoModifica() == 1){
			BeanAddDish beanAddDish = new BeanAddDish(b.getPiatto(),b.getRistorante(),b.getContenuto(),b.isVegano(),b.isCeliaco(),b.getPrezzo(),1);
			System.out.println(b.getPiatto()+b.getContenuto()+b.getRistorante());
			try{
				m.modifyDishes(beanAddDish);
			}catch(InvalidDishModify e2){
				System.out.print("Non esiste\n");
			}
		}else if(b.getTipoModifica() == 2){
			BeanDeleteDish beanDeleteDish = new BeanDeleteDish(b.getRistorante(),b.getPiatto(),2);
			
			try{
				m.deleteDish(beanDeleteDish);
			}catch(InvalidDishDelete e3){
				System.out.println("Non esiste da eliminare");
			}
		}
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
<html lang="en">
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
			
		<img id="fotoUtente" alt="fotoUtente" src="utente.jpg"/>
		
		<label id="nomeUtente">nomeUtente</label>
<%
session.setAttribute("beanrefresh", request.getAttribute("bean"));

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