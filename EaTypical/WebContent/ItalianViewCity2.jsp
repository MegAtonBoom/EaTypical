<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@page import="logic.engineeringclasses.others.Session" %>
 <%Session bs;
  bs=(Session)session.getAttribute("session"); %>


<% boolean notSelectedCity=false; %>
<%    	
    	if(request.getParameter("Home ivc2")!=null) {
%> 
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip ivc2")!=null) {
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	
    	if(request.getParameter("Back ivc2")!=null) {

%>
				<jsp:forward page="HomePageTouristView.jsp"/>
<%
			
    	}
    	if(request.getParameter("Continue ivc2")!=null) {
    		String city=request.getParameter("Scroll");    		
    		if(city!=null)
    		{
    			if(city.equals("AO"))
    				city="Aosta";
    			else if(city.equals("TO")){
    				city="Torino";}
    			else if(city.equals("GE")){
    				city="Genova";}
    			else if(city.equals("MI")){
    				city="Milano";}
    			else if(city.equals("TN")){
    				city="Trento";}
    			else if(city.equals("VE")){
    				city="Venezia";}
    			else if(city.equals("TR")){
    				city="trento";}
    			else if(city.equals("BO")){
    				city="Bologna";}
    			else if(city.equals("FI")){
    				city="Firenze";}
    			else if(city.equals("AN")){
    				city="Ancona";}
    			else if(city.equals("PG")){
    				city="Perugia";}
    			else if(city.equals("RM")){
    				city="Roma";}
    			else if(city.equals("AQ")){
    				city="L'Aquila";}
    			else if(city.equals("CB")){
    				city="Campobasso";}
    			else if(city.equals("NA")){
    				city="Napoli";}
    			else if(city.equals("PZ")){
    				city="Potenza";}
    			else if(city.equals("BA")){
    				city="Bari";}
    			else if(city.equals("CZ")){
    				city="Catanzaro";}
    			else if(city.equals("PA")){
    				city="Palermo";}
    			else{
    				city="Cagliari";}
    			
    			session.setAttribute("citta",city);
    			%>
    				 <jsp:forward page="RestaurantView.jsp"/> 
    			<%
    		}
    		else{
    			notSelectedCity=true;
    		}     		    		   		     		
    	}
%>    

    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>City selection</title>
	<link rel="stylesheet" type="text/css" href="ItalianCityViewCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">
	<form action="ItalianViewCity2.jsp" name="myform" method="get">
		<input id="home" type="submit" name="Home ivc2" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip ivc2" value="Schedule Trip">
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant ivc2" value="Choose Restaurant" disabled>
		<input id="back" type="submit" name="Back ivc2" value="Back">
		<img id="fotoUtente" src="utente.jpg"/>
		
		<label id="nomeUtente"><%if(bs!=null&&bs.getUser()!=null){
					%>=bs.getUser().getUsername()<%
		}
		else{
		%>not logged<%		}	%></label>
		<label id="selectCity">Click on the map or select a city from the drop-down menu:</label>
		
		
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
			<img id="fotoItalia" src="Cartina.jpg"/>
		    <img id="AO_img" class="city" name="Aosta" src="placeicon.png">
			<img id="TO_img" class="city"  name="Torino"  src="placeicon.png">
			<img id="GE_img" class="city"  name="Genova"  src="placeicon.png">
			<img id="MI_img" class="city"  name="Milano"  src="placeicon.png">
			<img id="TN_img" class="city"  name="Trento"  src="placeicon.png">
			<img id="VE_img" class="city"  name="Venezia"  src="placeicon.png">
			<img id="TR_img" class="city"  name="Trieste" src="placeicon.png">
			<img id="BO_img" class="city"  name="Bologna"  src="placeicon.png">
			<img id="FI_img" class="city"  name="Firenze"  src="placeicon.png">
			<img id="AN_img" class="city"  name="Ancona" src="placeicon.png">
			<img id="PG_img" class="city"  name="Perugia"  src="placeicon.png">
			<img id="RM_img" class="city"  name="Roma"  src="placeicon.png">
			<img id="AQ_img" class="city"  name="L'Aquila" src="placeicon.png">
			<img id="CB_img" class="city"  name="Campobasso"  src="placeicon.png">
			<img id="NA_img" class="city"  name="Napoli" src="placeicon.png">
			<img id="PZ_img" class="city"  name="Potenza"  src="placeicon.png">
			<img id="BA_img" class="city"  name="Bari" src="placeicon.png">
			<img id="CZ_img" class="city"  name="Catanzaro"  src="placeicon.png">
			<img id="PA_img" class="city"  name="Palermo"  src="placeicon.png">
			<img id="CG_img" class="city"  name="Cagliari"  src="placeicon.png">		

		</div>
		
		<% if(notSelectedCity){
			
			%><label id="noCity">You must select a city!</label><%
		}%>
		
		<input id="continue" type="submit" name="Continue ivc2" value="Continue">
	</form>
</div>


<script>

	$(".city").click(function(e){
		$("#scrollbar").val(e.currentTarget.id.replace("_img","")).change();
	});

</script>


</body>
</html>