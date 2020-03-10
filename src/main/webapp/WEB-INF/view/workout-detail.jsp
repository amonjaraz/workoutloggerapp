
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>

<title>User Dash</title>
</head>
<body>
	<h1>Workout Details</h1>
	<h2>${workout.name} - ${workout.type }</h2>
	<br/>
	<div>
		<form:form action="workout/addSet?workoutId=${workout.id}"  modelAttribute="workoutSet" method="post">
			
			weight <form:input path="weight"/>
			quanity <form:input path="quantity"/>
			<button type="submit" >Add Set</button>
		</form:form>
	</div>
	<ul>
		<c:forEach var="workoutSet" items="${workoutSets}">
			<li>${workoutSet.weight} | ${workoutSet.quantity}</li>
		</c:forEach>
	</ul>

	<a href="/user">user</a>
	
</body>
</html>