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
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	</head>
<body>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		
		<h1>Workout List</h1>
		<br/>
		<div>
			<h4>Username: <security:authentication  property="principal.username" /> </h4>
		</div>
		
		<table class="table table-hover">
			<c:forEach var="tempWorkout" items="${workouts}">
				<c:url var="detailLink" value="/user/workout">
					<c:param name="workoutId" value="${tempWorkout.id}" />
				</c:url>
				<c:url var="editLink" value="/user/editWorkout">
					<c:param name="workoutId" value="${tempWorkout.id}" />
				</c:url>
				<tr >
					<td>${tempWorkout.name} - ${tempWorkout.type} </td>
					<td><a href="${detailLink }">Details</a>|<a href="${editLink }">Edit</a></td>
				 </tr>
				
			</c:forEach>
		</table>

		<form:form action="addWorkout" method="GET">
			<button class="btn btn-default" type="submit" >Add Workout</button>
		</form:form>
	</div>
</body>
</html>