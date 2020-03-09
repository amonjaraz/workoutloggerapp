<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Dash</title>
</head>
<body>
	<h1>User Page</h1>
	<br/>
	<div>
		Username: <security:authentication  property="principal.username" />
	</div>
	
	<form>
		<button type="submit" >Add Workout</button>
	</form>
	
</body>
</html>