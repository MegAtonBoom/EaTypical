<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="styleAdviceView.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
		<form action="AdviceDish" name="myform" method="get">
		
			<input id="home" type="submit" name="home" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant" value="Sponsor Restaurant">
			<input id="back" type="submit" name="back" value="Back">
			
			<img id="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente">NomeUtente</label>  
			
			
			<div>
				<textarea id="area" rows="35" cols="120" readonly><% %></textarea>
			</div>
			
			
			<div>
				<input type="submit" id="continue" value="DONE" name="continue">
			</div>
			
			
			
		</form>
	</div>
</body>
</html>