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
	<tr>
		<th>
			First Name
		</th>
		<th>
			Last Name
		</th>
		<th>
			Insurance Number
		</th>
		<th>
			E-Mail
		</th>
		<th>
			Action
		</th>
	</tr>
	<tbody>
	<c:forEach items="${patientList}" var ="patient">
		<tr>
			<td>
				${patient.user.firstName}
			</td>
			<td>
				${patient.user.lastName}
			</td>
			<td>
				${patient.insuranceNum}
			</td>
			<td>
				${patient.user.email}
			</td>
			<td>

			<button type="button" class="btn btn-success" name="asdasd" id="select" onclick="select('${patient.id}');">Select</button>

		</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>

</body>
</html>