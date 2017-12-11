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

<table class="datatable table table-striped dataTable" id="DataTables_Table_0" 
								role="grid" aria-describedby="DataTables_Table_0_info" style="width: 100%;">
									<thead>
										<tr>
											<c:if test="${sessionScope.type != 'patient' }">
												<th>Patient</th>
											</c:if>
											<c:if test="${sessionScope.type != 'doctor' }">
												<th>Doctor</th>
											</c:if>
											
											<th>Date</th>
											<!-- <th></th>
											<th></th> -->
										</tr>
									</thead>
									<tbody>
										<c:forEach var="apt" items="${appointments}">
											<tr role="row">
												<td>${apt.patient.user.firstName}</td>
												<td>${apt.doctor.user.firstName}</td>
												<td>${apt.aptmntDate} ${apt.aptmntTime}</td>
												
												<%-- <td><a href="update-task?id=${apt.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
												<td><a href="delete-task?id=${apt.id}"><span class="glyphicon glyphicon-trash"></span></a></td>	 --%>										</tr>
										</c:forEach>
									</tbody>
								</table>
								</body>
</html>