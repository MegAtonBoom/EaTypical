<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>
<%@page import="logic.engineeringclasses.exceptions.DishAlreadyExists"%>
<%@page import="logic.engineeringclasses.bean.manageMenu.BeanDishWeb"%>
<%@page import="com.mysql.cj.Session.SessionEventListener"%>
<%@page import="logic.engineeringclasses.bean.manageMenu.BeanAddDish"%>

<%
	if(request.getParameter("home4")!=null) {
		//SizedStack.getSizedStack(true).clearStack();
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu4")!=null) {
		//SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant4")!=null) {
		//SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("continue4")!=null) {
		int ricettaNonInserita = 0;
		//int count=0;
		int prezzoNonInserito = 0;
		if(request.getParameter("continue4")!=null) {
			//SizedStack.getSizedStack(true).push("ConfirmMessage.jsp");
			//mi porto appresso le informazioni per l'inserimento del piatto
			
			/*-----------------------------------------------*/
			String stringVegano = request.getParameter("c1");
			String stringCeliaco = request.getParameter("c2");
			String ristorante = request.getParameter("ristorante");
			String piatto = request.getParameter("piatto");
			boolean perVegano;
			boolean perCeliaco;
			if(stringVegano ==null){
				perVegano=false;
			}else{
				perVegano=true;
			}
			if(stringCeliaco ==null){
				perCeliaco=false;
			}else{
				perCeliaco=true;
			}
			if(request.getParameter("priceInput").equals("")){
				//se Ã¨ la stringa vuota significa che non ho inserito il prezzo
				prezzoNonInserito = 1;
			}else{
				//setto a stringa vuota
			}
			if(request.getParameter("ricetta").equals("")){
				// se la stringa vuota allora non ha inserito nessuna ricetta
				ricettaNonInserita = 1;
			}
			
			
			if(ricettaNonInserita==0 && prezzoNonInserito ==0){
				BeanDishWeb beanWebDish = new BeanDishWeb(piatto,ristorante,(String)request.getParameter("ricetta"),perVegano,perCeliaco,Double.parseDouble(request.getParameter("priceInput")),1);
				request.setAttribute("bean", beanWebDish);
			%>
			<jsp:forward page="ConfirmMessage.jsp"></jsp:forward>
			<%
			}
		
		}
	}
%>

<%
	if(request.getParameter("back4")!=null) {		
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%		
	}
%>    
    
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="modifyDish.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="ModifyDishView.jsp" name="myform" method="get">
		
			<input id="home" type="submit" name="home4" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu4" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant4" value="Sponsor Restaurant">
			<input id="back" type="submit" name="back4" value="Back">
			
			<img id="fotoUtente" alt="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente">NomeUtente</label>  
			
			
			
			<div id="informazioni">
				<p>Please, select the dish you would like to modify:</p>							
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
			
			<div id="contR">
				<select id="sel" name="ristorante">
				<%
		
			ArrayList<String> obs2 = (ArrayList<String>)request.getAttribute("listaRistoranti");
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
				<input type="text" id="priceInput" name="priceInput" >
			</div>
			
			<div>
				<textarea id = "area" rows="15" cols="76" name="ricetta">Inserire la nuova ricetta ...</textarea>	
			</div>
			
			<div id="check">
				<input type="checkbox"  id="c1" name="c1" value="Vegan" >
  				<label for="c1" id="l1"> Vegan</label><br>
  				<input type="checkbox" id="c2" name="c2" value="Celiac">
  				<label for="c2" id="l2"> Celiac</label><br>			
			</div>
			
			<div>
				<input type="submit" id="continue" value="CONTINUE" name="continue4">
			</div>
			
		</form>
		
	</div>
</body>
</html>