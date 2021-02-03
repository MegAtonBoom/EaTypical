<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>
<%@page import="logic.engineeringclasses.others.Session" %>
<%@page import="logic.engineeringclasses.exceptions.EmptyFieldException" %>
<%@page import="logic.engineeringclasses.bean.scheduletrip.BeanSyntacticCheck" %>
<%@page import="logic.engineeringclasses.bean.scheduletrip.BeanRestaurantSchedule" %>
<%@page import="logic.controller.applicationcontroller.ScheduleTrip" %>
<%@page import="logic.engineeringclasses.bean.scheduletrip.BeanOutputSchedule" %>
<%@page import="logic.engineeringclasses.exceptions.InvalidDateException" %>
<%@page import="logic.engineeringclasses.exceptions.NoResultException" %>
<%@page import="java.text.ParseException" %>

<%
	Session bs = (Session)session.getAttribute("session");
	String city = (String)session.getAttribute("city");
	String errorString = "Budget and rating may not be satisfied if there are too few\nrestaurants that meet all the requirements.";
%>

<%    	
    	if(request.getParameter("Home ST2")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip ST2")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant ST2")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("Back ST2")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%    		
    	}
    	if(request.getParameter("Generate Scheduling")!=null) {
    		try {
    			String[] meal1 = new String[3];
    			meal1[0] = request.getParameter("FirstDay");
    			meal1[1] = request.getParameter("FirstMonth");
    			meal1[2] = request.getParameter("FirstYear");
    			
    			String[] meal2 = new String[3];
    			meal2[0] = request.getParameter("LastDay");
    			meal2[1] = request.getParameter("LastMonth");
    			meal2[2] = request.getParameter("LastYear");
    			
    			boolean[] foodRequirement = new boolean[2];
    			String veganString = request.getParameter("CheckboxVegan");
    			String celiacString = request.getParameter("CheckboxCeliac");
    			
    			if(veganString==null) foodRequirement[0]=false;
    			else foodRequirement[0]=true;
    			
    			if(celiacString==null) foodRequirement[1]=false;
    			else foodRequirement[1]=true;
    			
    			String radio1 = request.getParameter("radio1");
    			String radio2 = request.getParameter("radio2");    			
    			boolean atLunch1 = ("lunch1".equals(radio1));
    			boolean atLunch2 = ("lunch2".equals(radio2));
    			
    			String[] budgetAndQuality = new String[2];
    			budgetAndQuality[0] = request.getParameter("budget");
    			
    			if(request.getParameter("ScrollVoto").equals("")) budgetAndQuality[1] = null;
    			else budgetAndQuality[1] = request.getParameter("ScrollVoto");
    			
    			for(int i=0; i<3; i++) {
    				if(meal1[i].equals("") || meal2[i].equals("")) {
    					throw new EmptyFieldException("You need to specify both the first day of your trip and the last day of your trip.");
    				}
    			}
    			
    			BeanSyntacticCheck beanSyntCheck = new BeanSyntacticCheck();
    			BeanRestaurantSchedule beanRestSched = beanSyntCheck.syntacticCheck(meal1, atLunch1, meal2, atLunch2, foodRequirement, budgetAndQuality, city);
    			ScheduleTrip scheduleTrip = new ScheduleTrip();
    			BeanOutputSchedule[] scheduling = scheduleTrip.generateScheduling(beanRestSched);
    			
    			session.setAttribute("session", bs);
    			session.setAttribute("city", city);
    			session.setAttribute("trip", scheduling);
%>
				<jsp:forward page="SchedulingView.jsp"/>
<%
    		}
    		catch(EmptyFieldException e) {
    			errorString = "You need to specify both the first day of your trip and the last day of your trip.";
    		}
    		catch(NumberFormatException e) {
    			errorString = "Sorry, you entered an invalid budget.";
    		}
    		catch(InvalidDateException e) {
    			errorString = "Last meal cannot be before first meal; you cannot schedule trips which last more than 30 days;\nyou cannot schedule trips in the past.";
    		}    		
    		catch(ParseException e) {
    			errorString = "Sorry, you entered a nonexistent date.";
    		}
    		catch(NoResultException e) {
    			errorString = "No restaurant has been found.";
    		}
    		catch(Exception e) {
    			errorString = "An unknown error occurred. Please, try again later.";
    		}
    		
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
		<label id="nomeUtente"><%=bs.getUser().getUsername()%></label>
		<div class="box-1">
			<p>Choose the first day of your trip:</p>
			<select class="scrollGiorni" name="FirstDay">
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
			<select class="scrollMesi" name="FirstMonth">
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
			<select class="scrollAnni" name="FirstYear">
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
			<input id="lunch1" class="lunch" type="radio" name="radio1" value="lunch1">
			<label class="lunchLabel" for="lunch1">Lunch</label>
			<input id="dinner1" class="dinner" type="radio" name="radio1" value="dinner1">
			<label class="dinnerLabel" for="dinner1">Dinner</label>
		</div>
		<div class="box-2">
			<p>Choose the last day of your trip:</p>
			<select class="scrollGiorni" name="LastDay">
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
			<select class="scrollMesi" name="LastMonth">
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
			<select class="scrollAnni" name="LastYear">
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
			<input id="lunch2" class="lunch" type="radio" name="radio2" value="lunch2">
			<label class="lunchLabel" for="lunch2">Lunch</label>
			<input id="dinner2" class="dinner" type="radio" name="radio2" value="dinner2">
			<label class="dinnerLabel" for="dinner2">Dinner</label>
		</div>
		<input id="checkboxVegan" type="checkbox" name="CheckboxVegan">
		<label id="labelVegan" for="checkboxVegan">I am vegan</label>
		<input id="checkboxCeliac" type="checkbox" name="CheckboxCeliac">
		<label id="labelCeliac" for="checkboxCeliac">I have celiac disease</label>
		<img id="euro" src="euro.png" alt="eur"/>
		<input id="budget" type="text" placeholder="Select your budget" name="budget">
		<label id="labelVoto">Select the minimum rating of restaurants</label>
		<select id="scrollVoto" name="ScrollVoto">
			<option disabled selected>Vote</option>
			<option>1 star</option>
			<option>2 stars</option>
			<option>3 stars</option>
			<option>4 stars</option>
			<option>5 stars</option>
		</select>
		<label id="errorMsg"><%=errorString%></label>
		<input id="generate" type="submit" name="Generate Scheduling" value="Generate Scheduling">
	</form>
</div>
</body>
</html>