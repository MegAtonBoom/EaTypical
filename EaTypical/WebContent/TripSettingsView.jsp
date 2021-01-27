<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>

<%    	
    	if(request.getParameter("Home ST2")!=null) {
    		SizedStack.getSizedStack(true).clearStack();
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip ST2")!=null) {
    		SizedStack.getSizedStack(true).push("ItalianViewCity.jsp");
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant ST2")!=null) {
    		SizedStack.getSizedStack(true).push("ItalianViewCity2.jsp");
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("Back ST2")!=null) {
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%    		
    	}
    	if(request.getParameter("Generate Scheduling")!=null) {
%>
			<jsp:forward page="SchedulingView.jsp"/>
<%
    	}
%>
    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>Trip settings</title>
	<link rel="stylesheet" type="text/css" href="TripSettingsCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="TripSettingsView.jsp" name="myform" method="get">
		<input id="home" type="submit" name="Home ST2" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip ST2" value="Schedule Trip">
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant ST2" value="Choose Restaurant">
		<input id="back" type="submit" name="Back ST2" value="Back">
		<img id="fotoUtente" src="utente.jpg" alt="Photo"/>
		<label id="nomeUtente">nomeUtente</label>
		<div class="box-1">
			<p>Choose the first day of your trip:</p>
			<select class="scrollGiorni">
				<option disabled selected>Day</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				<option>6</option>
				<option>7</option>
				<option>8</option>
				<option>9</option>
				<option>10</option>
				<option>11</option>
				<option>12</option>
				<option>13</option>
				<option>14</option>
				<option>15</option>
				<option>16</option>
				<option>17</option>
				<option>18</option>
				<option>19</option>
				<option>20</option>
				<option>21</option>
				<option>22</option>
				<option>23</option>
				<option>24</option>
				<option>25</option>
				<option>26</option>
				<option>27</option>
				<option>28</option>
				<option>29</option>
				<option>30</option>
				<option>31</option>
			</select>
			<select class="scrollMesi">
				<option disabled selected>Month</option>
				<option>January</option>
				<option>February</option>
				<option>March</option>
				<option>April</option>
				<option>May</option>
				<option>June</option>
				<option>July</option>
				<option>August</option>
				<option>September</option>
				<option>October</option>
				<option>November</option>
				<option>December</option>				
			</select>
			<select class="scrollAnni">
				<option disabled selected>Year</option>
				<option>2021</option>
				<option>2022</option>
				<option>2023</option>
				<option>2024</option>
				<option>2025</option>
				<option>2026</option>
				<option>2027</option>
				<option>2028</option>
				<option>2029</option>
				<option>2030</option>
			</select>
			<input id="lunch1" class="lunch" type="radio" name="radio1">
			<label class="lunchLabel" for="lunch1">Lunch</label>
			<input id="dinner1" class="dinner" type="radio" name="radio1">
			<label class="dinnerLabel" for="dinner1">Dinner</label>
		</div>
		<div class="box-2">
			<p>Choose the last day of your trip:</p>
			<select class="scrollGiorni">
				<option disabled selected>Day</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				<option>6</option>
				<option>7</option>
				<option>8</option>
				<option>9</option>
				<option>10</option>
				<option>11</option>
				<option>12</option>
				<option>13</option>
				<option>14</option>
				<option>15</option>
				<option>16</option>
				<option>17</option>
				<option>18</option>
				<option>19</option>
				<option>20</option>
				<option>21</option>
				<option>22</option>
				<option>23</option>
				<option>24</option>
				<option>25</option>
				<option>26</option>
				<option>27</option>
				<option>28</option>
				<option>29</option>
				<option>30</option>
				<option>31</option>
			</select>
			<select class="scrollMesi">
				<option disabled selected>Month</option>
				<option>January</option>
				<option>February</option>
				<option>March</option>
				<option>April</option>
				<option>May</option>
				<option>June</option>
				<option>July</option>
				<option>August</option>
				<option>September</option>
				<option>October</option>
				<option>November</option>
				<option>December</option>				
			</select>
			<select class="scrollAnni">
				<option disabled selected>Year</option>
				<option>2021</option>
				<option>2022</option>
				<option>2023</option>
				<option>2024</option>
				<option>2025</option>
				<option>2026</option>
				<option>2027</option>
				<option>2028</option>
				<option>2029</option>
				<option>2030</option>
			</select>
			<input id="lunch2" class="lunch" type="radio" name="radio2">
			<label class="lunchLabel" for="lunch2">Lunch</label>
			<input id="dinner2" class="dinner" type="radio" name="radio2">
			<label class="dinnerLabel" for="dinner2">Dinner</label>
		</div>
		<input id="checkboxVegan" type="checkbox">
		<label id="labelVegan" for="checkboxVegan">I am vegan</label>
		<input id="checkboxCeliac" type="checkbox">
		<label id="labelCeliac" for="checkboxCeliac">I have celiac disease</label>
		<img id="euro" src="euro.png" alt="eur"/>
		<input id="budget" type="text" placeholder="Select your budget">
		<select id="scrollVoto">
			<option disabled selected>Vote</option>
			<option>1 star</option>
			<option>2 stars</option>
			<option>3 stars</option>
			<option>4 stars</option>
			<option>5 stars</option>
		</select>
		<input id="generate" type="submit" name="Generate Scheduling" value="Generate Scheduling">
	</form>
</div>
</body>
</html>