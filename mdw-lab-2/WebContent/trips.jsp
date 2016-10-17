<%@page import="com.melkamar.mdw.model.Trip"%>
<%@page import="com.melkamar.mdw.model.Repository"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.melkamar.mdw.model.Booking"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Trips available:</h1>
	<%
	//List<Booking> bookings = new ArrayList<Booking>();
	List<Trip> trips = Repository.getTrips();
	 %>
	 <ul>
	 <% for (Trip trip: trips){ %>
	 <li><%=trip%></li>
	 <% } %>
	 </ul>
</body>
</html>