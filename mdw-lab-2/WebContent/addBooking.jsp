<%@page import="com.melkamar.mdw.model.Trip"%>
<%@page import="com.melkamar.mdw.model.Repository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create a booking</title>
</head>
<body>
<form action="./BookingServlet" method="post">
  Booking details: <br>
  Person name: <input type="text" name="person"> <br/>
  Trip to book: <select name="trip">
  <% for (Trip trip: Repository.getAvailableTrips()){
  	String tripTitle = trip.getTitle();
   %>
  	<option value="<%=tripTitle%>"><%=tripTitle%></option>
  <% } %>
  </select>

  <br/>
  <input type="submit" value="Create booking">
</form>
</body>
</html>