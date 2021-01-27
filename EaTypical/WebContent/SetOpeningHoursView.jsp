<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Restaurant creation</title>
	<link rel="stylesheet" type="text/css" href="SetOpeningHoursCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="SetOpeningHoursView" name="myform" method="get">
		<input id="home" type="submit" name="Home SR2" value="Home">
		<input id="sponsorRestaurant" type="submit" name="Sponsor Restaurant SR2" value="Sponsor Restaurant">
		<input id="manageMenu" type="submit" name="Manage Menu SR2" value="Manage Menu">
		<input id="back" type="submit" name="Back SR2" value="Back">
		<img id="fotoUtente" src="utente.jpg"/>
		<label id="nomeUtente">nomeUtente</label>
		
		<input id="checkSunLunch" class="checkLunch" type="checkbox">
		<label id="labelSunLunch" class="labelLunch" for="checkSunLunch">Sunday lunch</label>
		<input id="checkSunDinner" class="checkDinner" type="checkbox">
		<label id="labelSunDinner" class="labelDinner" for="checkSunDinner">Sunday dinner</label>
		<input id="checkMonLunch" class="checkLunch" type="checkbox">
		<label id="labelMonLunch" class="labelLunch" for="checkMonLunch">Monday lunch</label>
		<input id="checkMonDinner" class="checkDinner" type="checkbox">
		<label id="labelMonDinner" class="labelDinner" for="checkMonDinner">Monday dinner</label>
		<input id="checkTueLunch" class="checkLunch" type="checkbox">
		<label id="labelTueLunch" class="labelLunch" for="checkTueLunch">Tuesday lunch</label>
		<input id="checkTueDinner" class="checkDinner" type="checkbox">
		<label id="labelTueDinner" class="labelDinner" for="checkTueDinner">Tuesday dinner</label>
		<input id="checkWedLunch" class="checkLunch" type="checkbox">
		<label id="labelWedLunch" class="labelLunch" for="checkWedLunch">Wednesday lunch</label>
		<input id="checkWedDinner" class="checkDinner" type="checkbox">
		<label id="labelWedDinner" class="labelDinner" for="checkWedDinner">Wednesday dinner</label>
		<input id="checkThuLunch" class="checkLunch" type="checkbox">
		<label id="labelThuLunch" class="labelLunch" for="checkThuLunch">Thursday lunch</label>
		<input id="checkThuDinner" class="checkDinner" type="checkbox">
		<label id="labelThuDinner" class="labelDinner" for="checkThuDinner">Thursday dinner</label>
		<input id="checkFriLunch" class="checkLunch" type="checkbox">
		<label id="labelFriLunch" class="labelLunch" for="checkFriLunch">Friday lunch</label>
		<input id="checkFriDinner" class="checkDinner" type="checkbox">
		<label id="labelFriDinner" class="labelDinner" for="checkFriDinner">Friday dinner</label>
		<input id="checkSatLunch" class="checkLunch" type="checkbox">
		<label id="labelSatLunch" class="labelLunch" for="checkSatLunch">Saturday lunch</label>
		<input id="checkSatDinner" class="checkDinner" type="checkbox">
		<label id="labelSatDinner" class="labelDinner" for="checkSatDinner">Saturday dinner</label>
		
		<input id="ok" type="submit" name="OK" value="OK">
	</form>
</div>
</body>
</html>