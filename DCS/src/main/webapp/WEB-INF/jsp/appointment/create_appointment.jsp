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
<c:if test="${patient!=null}">

</c:if>
<table>
	<tr>
		<td>
			First Name
		</td>
		<td>
			Last Name
		</td>
		<td>
		</td>
		<td>
		</td>
	</tr>

	<c:forEach items="${patientList}" var ="patient">
		<tr>
			<td>
				${patient.user.firstName}
			</td>
			<td>
				${patient.user.lastName}
			</td>
			<td>
				${patient.user.ssn}
			</td>
			<td>
				${patient.user.firstName}
			</td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>