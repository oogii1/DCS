<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page = "../common.jsp" />
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Dental Clinic System | Home</title>
    
    
   
</head>
<body>
<c:if test="${sessionScope.type !='patient'}">
	<button type="button" class="btn btn-primary" id="selPatient">Select Patient</button>
</c:if>
<c:if test = "${sessionScope.type !='patient' && sessionScope.patient != null }">
	<div id="selected_patient">
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
				${patient.user.lastName}
			</td>
			<td>
				${sessionScope.patient.user.firstName} ${sessionScope.patient.user.middleName} ${sessionScope.patient.user.lastName}
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
	</div>
	
</c:if>

<div id="dialog" title="Select patient"></div>

<script type="text/javascript">
var dialog;
dialog = $("#dialog").dialog({
    autoOpen: false,
    height: 600,
    width: 600,
    modal: true,
    buttons: {
      Cancel: function() {
        dialog.dialog( "close" );
      }
    },
    close: function() {
     
    }
  });
	$("#selPatient").click(function(){
		$.ajax({url: "selPatient", success: function(result){
			 $("#dialog").html(result);
			dialog.dialog( "open" );
	       
	    }});
	});
	
</script>
</body>
</html>