<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page = "../common.jsp" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Reception Center</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">
    
</head>

<body>
<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Dental Clinic System</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${contextPath}/logOut">Log Out</a></li>
					
				</ul>
			</div>
		</div>
	</div>

<div class="container">
	<div class="row">
  		<div class="col-lg-4">
  			<input type="button" name="Create Appointment" value="Create Appointment" onclick="createApp();">	
  		</div>
 		<div class="col-lg-4">.col-sm-4</div>
  		<div class="col-lg-4">.col-sm-4</div>
</div>
</div>
<!-- /container -->
<script src="static/js/jquery-1.11.1.min.js"></script>    
<script src="static/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function createApp(){
		window.open("createAppointment");
	}
</script>
</body>
</html>
