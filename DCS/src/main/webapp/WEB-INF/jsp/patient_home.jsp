<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Dental Clinic System | Home</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Dental Clinic System</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${contextPath}/loginPage">Sign in</a></li>
					<li><a href="${contextPath}/regPage">Sign up</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="row">
	  <div class="col-sm-5">
	  		<div class="row" id="reactionHistoryDiv">
	  			<div class="panel panel-success">
			      <div class="panel-heading">Your Reaction History</div>
			      <table class="table table-sm table-bordered text-center table-sm">
					<thead>
						<tr>
							<th>Medicine Name</th>
							<th>Reaction</th>
							<th>Date Inserted</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="reaction" items="${reactions}">
							<tr>
								<td>${reaction.medicineName}</td>
								<td>${reaction.reaction}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${reaction.insertDate}"/></td>
								<td><a href="update-task?id=${reaction.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
								<td><a href="delete-task?id=${reaction.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			    </div>
			</div>
	  		<div class="row" id="medicineHistory">
	  			<div class="panel panel-success">
			      <div class="panel-heading">Your Medicine History</div>
			      <table class="table table-sm table-bordered text-center">
					<thead>
						<tr>
							<th>Medicine Name</th>
							<th>Dosage</th>
							<th>Start Date</th>
							<th>Date Inserted</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="med" items="${medicines}">
							<tr>
								<td>${med.medicineName}</td>
								<td>${med.dosage}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${med.startDate}"/></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${med.insertDate}"/></td>
								<td><a href="update-task?id=${reaction.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
								<td><a href="delete-task?id=${reaction.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			    </div>
			</div>
	  </div>
	  <div class="col-sm-5">
	  	<div class="row">
	  		<table class="table table-sm table-bordered text-center">
				<thead>
					<tr>
						<th>Sympton</th>
						<th>Treatment</th>
						<th>Prescription</th>
						<th>Advice</th>
						<th>Price</th>
						<th>ToothNo</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="treatment" items="${treatments}">
						<tr>
							<td>${treatment.symptom}</td>
							<td>${treatment.treatment}</td>
							<td>${treatment.prescription}</td>
							<td>${treatment.advice}</td>
							<td>${treatment.price}</td>
							<td>${treatment.setting.varValue}</td>
							<td><a href="update-task?id=${reaction.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a href="delete-task?id=${reaction.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	  	</div>
	  	<div class="row">
	  		<table class="table table-sm table-bordered text-center">
				<thead>
					<tr>
						<th>Sympton</th>
						<th>Treatment</th>
						<th>Prescription</th>
						<th>Advice</th>
						<th>Price</th>
						<th>ToothNo</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="apt" items="${appointments}">
						<tr>
							<td>${treatment.symptom}</td>
							<td>${treatment.treatment}</td>
							<td>${treatment.prescription}</td>
							<td>${treatment.advice}</td>
							<td>${treatment.price}</td>
							<td>${treatment.setting.varValue}</td>
							<td><a href="update-task?id=${reaction.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a href="delete-task?id=${reaction.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	  	</div>
	  </div>
	</div>
	
	<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
</body>
</html>