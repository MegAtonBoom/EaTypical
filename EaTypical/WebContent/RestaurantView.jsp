<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
 <%    	
    	if(request.getParameter("Home restv")!=null) {
    		//SizedStack.getSizedStack(true).push("HomePageTouristView.jsp");
    		//SizedStack.getSizedStack(true).clearStack();
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant restv")!=null) {
    		//SizedStack.getSizedStack(true).push("ItalianViewCity2.jsp");
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip restv")!=null) {
    		//SizedStack.getSizedStack(true).push("ItalianViewCity2.jsp");
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	if(request.getParameter("Back restv")!=null) {

%>
				<jsp:forward page="HomePageTouristView.jsp"/>
<%
			
    	}
    	if(request.getParameter("save Restaurant into Favourites restv")!=null) {
    		//SizedStack.getSizedStack(true).push("TripSettingsView.jsp");
%>
			<!--<jsp:forward page="RestaurantView.jsp"/> TO DO-->
<%
    	}
    	if(request.getParameter("Read Reviews restv")!=null) {

    		%>
    						<jsp:forward page="ReadReviewsView.jsp"/>
    		<%
    					
    	}
    	if(request.getParameter("Write Review restv")!=null) {

    		%>
    						<jsp:forward page="WriteReviewView.jsp"/>
    		<%
    					
    	}
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Restaurant</title>
<link rel="stylesheet" type="text/css" href="RestaurantViewCSS.css">
</head>
<body>
	<div class="container">
		<form action="RestaurantView.jsp" class="button" name="myform" method="get">
			<input id="home" class="button" type="submit" name="Home restv" value="Home">
			<input id="scheduleTrip" class="button" type="submit" name="Schedule Trip restv" value="Schedule Trip">
			<input id="chooseRestaurant" class="button" type="submit" name="Choose Restaurant restv" value="Choose Restaurant">
			<input id="back" class="button" type="submit" name="Back restv" value="Back">
			<input id="saveFavourite" class="button" type="submit" name="Save Restaurant into Favourite restv" value="Save Restaurant into Favourite">
			<input id="readReviews" class="button" type="submit" name="Read Reviews restv" value="Read Reviews">
			<input id="writeReview" class="button" type="submit" name="Write Review restv" value="Write Review">
			<img id="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente">nomeUtente</label>
			<fieldset id="checkboxes">
					<label id="choice">you want something only </label>
					<input type="checkbox" name="filter" value="forCeliacs">for celiacs
					<input type="checkbox" name="filter" value="forVegans">for vegans					
			</fieldset>
			<label id="restName">Restaurant Name</label>
			<label id="addrName">Address</label>
			<table id="table1">
				 <colgroup>
					<col width="45%">
					<col width="55%">
				</colgroup> 
			  <tr>
			    <th><b>prova1</b></th>
			    <th><b>prova1</b></th>
			  </tr>		  
			</table>
		</form>
	</div>

</body>
</html>