<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- Modello l'input per capire quale pulsante è stato spinto -->
   
    
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styleRestaurantMenuView.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<form action="ManageMenu" method="get">
		
			<input id="home" type="submit" name="home" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant" value="Sponsor Restaurant">
			<input id="back" type="submit" name="back" value="Back">
			
			
			<img id="fotoUtente" alt="image" src="utente.jpg"/>
			
			<label id="n">NomeUtente</label>
			
			
			
			<div id="informazioni">
				<p>Select the type of change:</p>
			</div>
			
			<div id="sceltaMultipla">
				<div><input id="delete" type="submit" name="delete" value="Delete a Dish"></div>
				<div><input id="add"  type="submit" name="add" value="Add a Dish"></div>
				<div><input id="modify" name="modify" type="submit" value="Modify a Dish"></div>
				<div><input id="advice" name="advice" value="Get Advice" type="submit"></div>
			</div>
			
			
			
			
			
		</form>
	</div>
	

</body>
</html>