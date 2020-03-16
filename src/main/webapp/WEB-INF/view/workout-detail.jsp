
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>

	<title>User Dash</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
	     google.charts.load('current', {'packages':['corechart']});
	     google.charts.setOnLoadCallback(drawWeightChart);
	     google.charts.setOnLoadCallback(drawQuantityChart);
	     google.charts.setOnLoadCallback(drawWeightQuantityChart);
	     function drawWeightChart() {
	       var data = google.visualization.arrayToDataTable([
	         ['Year', 'Sales'],
	         <c:forEach var="workoutSet" items="${workoutSets}">
	         	[new Date("${workoutSet.created}"), ${workoutSet.weight}],
	         </c:forEach>

	       ]);
	
	       var options = {
	         title: 'Weight Over Time',
	         curveType: 'function',
	         legend: 'none',
	          hAxis: {title: 'Reps'},
	          vAxis: {title: 'Weight'},
	       };
	
	       var chart = new google.visualization.ScatterChart(document.getElementById('curve_chart_weight'));
	
	       chart.draw(data, options);
	     }
	     function drawQuantityChart() {
		       var data = google.visualization.arrayToDataTable([
		         ['Year', 'Sales'],
		         <c:forEach var="workoutSet" items="${workoutSets}">
		         	[new Date("${workoutSet.created}"), ${workoutSet.quantity}],
		         </c:forEach>

		       ]);
		
		       var options = {
		         title: 'Reps Over Time',
		         curveType: 'function',
		         legend: 'none',
		          hAxis: {title: 'Date'},
		          vAxis: {title: 'Reps'},
		       };
		
		       var chart = new google.visualization.ScatterChart(document.getElementById('curve_chart_quantity'));
		
		       chart.draw(data, options);
		     }
	     function drawWeightQuantityChart() {
		       var data = google.visualization.arrayToDataTable([
		         ['quantity', 'weight'],
		         <c:forEach var="workoutSet" items="${workoutSets}">
		         	[ ${workoutSet.quantity}, ${workoutSet.weight}],
		         </c:forEach>

		       ]);
		
		       var options = {
		         title: 'Quantity V Weight',
		         curveType: 'function',
		         legend: 'none',
		          hAxis: {title: 'Reps'},
		          vAxis: {title: 'Weight'},
		       };
		
		       var chart = new google.visualization.ScatterChart(document.getElementById('curve_chart_quantity_weight'));
		
		       chart.draw(data, options);
		     }
	   </script>
</head>
<body>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		
		<h1>Workout Details</h1>
		<h2>${workout.name} - ${workout.type }</h2>
		<br/>
		<div class="row">
			<div class="col-md-4">
				<form:form action="workout/addSet?workoutId=${workout.id}"  modelAttribute="workoutSet" method="post">
					<div class="form-group">
					<label>Weight</label> <form:input path="weight" class="form-control"/>
					<label>Reps</label> <form:input path="quantity" class="form-control"/>
					</div>
					
					<button class="btn btn-primary" type="submit" >Add Set</button>
				</form:form>
			</div>
		</div>
		
	    <div style="width: 100%;">
	        <div id="curve_chart_weight"></div>
	    </div>
	    <div style="width: 100%;">
	        <div id="curve_chart_quantity"></div>
	    </div>
	    <div style="width: 100%;">
	        <div id="curve_chart_quantity_weight"></div>
	    </div>
	    <br/>
	   	<table class="table table-bordered">
	 			<tr>
					<th>Date</th>
					<th>Weight</th>
					<th>Reps</th>
				</tr>
			<c:forEach var="workoutSet" items="${workoutSets}">
				<tr>
					<td>${workoutSet.created}</td>
					<td>${workoutSet.weight} </td>
					<td>${workoutSet.quantity} </td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>