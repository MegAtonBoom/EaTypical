<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
 <%@page import="logic.controller.applicationcontroller.WriteReview" %>   
 <%@page import="logic.engineeringclasses.bean.chooserestaurant.BeanNewReview" %>  
 <%@page import="logic.engineeringclasses.exceptions.EmptyReviewFieldException" %> 
 <%@page import="logic.engineeringclasses.exceptions.GenericException" %>
  
  
    
 <%@page import="logic.engineeringclasses.others.Session" %>
 <%Session bs;
 bs=(Session)session.getAttribute("session"); 
 String restaurant=(String)session.getAttribute("restaurant");
 boolean emptyReview=false;
 boolean genericError=false;
 boolean success=false;
%>
 <%
 		boolean emptyText=false;
 %>   
<%    	
    	if(request.getParameter("Home ww")!=null) {
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant ww")!=null) {

%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip ww")!=null) {

%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	if(request.getParameter("Back rr")!=null) {

%>
				<jsp:forward page="HomePageTouristView.jsp"/>
<%
			
    	}
    	if(request.getParameter("Submit Review ww")!=null) {
    		
    		System.out.println("lunghezza: "+request.getParameter("Write Review").length());
    		try
        	{   		    	
    	    	BeanNewReview bnr= new BeanNewReview();
    	    	bnr.setContent(request.getParameter("Write Review"));
    			bnr.setUsername(bs.getUser().getUsername());
    			String vote=request.getParameter("voteScroll");
    			bnr.setVote(vote);
    			bnr.setRestaurant(restaurant);
    	    	WriteReview wr= new WriteReview();
    	    	wr.write(bnr);
    	    	success=true;
        	}
    		catch (EmptyReviewFieldException e) 
        	{
    			emptyReview=true;
    		} 
        	catch (GenericException e) 
        	{
    			genericError=true;
    		} catch (Exception e) {
    			genericError=true;
    		}
%>

<%
    	}
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Restaurant</title>
<link rel="stylesheet" type="text/css" href="WriteReviewViewCSS.css">
</head>
<body>
	<div class="container">
		<form action="WriteReviewView.jsp" class="button" name="myform" method="get">
			<input id="home" class="button" type="submit" name="Home ww" value="Home">
			<input id="scheduleTrip" class="button" type="submit" name="Schedule Trip ww" value="Schedule Trip">
			<input id="chooseRestaurant" class="button" type="submit" name="Choose Restaurant ww" value="Choose Restaurant">
			<input id="back" class="button" type="submit" name="Back ww" value="Back">
			<input id="submitReview" class="button" type="submit" name="Submit Review ww" value="Submit Review">
			<img id="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente"><%if(bs!=null&&bs.getUser()!=null){
					%>=bs.getUser().getUsername()<%
		}
		else{
		%>not logged<%		}	%></label>
			
			<% if(genericError){
				%><label id="genericError">please try again!</label><%
			}
				
			%>
			
			<% if(emptyReview){
				%><label id="emptyReview">Your review can't be empty!</label><%
			}
				
			%>
			
			<% if(success){
				%><label id="sucessLabel">Review successfully saved</label><%
			}
				
			%>
			
			<select id="voteScroll" name="voteScroll">
			<option value="1">1 star</option>
			<option value="2">2 stars</option>
			<option selected="selected" value="3">3 stars</option>
			<option value="4">4 stars</option>
			<option value="5">5 stars</option>
			</select>
				
			<textarea id="writeReview" name="Write Review" rows="12"></textarea>
		</form>
	</div>

</body>
</html>