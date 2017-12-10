
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Dental Service</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- CSS Libs -->
    <link rel="stylesheet" type="text/css" href="static/css/default/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/default/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/default/animate.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/default/bootstrap-switch.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/default/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/default/dataTables.bootstrap.css">
    <link type="text/css" href="static/css/default/jquery-ui.css" rel="stylesheet" />
    <!-- CSS App -->
    <link rel="stylesheet" type="text/css" href="static/css/style.css">
    <link rel="stylesheet" type="text/css" href="static/css/themes/flat-blue.css">
</head>

<body class="flat-blue">
    <div class="app-container">
        <div class="row content-container">
            <nav class="navbar navbar-default navbar-fixed-top navbar-top">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-expand-toggle">
                            <i class="fa fa-bars icon"></i>
                        </button>
                        <ol class="breadcrumb navbar-breadcrumb">
                            <li class="active">${user.userName}</li>
                        </ol>
                        <button type="button" class="navbar-right-expand-toggle pull-right visible-xs">
                            <i class="fa fa-th icon"></i>
                        </button>
                    </div>
                    <ul class="nav navbar-nav navbar-right">

                        <li class="dropdown profile">
                            <a href="${contextPath}/loginPage" class="dropdown-toggle"  role="button" aria-expanded="false">Log out
                             <span class="caret"></span>
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="side-menu sidebar-inverse">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="side-menu-container">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">
                                <div class="icon fa fa-paper-plane"></div>
                                <div class="title">${user.userName}</div>
                            </a>
                            <button type="button" class="navbar-expand-toggle pull-right visible-xs">
                                <i class="fa fa-times icon"></i>
                            </button>
                        </div>
                        <ul class="nav navbar-nav">
                            <li class="active">
                                <a href="${contextPath}/patientHome?uid=${user.id}">
                                    <span class="icon fa fa-tachometer"></span>
                                    <span class="title">Appointments</span>
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/myTreatments?uid=${user.id}">
                                    <span class="icon fa fa-file-text-o"></span><span class="title">Treatments</span>
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/myReactions?uid=${user.id}">
                                    <span class="icon fa fa-file-text-o"></span><span class="title">Reaction History</span>
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/myMedHistory?uid=${user.id}">
                                    <span class="icon fa fa-file-text-o"></span><span class="title">Medicine History</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </nav>
            </div>
            <!-- Main Content -->
            <div class="container-fluid" id>
                <div class="side-body padding-top">
                    <div class="row">
                        <!--  Main contents goes here-->
						<div class="card">
						<div class="card-header">
							<div class="card-title">
                                    <div class="title">My Appointments</div>
                                    </div>
						</div>

						<div class="card-body">
							<div class="row">
								<table class="datatable table table-striped dataTable" id="DataTables_Table_0" 
								role="grid" aria-describedby="DataTables_Table_0_info" style="width: 100%;">
									<thead>
										<tr>
											<th>Sympton</th>
											<th>Treatment</th>
											<th>Prescription</th>
											<th>Tooth No</th>
											<th>Appointment Date</th>
											<th>Appointment Time</th>
											<!-- <th></th>
											<th></th> -->
										</tr>
									</thead>
									<tbody>
										<c:forEach var="apt" items="${appointments}">
											<tr role="row">
												<td>${apt.symptom}</td>
												<td>${apt.treatment}</td>
												<td>${apt.prescription}</td>
												<td>${apt.sourceType.varValue}</td>
												<td>${apt.aptmntDate}</td>
												<td>${apt.aptmntTime}</td>
												<%-- <td><a href="update-task?id=${apt.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
												<td><a href="delete-task?id=${apt.id}"><span class="glyphicon glyphicon-trash"></span></a></td>	 --%>										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
                    </div>
                </div>
            </div>
        </div>

        <footer class="app-footer">
            <div class="wrapper">
                <span class="pull-right">2.1 <a href="#"><i class="fa fa-long-arrow-up"></i></a></span>MUM-DCS ©2017 Copyright.
            </div>
        </footer>

        <!-- Javascript Libs -->
        <script type="text/javascript" src="static/Scripts/default/jquery.min.js"></script>
        <script type="text/javascript" src="static/Scripts/default/jquery-ui.min.js"></script>
        <script type="text/javascript" src="static/Scripts/default/bootstrap.min.js"></script>
        <script type="text/javascript" src="static/Scripts/default/bootstrap-switch.min.js"></script>
        <script type="text/javascript" src="static/Scripts/default/jquery.matchHeight-min.js"></script>
        <script type="text/javascript" src="static/Scripts/default/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="static/Scripts/default/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript" src="static/Scripts/default/select2.full.min.js"></script>
        <!-- Javascript -->
        <script type="text/javascript" src="static/Scripts/app.js"></script>
        
        <script>
	        $(function() {
	        	  $('.sorting').removeClass('sorting');
	        	  $('.sorting_asc').removeClass('sorting_asc');
	        	});
        </script>
</body>

</html>
