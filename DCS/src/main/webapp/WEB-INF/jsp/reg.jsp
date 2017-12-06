<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sign Up | DCS</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">
    
</head>

<body>

<div class="container">

    <form method="POST" action="${contextPath}/regPatient" class="form-signin">
    
        <center><h2 class="form-heading">Dental Clinic System</h2></center>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true" /> 
            <br/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <br/>
            <input name="fisrtName" type="text" class="form-control" placeholder="Password"/>
            <br/>
            <input name="middleName" type="text" class="form-control" placeholder="FirstName"/>
            <br/>
            <input name="lastName" type="text" class="form-control" placeholder="LastName"/>
            <br/>
            <input name="email" type="text" class="form-control" placeholder="Email"/>
            <br/>
            <input name="insuranceNum" type="text" class="form-control" placeholder="Insurance NO."/>
            <br/>
            <span style="color:red">${error}</span>
            <br/>
            
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sin Up</button>
            <br/>
        </div>

    </form>

</div>
<!-- /container -->
<script src="static/js/jquery-1.11.1.min.js"></script>    
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>
