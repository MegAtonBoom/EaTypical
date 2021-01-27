<%@page import="java.util.ArrayList"%>
<%@page import="logic.engineeringclasses.bean.manageMenu.BeanAddDish"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>

<%
	if(request.getParameter("home1")!=null) {
		SizedStack.getSizedStack(true).clearStack();
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu1")!=null) {
		SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		//mi porto a spasso l'utente e le altre informazioni sulla sessione
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant1")!=null) {
		SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
		//mi porto a spasso l'utente e le altre informazioni sulla sessione
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%

	int ricettaVuota = 0;
	//int count=0;
	int prezzoVuoto = 0;
	if(request.getParameter("continue1")!=null) {
		//SizedStack.getSizedStack(true).push("ConfirmMessage.jsp");
		//mi porto appresso le informazioni per l'inserimento del piatto
		
		/*-----------------------------------------------*/
		String veganoString = request.getParameter("c1");
		String celiacoString = request.getParameter("c2");
		String ristorante = request.getParameter("ristorante");
		String piatto = request.getParameter("piatto");
		boolean vegano;
		boolean celiaco;
		if(veganoString ==null){
			vegano=false;
		}else{
			vegano=true;
		}
		if(celiacoString ==null){
			celiaco=false;
		}else{
			celiaco=true;
		}
		if(request.getParameter("prezzo").equals("")){
			//se è la stringa vuota significa che non ho inserito il prezzo
			prezzoVuoto = 1;
		}else{
			//setto a stringa vuota
		}
		if(request.getParameter("ricetta").equals("")){
			// se la stringa vuota allora non ha inserito nessuna ricetta
			ricettaVuota = 1;
		}
		
		
		if(ricettaVuota==0 && prezzoVuoto ==0){
			BeanAddDish beanAddDish = new BeanAddDish(piatto,ristorante,(String)request.getParameter("ricetta"),vegano,celiaco,Double.parseDouble(request.getParameter("prezzo")),0);
			request.setAttribute("bean", beanAddDish);
		%>
		<jsp:forward page="ConfirmMessage.jsp"></jsp:forward>
		<%
		}
	}
%>

<%
	if(request.getParameter("back1")!=null) {		
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%		
	}
%>

<!-- INIZIO CODICE HTML -->

<!DOCTYPE html>

<html>
<head>

<link rel="stylesheet" type="text/css" href="prova.css">
<meta charset="ISO-8859-1">
<title>Add Dish</title>
</head>
<body>

	<div class="container">
		<form action="AddDishView.jsp" name="myform" method="get">
		
			<input id="home" type="submit" name="home1" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu1" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant1" value="Sponsor Restaurant">
			<input id="back" type="submit" name="back1" value="Back">
			
			<img id="fotoUtente" alt="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente">NomeUtente</label>  
			
			
			
			<div id="informazioni">
				<p>Please, select the dish you would add into menu:</p>							
			</div>
			
			<div id="containerSelect">
				<select id="select" name="piatto">
<%
		
			ArrayList<String> obs1 = (ArrayList<String>) request.getAttribute("listaPiatti");
			String value1;
			while(!obs1.isEmpty()){
				value1 = obs1.get(0);
				obs1.remove(0);
				%>
				<option><%=value1%></option>
				<%
			}
		
%>
				</select>				
			</div>	
			
			<div id="cont">
				<select id="sel" name="ristorante">
					<%
		
			ArrayList<String> obs2 = (ArrayList<String>) request.getAttribute("listaRistoranti");
			String value2;
			while(!obs2.isEmpty()){
				value2 = obs2.get(0);
				obs2.remove(0);
				%>
				<option><%=value2%></option>
				<%
			}
			
		
%>
				</select>				
			</div>
			
			
			
			
			
			<div id="price">
				<input type="text" id="priceInput" name="prezzo" value="Insert new Price">
			</div>
			
			<div id="check">
				<input type="checkbox"  id="c1" name="c1" value="Vegan" >
  				<label for="c1" id="l1"> Vegan</label><br>
  				<input type="checkbox" id="c2" name="c2" value="Celiac">
  				<label for="c2" id="l2"> Celiac</label><br>			
			</div>
			
			<div>
				<textarea id = "area" rows="15" cols="76" name="ricetta">Scrivi ricetta...</textarea>
			</div>
			
			<div>
				<input type="submit" id="continue" value="OK" name="continue1">
			</div>
			
			
			
		</form>
	</div>
	
</body>
</html>