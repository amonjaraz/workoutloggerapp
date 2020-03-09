<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	
	<ul>
		<c:forEach var="tempWorkout" items="${workouts}">
			<li>${tempWorkout.name} - ${tempWorkout.type}</li>
			<button>Open</button>
		</c:forEach>
	</ul>

	
	
	<form:form action="user/addWorkout" method="GET">
		<button type="submit" >Add Workout</button>
	</form:form>
	
</body>
</html>