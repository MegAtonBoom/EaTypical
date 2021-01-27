<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>Scheduling result</title>
	<link rel="stylesheet" type="text/css" href="SeeTripCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="SeeTripView.jsp" name="myform" method="get">
		<input id="home" type="submit" name="Home ST3" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip ST3" value="Schedule Trip">
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant ST3" value="Choose Restaurant">
		<input id="back" type="submit" name="Back ST3" value="Back">
		<img id="fotoUtente" src="utente.jpg" alt="Photo"/>
		<label id="nomeUtente">nomeUtente</label>
		<label id="citta">Città</label>
		
		<input id="deleteScheduling" type="submit" name="Delete Scheduling" value="Delete Scheduling">
	</form>
</div>
</body>
</html>