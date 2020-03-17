<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
		
		<h1>Add Workout</h1>
		<div>
			<h4>Username: <security:authentication  property="principal.username" /> </h4>
		</div>
		<div class="row">
			<div class="col-md-4  ">
				<form:form action="saveWorkout" modelAttribute="workout" method="post">
					<div class="form-group">
						<!-- Need this field for updates. -->
						<form:hidden path="id" />
						<label>Name</label> <form:input path="name" class="form-control" />
						<form:errors path="name" cssClass="error"/>
						<label>Type</label> <form:input path="type" class="form-control" />
						<label>Note</label> <form:input path="note" class="form-control" />
					</div>
					<br/>
					<button type="submit" >Save</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>