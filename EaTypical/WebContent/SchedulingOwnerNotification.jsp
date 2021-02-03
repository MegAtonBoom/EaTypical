<%@page import="logic.engineeringclasses.bean.manageMenu.BeanListNotificationsScheduling"%>
<%@page import="logic.engineeringclasses.bean.manageMenu.BeanListReviews"%>
<%@page import="logic.engineeringclasses.bean.manageMenu.BeanReview"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
	if(request.getParameter("home11")!=null) {
		//SizedStack.getSizedStack(true).clearStack();
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>
 <%
	if(request.getParameter("continue11")!=null) {
		//SizedStack.getSizedStack(true).clearStack();
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu11")!=null) {
		//SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant11")!=null) {
		//SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<link rel="stylesheet" type="text/css" href="SchedulingOwnerNotificationsStyle.css">
<body>

<div class="container">
		<form action="ReviewNotificationsView.jsp" method="get">
		
			<input id="home" type="submit" name="home11" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu11" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant11" value="Sponsor Restaurant">
			<input id="back" type="submit" name="back11" value="Back">
			
			
			
			<img id="fotoUtente" alt="image" src="utente.jpg"/>
			
			<label id="n">NomeUtente</label>
			
<%BeanListNotificationsScheduling beanListNotificationsScheduling = (BeanListNotificationsScheduling)session.getAttribute("beanScheduling"); %>
			
			
			<table >
				<tr>
					<th>Turista</th>
					<th>Ristorante</th>
					<th>Data</th>
					<th>Momento giornata</th>
				</tr>
<%
			BeanReview beanReview;
			for(int i = 0; i<beanListNotificationsScheduling.getNotifications().size();i++) {
				        	

				%>
				<tr>
					<th><%=beanListNotificationsScheduling.getNotifications().get(i).getUsername() %></th>
					<th><%=beanListNotificationsScheduling.getNotifications().get(i).getRistorante() %></th>
					<th><%=beanListNotificationsScheduling.getNotifications().get(i).getData() %></th>
					<th><%=beanListNotificationsScheduling.getNotifications().get(i).isPranzoVsCena() %></th>
					
				</tr>
				<%
			}
%>
				
			</table>
			
			
		

			
			<input id="continue" name="continue11" value="CONTINUE" type="submit">
			
			
			
			
			
		</form>
	</div>
</body>
</html>