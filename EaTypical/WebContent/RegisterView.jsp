<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@page import="logic.engineeringclasses.others.Session" %>
<%@page import="logic.engineeringclasses.bean.login.BeanUser" %>
<%@page import="logic.controller.applicationcontroller.Login" %>
<%@page import="logic.model.User" %>
<%@page import="logic.model.Tourist" %>
<%@page import="logic.model.Owner" %>

<%@page import="logic.engineeringclasses.exceptions.DataException" %>
<%@page import="logic.engineeringclasses.exceptions.AlreadyInUseUsernameException" %>

<% 	 
   Session bs;
   bs=(Session)session.getAttribute("session"); 
   boolean notValidUsername=false;
   boolean genericError=false;
   int emptyData=-1; %>
   
   
<%    	
    	if(request.getParameter("Home rg")!=null) {
%> 
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
		if(request.getParameter("Choose Restaurant rg")!=null) {
		%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
		<%
		}
    	if(request.getParameter("Schedule Trip rg")!=null) {
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	
    	if(request.getParameter("Back rg")!=null) {

%>
				<jsp:forward page="HomePageTouristView.jsp"/>
<%			
    	}
    	if(request.getParameter("registerrg")!=null||request.getParameter("registerfbrg")!=null)
    	{
    		try
    		{
	    		String username=request.getParameter("usernametx");
	    		String name=request.getParameter("nametx");
	    		String surname=request.getParameter("surnametx");
	    		String pw=request.getParameter("passtx");
	    		boolean isOwner= (request.getParameterValues("ownercb")!=null&&request.getParameterValues("ownercb")[0].equals("isOwner"));
	    		BeanUser bu=new BeanUser();
	    		bu.setName(name);
	    		bu.setSurname(surname);
	    		bu.setUsername(username);
	    		bu.setPassword(pw);   		
	    		bu.setOwner(isOwner);
	    		Login registerAppCont= new Login();	
	    		registerAppCont.registerMethod(bu);						//try to register
	    		User user;
	    		if(isOwner)
	    		{
	    			user=new Owner(name, surname, null, username, null, null);
	    			
	    		}
	    		else
	    		{
	    			user=new Tourist(name, surname, username, null, null,null);
	    			System.out.println("DragonBall 1");
	    		}			//create the correct user entity
	    		
	    		
	    		bs.setUser(user);
	    		bs.getSizedStack().setFirstPage(isOwner);
	    		bs.setOwner(isOwner);
	    		session.setAttribute("session", bs);
	    		if(isOwner) {
    	      		%> <jsp:forward page="HomePageOwnerView.jsp"/>
    	      		<%   	        	
    	    	}else {
    	    		%> <jsp:forward page="HomePageTouristView.jsp"/>
    	      		<%
    	    	}
    		}
    		catch(DataException de)				//one or more fields are empty
    		{
				emptyData=de.getCode();
    		}
    		catch(AlreadyInUseUsernameException ae)		//the username has already been chosen
    		{
				notValidUsername=true;
    		}
    		catch(Exception e)			//other exception that may occur
    		{
				genericError=true;
    		}
    	}
    	
%>





<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Register</title>
	<link rel="stylesheet" type="text/css" href="RegisterCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<form action="RegisterView.jsp" name="myform" method="get">
		<input id="home" type="submit" name="Home rg" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip rg" value="Schedule Trip">
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant rg" value="Choose Restaurant" disabled>
		<input id="back" type="submit" name="Back rg" value="Back">
		<img id="fotoUtente" src="utente.jpg"/>
		<label id="nomeUtente">nomeUtente</label>
		
				
		<label id="name">Name</label>
		<label id="surname">Surname</label>
		<label id="user">Username</label>			
		<label id="pw">Password</label>	
		
		<%
		if(notValidUsername)
		{
			%><label id="invalidUser">This username is already in use!</label><%
		}
		if(genericError)
		{
			%><label id="genericError">Please try again</label><%
		}
		if(emptyData!=-1)
		{
			%><label id="emptyData">No field can be left empty!</label><%
		}
		
		
		
		
		%>
		
		
		
		
		<input type="checkbox" id="ownercb" name="ownercb" value="isOwner">		
		<label id="owner">I'm a restaurant owner</label>
		
		<input type="text" id="nametx" name="nametx">
		<input type="text" id="surnametx" name="surnametx">
		<input type="text" id="usernametx" name="usernametx">
		<input type="password" id="passtx" name="passtx">
		
		<input id="register" type="submit" name="registerrg" value="Register">
		<input id="registerfb" type="submit" name="registerfbrg" value="Register with facebook">

	</form>
</div>
</body>
</html>