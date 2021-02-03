<%@page import="logic.engineeringclasses.bean.manageMenu.BeanReview"%>
<%@page import="logic.engineeringclasses.bean.manageMenu.BeanListReviews"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
	if(request.getParameter("home10")!=null) {
		//SizedStack.getSizedStack(true).clearStack();
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>
 <%
	if(request.getParameter("continue10")!=null) {
		//SizedStack.getSizedStack(true).clearStack();
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu10")!=null) {
		//SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant10")!=null) {
		//SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="ReviewOwnerNotifications.css">

<body>

<div class="container">
		<form action="ReviewNotificationsView.jsp" method="get">
		
			<input id="home" type="submit" name="home10" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu10" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant10" value="Sponsor Restaurant">
			<input id="back" type="submit" name="back10" value="Back">
			
			
			
			<img id="fotoUtente" alt="image" src="utente.jpg"/>
			
			<label id="n">NomeUtente</label>
			
<%BeanListReviews beanListReviews = (BeanListReviews)session.getAttribute("beanReviews"); %>
			
			
			<table >
				<tr>
					<th>Turista</th>
					<th>Ristorante</th>
					<th>Leggi recensione</th>
					<th>Voto</th>
				</tr>
<%
			BeanReview beanReview;
			for(int i=0;i<beanListReviews.getRestaurants().size();i++){
				beanReview = new BeanReview(beanListReviews.getTourists().get(i), beanListReviews.getRestaurants().get(i), beanListReviews.getContents().get(i), beanListReviews.getVotes().get(i));
				System.out.print(beanListReviews.getTourists().get(i) +beanListReviews.getRestaurants().get(i)+ beanListReviews.getContents().get(i)+ beanListReviews.getVotes().get(i));
				%>
				<tr>
					<th><%=beanReview.getTourist() %></th>
					<th><%=beanReview.getRestaurant() %></th>
					<th><%=beanReview.getContent() %></th>
					<th><%=beanReview.getVoto() %></th>
				</tr>
				<%
			}
%>
				
			</table>
			
			
		

			
			<input id="continue" name="continue10" value="CONTINUE" type="submit">
			
			
			
			
			
		</form>
	</div>
</body>
</html>
