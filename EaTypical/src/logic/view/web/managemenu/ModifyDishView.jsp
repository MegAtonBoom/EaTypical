<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styleModifyDishView.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="ModifyDish" name="myform" method="get">
		
			<input id="home" type="submit" name="home" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant" value="Sponsor Restaurant">
			<input id="back" type="submit" name="back" value="Back">
			
			<img id="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente">NomeUtente</label>  
			
			
			
			<div id="informazioni">
				<p>Please, select the dish you would like to modify:</p>							
			</div>
			
			<div id="containerSelect">
				<select id="select">
					<option>opzione 1</option>
					<option>opzione 2</option>
				</select>
			</div>	
			
			<div id="price">
				<input type="text" id="priceInput" name="priceInput" value="Insert new Price">
			</div>
			
			<div id="check">
				<input type="checkbox"  id="c1" name="c1" value="Vegan" >
  				<label for="c1" id="l1"> Vegan</label><br>
  				<input type="checkbox" id="c2" name="c2" value="Celiac">
  				<label for="c2" id="l2"> Celiac</label><br>			
			</div>
			
			<div>
				<input type="submit" id="continue" value="CONTINUE" name="continue">
			</div>
			
		</form>
		
	</div>
</body>
</html>