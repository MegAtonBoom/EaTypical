<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%    	
    	if(request.getParameter("Home ww")!=null) {
    		//SizedStack.getSizedStack(true).push("HomePageTouristView.jsp");
    		//SizedStack.getSizedStack(true).clearStack();
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant ww")!=null) {
    		//SizedStack.getSizedStack(true).push("ItalianViewCity2.jsp");
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip ww")!=null) {
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
    	if(request.getParameter("Submit Review ww")!=null) {
    		//SizedStack.getSizedStack(true).push("TripSettingsView.jsp");
%>
			<!--<jsp:forward page="RestaurantView.jsp"/> TO DO-->
<%
    	}
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Restaurant</title>
<link rel="stylesheet" type="text/css" href="WriteReviewViewCSS.css">
</head>
<body>
	<div class="container">
		<form action="WriteReviewView.jsp" class="button" name="myform" method="get">
			<input id="home" class="button" type="submit" name="Home ww" value="Home">
			<input id="scheduleTrip" class="button" type="submit" name="Schedule Trip ww" value="Schedule Trip">
			<input id="chooseRestaurant" class="button" type="submit" name="Choose Restaurant ww" value="Choose Restaurant">
			<input id="back" class="button" type="submit" name="Back ww" value="Back">
			<input id="submitReview" class="button" type="submit" name="Submit Review ww" value="Submit Review">
			<img id="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente">nomeUtente</label>
			
			<input type="radio" id="one" name="rating" value="onestar">
				<label for="one" id="onel" class="ratingl">1 star</label>
				
			<input type="radio" id="two" name="rating" value="twostars">
				<label for="two" id="twol" class="ratingl">2 stars</label>
				
			<input type="radio" id="three" name="rating" value="threestars">
				<label for="three" id="threel" class="ratingl">3 stars</label>
				
			<input type="radio" id="four" name="rating" value="fourstars">
				<label for="four" id="fourl" class="ratingl">4 stars</label>
				
			<input type="radio" id="five" name="rating" value="fivestars">
				<label for="five" id="fivel" class="ratingl">5 stars</label>
				
			<textarea id="writeReview" name="Write Review" rows="12">Write here your review...
 			</textarea>
		</form>
	</div>

</body>
</html>