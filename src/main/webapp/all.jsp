<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All User Page</title>
</head>
<body>
	<h1>All user</h1>
	<%
	ResultSet rs=(ResultSet)request.getAttribute("abc");
	while(rs.next()){
	%>
	<h3> <%=  rs.getString(1) %> </h3>
	<h3> <%=  rs.getString(2) %> </h3>
	<h3> <%=  rs.getString(3) %> </h3>
	<h3> <%=  rs.getString(4) %> </h3>
	<h3> <%=  rs.getString(5) %> </h3>
	<br>
	<hr>

	<%}%>
</body>
</html>