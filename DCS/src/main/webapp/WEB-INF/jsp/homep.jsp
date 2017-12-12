
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Dental Service</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page = "common.jsp" />
</head>
<script>
     
	        $(function() {
	        	  $('.sorting').removeClass('sorting');
	        	  $('.sorting_asc').removeClass('sorting_asc');
	        	});
	        function get_appointment_list(){
	        	$.ajax({url: "appointmentListByPatient", success: function(result){
	    			$("#appointment_list").html(result);
	    			
	    	    }});
	        }
        </script>
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
                                    <button type="button" class="btn btn-primary"
                          		style="width: 160px;float: right;margin-right: 17px; margin-top: 12px;" id="make_appointment">Make Appointment</button>
						</div>

						<div class="card-body">
							<div class="row">
								<div id="appointment_list"></div>
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
        <div id="make_apppointment_modal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
		    Make appointment
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title" style="text-align:center">Create an Appointment</h4>
	      </div>
		      <div class="modal-body" id="make_appointment_body">
		      	
		      </div>
		      <div class="modal-footer">
		      	<button class="btn btn-primary" type="button" id="save_appointment">Make</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
	    </div>
  		</div>
	</div>

        
        
        <script>
	        $(function() {
	        	  $('.sorting').removeClass('sorting');
	        	  $('.sorting_asc').removeClass('sorting_asc');
	        	  get_appointment_list()
	        	});
	        $("#make_appointment").click(function(){
	    		$.ajax({url: "makeAppointment", success: function(result){
	    			 $("#make_appointment_body").html(result);
	    			 $("#make_apppointment_modal").modal("show");
	    			 
	    	       
	    	    }});
	    	});
	        $("#save_appointment").click(function(){
	        	var date=$('#date').val();
    			var time=$('#time').val();
	    		$.ajax({url: "saveAppointment?date="+date+"&time="+time + "", success: function(result){
	    			$("#created").html(result);
	    			get_appointment_list();
	    			$("#make_apppointment_modal").modal("hide");
	    	    }});
	    	});
	        
        </script>
</body>

</html>
