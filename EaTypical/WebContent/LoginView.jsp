<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="logic.engineeringclasses.others.Session" %>
<%@page import="logic.model.User" %>
<%@page import="logic.engineeringclasses.bean.login.BeanUser" %>
<%@page import="logic.controller.applicationcontroller.Login" %>

<%@page import="logic.engineeringclasses.exceptions.DataException" %>
<%@page import="logic.engineeringclasses.exceptions.WrongUsernameOrPasswordException"%>



 <% 	 
   Session bs;
   bs=(Session)session.getAttribute("session"); 
   boolean wrongData=false;
   boolean genericError=false;
   int emptyData=-1; %>
   
   
   
 

<%    	
    	if(request.getParameter("Home lg")!=null) {
%> 
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
		if(request.getParameter("Choose Restaurant lg")!=null) {
		%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
		<%
		}
    	if(request.getParameter("Schedule Trip lg")!=null) {
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	
    	if(request.getParameter("Back lg")!=null) {

%>
				<jsp:forward page="HomePageTouristView.jsp"/>
<%			
    	}
    	
    	if(request.getParameter("registerlg")!=null){
    		
%>
   		<jsp:forward page="RegisterView.jsp"/>
<%
	
    	}
    	if(request.getParameter("loginlg")!=null||request.getParameter("loginfblg")!=null){
    		User loggedUser;
    		String username=request.getParameter("usernametx");
    		String pw=request.getParameter("passtx");
    		boolean isOwner= (request.getParameterValues("ownercb")!=null&&request.getParameterValues("ownercb")[0].equals("isOwner"));
    		
    		try
        	{
    	    	BeanUser bu= new BeanUser();
    	    	bu.setUsername(username);
    	    	bu.setOwner(isOwner);
    	    	bu.setPassword(pw);
    	    	Login loginAppContr= new Login();
    	    	loggedUser=loginAppContr.loginMethod(bu);		//try to login   	
    	      	bs.setUser(loggedUser);
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
        	catch(DataException de)		//when username or password fields are empty
        	{
        		emptyData=de.getCode();
        		
        	}
        	catch(WrongUsernameOrPasswordException we)			//when username or password or both are wrong
        	{
        		wrongData=true;
        	}
        	catch (Exception e) {				//other unexpected exception that may occur
        		genericError=true;
        	}

%>
		
		
		
			
<%    		
    	}
    	
%>




<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="LoginCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
	<form action="LoginView.jsp" name="myform" method="get">
		<input id="home" type="submit" name="Home lg" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip lg" value="Schedule Trip">
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant lg" value="Choose Restaurant" disabled>
		<input id="back" type="submit" name="Back lg" value="Back">
		<img id="fotoUtente" src="utente.jpg"/>
		<label id="nomeUtente"><%if(bs!=null&&bs.getUser()!=null){
					%>=bs.getUser().getUsername()<%
		}
		else{
		%>not logged<%		}	%></label>
		
		<% if(wrongData)
			{
			%><label id="wrongData">Wrong username or passord!</label><%
			}
			if(genericError)
			{
				%><label id="genericError">please try again!</label><%
			}
			if(emptyData!=-1)
			{
				%><label id="emptyData">username and password can't be empty!</label><%
			}
			
		%>	
		
		
		<label id="user">Username</label>
		<input type="checkbox" id="ownercb" name="ownercb" value="isOwner">	
		<label id="pw">Password</label>	
		<label id="register">You don't have an account? Click here!</label>		
		<label id="owner">I'm a restaurant owner</label>
		
		<input type="text" id="usernametx" name="usernametx">
		<input type="password" id="passtx" name="passtx">
		
		<input id="login" type="submit" name="loginlg" value="Login">
		<input id="loginfb" type="submit" name="loginfblg" value="Login with facebook">
		<input id="registerbt" type="submit" name="registerlg" value="register">
	</form>
</div>

</body>
</html>