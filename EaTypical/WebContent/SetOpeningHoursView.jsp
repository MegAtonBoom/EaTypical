<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>
<%@page import="logic.engineeringclasses.others.Session" %>
<%@page import="logic.engineeringclasses.bean.sponsorrestaurant.BeanNewRestaurant" %>
<%@page import="logic.controller.applicationcontroller.SponsorRestaurant" %>
<%@page import="logic.engineeringclasses.exceptions.AlreadyInUseRestaurantNameException" %>
    
<%
	Session bs = (Session)session.getAttribute("session");
	BeanNewRestaurant bnr = (BeanNewRestaurant)session.getAttribute("bean");
	String savedString = "";
%>

<%    	
    	if(request.getParameter("Home SR2")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="HomePageOwner.jsp"/>
<%
    	}
    	if(request.getParameter("Manage Menu SR2")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="RestaurantMenuview.jsp"/>
<%
    	}
    	if(request.getParameter("Back SR2")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="CreatingRestaurantView.jsp"/>
<%
    	}
    	if(request.getParameter("OK")!=null) {
    		try {
				boolean[][] openingHours = new boolean[7][2];
				
				String sunLun = request.getParameter("checkSunLunch");
				if(sunLun==null) openingHours[0][0]=false;
				else openingHours[0][0]=true;
				
				String sunDin = request.getParameter("checkSunDinner");
				if(sunDin==null) openingHours[0][1]=false;
				else openingHours[0][1]=true;
				
				String monLun = request.getParameter("checkMonLunch");
				if(monLun==null) openingHours[1][0]=false;
				else openingHours[1][0]=true;
				
				String monDin = request.getParameter("checkMonDinner");
				if(monDin==null) openingHours[1][1]=false;
				else openingHours[1][1]=true;
				
				String tueLun = request.getParameter("checkTueLunch");
				if(tueLun==null) openingHours[2][0]=false;
				else openingHours[2][0]=true;
				
				String tueDin = request.getParameter("checkTueDinner");
				if(tueDin==null) openingHours[2][1]=false;
				else openingHours[2][1]=true;
				
				String wedLun = request.getParameter("checkWedLunch");
				if(wedLun==null) openingHours[3][0]=false;
				else openingHours[3][0]=true;
				
				String wedDin = request.getParameter("checkWedDinner");
				if(wedDin==null) openingHours[3][1]=false;
				else openingHours[3][1]=true;
				
				String thuLun = request.getParameter("checkThuLunch");
				if(thuLun==null) openingHours[4][0]=false;
				else openingHours[4][0]=true;
				
				String thuDin = request.getParameter("checThuDinner");
				if(thuDin==null) openingHours[4][1]=false;
				else openingHours[4][1]=true;
				
				String friLun = request.getParameter("checkFriLunch");
				if(friLun==null) openingHours[5][0]=false;
				else openingHours[5][0]=true;
				
				String friDin = request.getParameter("checkFriDinner");
				if(friDin==null) openingHours[5][1]=false;
				else openingHours[5][1]=true;
				
				String satLun = request.getParameter("checkSatLunch");
				if(satLun==null) openingHours[6][0]=false;
				else openingHours[6][0]=true;
				
				String satDin = request.getParameter("checkSatDinner");
				if(satDin==null) openingHours[6][1]=false;
				else openingHours[6][1]=true;
				
				bnr.setOpeningHours(openingHours);
				SponsorRestaurant sponsorRest = new SponsorRestaurant();
				sponsorRest.saveRestaurant(bnr);
				savedString = "Restaurant saved successfully.";
    			
    		}
    		catch(AlreadyInUseRestaurantNameException e) {
    			session.setAttribute("session", bs);
    			session.setAttribute("errorStr", "This restaurant has already been sponsored.");
%>
    			<jsp:forward page="CreatingRestaurantView.jsp"/>
<%
    		}
    		catch(Exception e) {
    			session.setAttribute("session", bs);
    			session.setAttribute("errorStr", "An unknown error occurred. Please, try again later.");
%>
    			<jsp:forward page="CreatingRestaurantView.jsp"/>
<%
    		}
    		
    	}
%>    
    
<!DOCTYPE html>
<html lang="en">
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
		<label id="nomeUtente"><%=bs.getUser().getUsername()%></label>
		
		<input id="checkSunLunch" class="checkLunch" type="checkbox" name="checkSunLunch">
		<label id="labelSunLunch" class="labelLunch" for="checkSunLunch">Sunday lunch</label>
		<input id="checkSunDinner" class="checkDinner" type="checkbox" name="checkSunDinner">
		<label id="labelSunDinner" class="labelDinner" for="checkSunDinner">Sunday dinner</label>
		<input id="checkMonLunch" class="checkLunch" type="checkbox" name="checkMonLunch">
		<label id="labelMonLunch" class="labelLunch" for="checkMonLunch">Monday lunch</label>
		<input id="checkMonDinner" class="checkDinner" type="checkbox" name="checkMonDinner">
		<label id="labelMonDinner" class="labelDinner" for="checkMonDinner">Monday dinner</label>
		<input id="checkTueLunch" class="checkLunch" type="checkbox" name="checkTueLunch">
		<label id="labelTueLunch" class="labelLunch" for="checkTueLunch">Tuesday lunch</label>
		<input id="checkTueDinner" class="checkDinner" type="checkbox" name="checkTueDinner">
		<label id="labelTueDinner" class="labelDinner" for="checkTueDinner">Tuesday dinner</label>
		<input id="checkWedLunch" class="checkLunch" type="checkbox" name="checkWedLunch">
		<label id="labelWedLunch" class="labelLunch" for="checkWedLunch">Wednesday lunch</label>
		<input id="checkWedDinner" class="checkDinner" type="checkbox" name="checkWedDinner">
		<label id="labelWedDinner" class="labelDinner" for="checkWedDinner">Wednesday dinner</label>
		<input id="checkThuLunch" class="checkLunch" type="checkbox" name="checkThuLunch">
		<label id="labelThuLunch" class="labelLunch" for="checkThuLunch">Thursday lunch</label>
		<input id="checkThuDinner" class="checkDinner" type="checkbox" name="checkThuDinner">
		<label id="labelThuDinner" class="labelDinner" for="checkThuDinner">Thursday dinner</label>
		<input id="checkFriLunch" class="checkLunch" type="checkbox" name="checkFriLunch">
		<label id="labelFriLunch" class="labelLunch" for="checkFriLunch">Friday lunch</label>
		<input id="checkFriDinner" class="checkDinner" type="checkbox" name="checkFriDinner">
		<label id="labelFriDinner" class="labelDinner" for="checkFriDinner">Friday dinner</label>
		<input id="checkSatLunch" class="checkLunch" type="checkbox" name="checkSatLunch">
		<label id="labelSatLunch" class="labelLunch" for="checkSatLunch">Saturday lunch</label>
		<input id="checkSatDinner" class="checkDinner" type="checkbox" name="checkSatDinner">
		<label id="labelSatDinner" class="labelDinner" for="checkSatDinner">Saturday dinner</label>
		
		<label id="savedMsg"><%=savedString%></label>
		<input id="ok" type="submit" name="OK" value="OK">
	</form>
</div>
</body>
</html>