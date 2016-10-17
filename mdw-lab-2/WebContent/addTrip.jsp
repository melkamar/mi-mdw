<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form JSP</title>
</head>
<body>
<form action="./TripServlet" method="post">
  Trip details: <br>
  Unique trip name: <input type="text" name="title"> <br/>
  Maximum capacity: <input type="text" name="capacity"> <br/>
  <br/>
  <input type="submit" value="Create trip">
</form>
</body>
</html>