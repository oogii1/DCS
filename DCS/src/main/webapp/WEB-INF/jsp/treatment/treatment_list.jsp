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

	<table class="datatable table table-striped dataTable"
		id="DataTables_Table_0" role="grid"
		aria-describedby="DataTables_Table_0_info" style="width: 100%;">
		<thead>
			<tr>
				<th>Tooth No</th>
				<th>Symptom</th>
				<th>Treatment</th>
				<th>Prescription</th>
				<th>Advice</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="treatment" items="${treatments}">
				<tr role="row">
					<td>${treatment.setting.varValue}</td>
					<td>${treatment.symptom}</td>
					<td>${treatment.treatments}</td>
					<td>${treatment.prescription}</td>
					<td>${treatment.advice}</td>
					<td>${treatment.price}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</body>
</html>