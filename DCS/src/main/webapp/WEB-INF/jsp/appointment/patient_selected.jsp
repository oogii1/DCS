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
    
</head>
<body>
	<table>
		<tr>
			<td>
				Name
			</td>
			<td>
				${patient.user.firstName} ${patient.user.middleName} ${patient.user.lastName}
			</td>
		</tr>
		<tr>
			<td>
				User name
			</td>
			<td>
				${sessionScope.patient.user.userName}
			</td>
		</tr>
		<tr>
			<td>
				Insurance Number 
			</td>
			<td>
				${sessionScope.patient.insuranceNum}
			</td>
		</tr>
		<tr>
			<td>
				E-Mail
			</td>
			<td>
				${sessionScope.patient.user.email}
			</td>
		</tr>
		
		
	</table>
</body>
</html>