<%@page import="logic.model.Owner"%>
<%@page import="logic.controller.guicontroller.OwnerBaseGuiController"%>
<%@page import="logic.engineeringclasses.others.Session"%>
<%@page import="logic.engineeringclasses.dao.NotificationsDAO"%>
<%@page import="logic.engineeringclasses.bean.manageMenu.BeanListNotificationsScheduling"%>
<%@page import="logic.engineeringclasses.dao.ReviewsDAO"%>
<%@page import="logic.engineeringclasses.bean.manageMenu.BeanListReviews"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
 <%@page import="logic.engineeringclasses.others.SizedStack" %>

<%
	Session sessione = new Session(true);
	sessione.setUser(new Owner("Luca","Capotombolo","liuk"));
	session.setAttribute("sessione", sessione);
	if(request.getParameter("manage6")!=null) {
		
		
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsor6")!=null) {
		//SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("scheduling")!=null){
		NotificationsDAO notificationsDAO = new NotificationsDAO();
	 	BeanListNotificationsScheduling beanListNotificationsScheduling = notificationsDAO.selectOwnerSchedulingNotifications("liuk");
		session.setAttribute("beanScheduling", beanListNotificationsScheduling);

		%>
		<jsp:forward page="SchedulingOwnerNotification.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("review")!=null){
		BeanListReviews beanListReviews = ReviewsDAO.findOwnerReviews("liuk");
		session.setAttribute("beanReviews", beanListReviews);
		%>
		<jsp:forward page="ReviewNotificationsView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("logout")!=null) {
		//SizedStack.getSizedStack(true).push("HomePageOwner.jsp");
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>



<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>Home page tourist</title>
	<link rel="stylesheet" type="text/css" href="HomePageOwnerStyle.css">
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
 	<input id="schedulingNotifications" class="button" type="submit" name="scheduling" value="See Scheduling Notifications"> 
	<input id="reviewNotifications" class="button" type="submit" name="review" value="See Review Notifications"> 
			<input id="Sponsor" class="button" type="submit" name="sponsor6" value="Sponsor Restaurant">		
		<input id="logout" class="button" type="submit" name="logout" value="Logout">
	</form>
</div>
</body>
</html>