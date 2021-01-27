<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>

<%    	
    	if(request.getParameter("Home ST1")!=null) {
    		SizedStack.getSizedStack(true).clearStack();
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant ST1")!=null) {
    		SizedStack.getSizedStack(true).push("ItalianViewCity2.jsp");
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("Back ST1")!=null) {
    		String pag = SizedStack.getSizedStack(true).pop();
    		if(pag=="ItalianViewCity.jsp") {
%>
				<jsp:forward page="ItalianViewCity.jsp"/>
<%
    		}
			else if(pag=="ItalianViewCity2.jsp") {
%>
				<jsp:forward page="ItalianViewCity2.jsp"/>
<%
			}
			else {
%>
				<jsp:forward page="HomePageTouristView.jsp"/>
<%
			}
    	}
    	if(request.getParameter("Continue")!=null) {
%>
			<jsp:forward page="TripSettingsView.jsp"/>
<%
    	}
%>    
    	
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>City selection</title>
	<link rel="stylesheet" type="text/css" href="ItalianCSScity.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="ItalianViewCity.jsp" name="myform" method="get">
		<input id="home" type="submit" name="Home ST1" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip ST1" value="Schedule Trip" disabled>
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant ST1" value="Choose Restaurant">
		<input id="back" type="submit" name="Back ST1" value="Back">
		<img id="fotoUtente" src="utente.jpg" alt="Photo"/>
		<label id="nomeUtente">nomeUtente</label>
		<div class="box-1">
			<p>Click on the map or select a city from the drop-down menu:</p>
		</div>
		
		<select id="scrollbar" name="Scroll">
			<option disabled selected>City</option>
			<option value="AO">Aosta</option>
			<option value="TO">Torino</option>
			<option value="GE">Genova</option>
			<option value="MI">Milano</option>
			<option value="TN">Trento</option>
			<option value="VE">Venezia</option>
			<option value="TR">Trieste</option>
			<option value="BO">Bologna</option>
			<option value="FI">Firenze</option>
			<option value="AN">Ancona</option>
			<option value="PG">Perugia</option>
			<option value="RM">Roma</option>
			<option value="AQ">L'Aquila</option>
			<option value="CB">Campobasso</option>
			<option value="NA">Napoli</option>
			<option value="PZ">Potenza</option>
			<option value="BA">Bari</option>
			<option value="CZ">Catanzaro</option>
			<option value="PA">Palermo</option>
			<option value="CG">Cagliari</option>
		</select>
		
		<div class="box-2">
			<img id="fotoItalia" src="Cartina.jpg" alt="Italian cities"/>
		    <img id="AO_img" class="city" src="placeicon.png" alt=".">
			<img id="TO_img" class="city" src="placeicon.png" alt=".">
			<img id="GE_img" class="city" src="placeicon.png" alt=".">
			<img id="MI_img" class="city" src="placeicon.png" alt=".">
			<img id="TN_img" class="city" src="placeicon.png" alt=".">
			<img id="VE_img" class="city" src="placeicon.png" alt=".">
			<img id="TR_img" class="city" src="placeicon.png" alt=".">
			<img id="BO_img" class="city" src="placeicon.png" alt=".">
			<img id="FI_img" class="city" src="placeicon.png" alt=".">
			<img id="AN_img" class="city" src="placeicon.png" alt=".">
			<img id="PG_img" class="city" src="placeicon.png" alt=".">
			<img id="RM_img" class="city" src="placeicon.png" alt=".">
			<img id="AQ_img" class="city" src="placeicon.png" alt=".">
			<img id="CB_img" class="city" src="placeicon.png" alt=".">
			<img id="NA_img" class="city" src="placeicon.png" alt=".">
			<img id="PZ_img" class="city" src="placeicon.png" alt=".">
			<img id="BA_img" class="city" src="placeicon.png" alt=".">
			<img id="CZ_img" class="city" src="placeicon.png" alt=".">
			<img id="PA_img" class="city" src="placeicon.png" alt=".">
			<img id="CG_img" class="city" src="placeicon.png" alt=".">
		</div>
		
		<input id="continue" type="submit" name="Continue" value="Continue">
	</form>
</div>


<script>
	$(".city").click(function(e){
	$("#scrollbar").val(e.currentTarget.id.replace("_img","")).change();
	});
</script>


</body>
</html>