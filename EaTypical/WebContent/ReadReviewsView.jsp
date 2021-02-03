<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %> 

<%@page import="logic.controller.applicationcontroller.ReadReviews" %> 
<%@page import="logic.engineeringclasses.bean.chooserestaurant.BeanReadReviews" %> 
  
<%@page import="logic.engineeringclasses.others.Session" %>
 <%Session bs;
  bs=(Session)session.getAttribute("session"); 
  String restaurant;
  String textAreaString="";
  restaurant=(String)request.getAttribute("restaurant");
  List<ArrayList<String>> reviews;
  boolean genericError=false;
  try{
  ReadReviews rv=new ReadReviews();
  BeanReadReviews b=rv.findReviews(restaurant);
  reviews=b.getReviews();
  String username;
  String content;
  String vote;
  String userInfo;
  String contentRow;
  for(ArrayList<String> review: reviews)
  {
	  username=review.get(0);
	  vote=review.get(2);
	  content=review.get(1);
      userInfo="User" + username + "  vote: " + vote + " \n";
	  contentRow="This user said: "+content+"\n \n \n";
	  textAreaString=textAreaString+userInfo+contentRow;	  
	}
  
  }
  catch(Exception e){
	  genericError=true;
  }
  
  
  
  
  %>  
  
    
     <%    	
    	if(request.getParameter("Home rr")!=null) {
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant rr")!=null) {
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip rr")!=null) {
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	if(request.getParameter("Back rr")!=null) {

%>
				<jsp:forward page="HomePageTouristView.jsp"/>
<%
			
    	}
    	
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Restaurant</title>
<link rel="stylesheet" type="text/css" href="ReadReviewsViewCSS.css">
</head>
<body>
	<div class="container">
		<form action="ReadReviewsView.jsp" class="button" name="myform" method="get">
			<input id="home" class="button" type="submit" name="Home rr" value="Home">
			<input id="scheduleTrip" class="button" type="submit" name="Schedule Trip rr" value="Schedule Trip">
			<input id="chooseRestaurant" class="button" type="submit" name="Choose Restaurant rr" value="Choose Restaurant">
			<input id="back" class="button" type="submit" name="Back rr" value="Back">
			<img id="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente"><%if(bs!=null&&bs.getUser()!=null){
					%>=bs.getUser().getUsername()<%
		}
		else{
		%>not logged<%		}	%></label>
			<label id="ristName"><%=restaurant %></label>
			
			<%if(genericError){
				%><label id="genericError">Please try again later.</label><%
			}
				%>
			
			
			
			
			<textarea id="readReviews" name="Read reviews" rows="15" readonly><%=textAreaString  %>
 			</textarea>
		</form>
	</div>

</body>
</html>