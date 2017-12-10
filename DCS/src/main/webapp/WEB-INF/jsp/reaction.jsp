
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
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Log out
                             <span class="caret"></span></a>
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
                            <li>
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
                            <li class="active">
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
                             <div class="title">My Reaction Forms</div> </div>
                             <button type="button" class="btn btn-primary" data-toggle="modal" 
                             data-target="#add_reaction" style="width: 55px;float: right;margin-right: 17px; margin-top: 12px;">Add</button>
						</div>

						<div class="card-body">
							<div class="row">
								<table class="datatable table table-striped dataTable" id="DataTables_Table_0" 
								role="grid" aria-describedby="DataTables_Table_0_info" style="width: 100%;">
									<thead>
										<tr>
											<th>Medicine Name</th>
											<th>Reaction</th>
											<th>Date Inserted</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="reaction" items="${reactions}">
											<tr role="row">
												<td>${reaction.medicineName}</td>
												<td>${reaction.reaction}</td>
												<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${reaction.insertDate}"/></td>
												<td> 
													<a href="#" id="updateReaction" 
														data-id="${reaction.id}" 
														data-patientId="${user.id}"
														data-medname="${reaction.medicineName}"
														data-reaction="${reaction.reaction}">
														<span class="glyphicon glyphicon-pencil"></span>
													</a>
													&nbsp;&nbsp;&nbsp;	
													<a href="${contextPath}/reaction/delete?patientId=${user.id}&recId=${reaction.id}" onclick="return confirm('Are you sure you want to delete?');">
														<span class="glyphicon glyphicon-trash"></span>
													</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
                    </div>
                </div>
            </div>
        </div>
	
	<!-- add_reaction -->
	<div id="add_reaction" class="modal fade" role="dialog">
	  <div class="modal-dialog">
		    Add Reaction Form
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title" style="text-align:center">Add Your Reaction Form</h4>
	      </div>
	      <form method="POST" action="${contextPath}/reaction/save" th:object="${reaForm}" class="form-signin">
		      <div class="modal-body">
			        <div>
			       	 	<input type="hidden" name = "patientId" value ="${user.id}">
			       	 	
			            <input name="medicineName" th:field="*{userName}" type="text" class="form-control" placeholder="Medicine Name" autofocus="true" /> 
			            <br/>
			            <input name="reaction" th:field="*{fisrtName}" type="text" class="form-control" placeholder="Reaction"/>
			            <br/>
			        </div>
		      </div>
		      <div class="modal-footer">
		      	<button class="btn btn-primary" type="submit">Save</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
	      </form>
	    </div>
  		</div>
	</div>
	
	<!-- update_reaction -->
	<div id="update_reaction" class="modal fade" role="dialog">
	  <div class="modal-dialog">
		    Add Reaction Form
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title" style="text-align:center">Update Your Reaction Form</h4>
	      </div>
	      <form method="POST" action="${contextPath}/reaction/update" th:object="${reaForm}" class="form-signin">
		      <div class="modal-body">
			        <div>
			        		<input id="uptId" type="hidden" name = "id">
			       	 	<input id="uptPatientId" type="hidden" name = "patientId" value ="${user.id}">
			            <input id="uptMedName" name="medicineName" th:field="*{userName}" type="text" 
			            		class="form-control" placeholder="Medicine Name" autofocus="true" /> 
			            <br/>
			            <input id="uptReaction" name="reaction" th:field="*{fisrtName}" type="text" class="form-control" placeholder="Reaction"/>
			            <br/>
			        </div>
		      </div>
		      <div class="modal-footer">
		      	<button class="btn btn-primary" type="submit">Update</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
	      </form>
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
	        	  $("#updateReaction").click(function(){
	        		  $("#uptId").val($(this).attr("data-id"));
	        		  $("#uptPatientId").val($(this).attr("data-patientId"));
	        		  $("#uptMedName").val($(this).attr("data-medname"));
	        		  $("#uptReaction").val($(this).attr("data-reaction"));
	        		  $('#update_reaction').modal('show');
	        		}); 
	        	});
        </script>
</body>

</html>
