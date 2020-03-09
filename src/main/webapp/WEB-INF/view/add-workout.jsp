<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Dash</title>
</head>
<body>
	<h1>Add Workout</h1>
	<br/>
	<div>
		Username: <security:authentication  property="principal.username" />
	</div>
	
	<form:form action="saveWorkout" modelAttribute="workout" method="post">
		<!-- Need this field for updates. -->
		<form:hidden path="id" />
		
		Name: <form:input path="name" />
		<form:errors path="name" cssClass="error"/>
		<br/>
		Type: <form:input path="type" />
		<br/>
		Note: <form:input path="note" />
		<br/>
		<button type="submit" >Save</button>
	</form:form>
	
</body>
</html>