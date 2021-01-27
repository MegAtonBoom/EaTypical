<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%    	
    	if(request.getParameter("Home rr")!=null) {
    		//SizedStack.getSizedStack(true).push("HomePageTouristView.jsp");
    		//SizedStack.getSizedStack(true).clearStack();
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant rr")!=null) {
    		//SizedStack.getSizedStack(true).push("ItalianViewCity2.jsp");
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip rr")!=null) {
    		//SizedStack.getSizedStack(true).push("ItalianViewCity2.jsp");
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	if(request.getParameter("Back rr")!=null) {

%>
				<jsp:forward page="HomePageTouristView.jsp"/>
<%
			
    	}
    	
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Restaurant</title>
<link rel="stylesheet" type="text/css" href="ReadReviewsViewCSS.css">
</head>
<body>
	<div class="container">
		<form action="ReadReviewsView.jsp" class="button" name="myform" method="get">
			<input id="home" class="button" type="submit" name="Home rr" value="Home">
			<input id="scheduleTrip" class="button" type="submit" name="Schedule Trip rr" value="Schedule Trip">
			<input id="chooseRestaurant" class="button" type="submit" name="Choose Restaurant rr" value="Choose Restaurant">
			<input id="back" class="button" type="submit" name="Back rr" value="Back">
			<img id="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente">nomeUtente</label>
			<textarea id="writeReview" name="Write Review" rows="15">Inserisci recensioni qui
 			</textarea>
		</form>
	</div>

</body>
</html>