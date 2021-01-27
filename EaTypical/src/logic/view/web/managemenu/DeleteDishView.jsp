<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="styleDeleteDishView.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<form action="DeleteDish" method="get">
		
			<input id="home" type="submit" name="home" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant" value="Sponsor Restaurant">
			<input id="back" type="submit" name="back" value="Back">
			
			<p><%String nome = request.getParameter ( "nome" );  
			out.print ( "Dio" + nome);   %></p>
			
			<img id="fotoUtente" alt="image" src="utente.jpg"/>
			
			<label id="n">NomeUtente</label>
			
			
			
			<div id="informazioni">
				<p>Select the dish you would like to delete:</p>
			</div>
			
			<div id="containerSelect">
				<select id="select">
					<option>opzione 1</option>
					<option>opzione 2</option>
				</select>
			</div>	
			
			<input id="delete" name="delete" value="DELETE" type="submit">
			
			
			
			
			
		</form>
	</div>
</body>
</html>