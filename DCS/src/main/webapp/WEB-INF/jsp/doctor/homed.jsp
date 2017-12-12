
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Dental Service</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <jsp:include page = "../common.jsp" />
   
   
</head>
<script>
        $("#get_patient_list").click(function(){
    		$.ajax({url: "selPatient", success: function(result){
    			 $("#patien_list").html(result);
    			 $("#select_patient_modal").modal("show");
    	    }});
    	});
	        $(function() {
	        	  $('.sorting').removeClass('sorting');
	        	  $('.sorting_asc').removeClass('sorting_asc');
	        	});
	        function get_treatment_list(){
	        	$.ajax({url: "treatmentListByPatient", success: function(result){
	    			$("#treatment_list").html(result);
	    			
	    	    }});
	        }
	        
	        function select(id){
	    		$.ajax({url: "selectPatient?id=" + id, success: function(result){
	    			$("#selected_patient").html(result);
	    			get_treatment_list();
	    			
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
                            <li class="active">${sessionScope.doctor.user.userName}</li>
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
                                <div class="title">${sessionScope.doctor.user.userName}</div>
                            </a>
                            <button type="button" class="navbar-expand-toggle pull-right visible-xs">
                                <i class="fa fa-times icon"></i>
                            </button>
                        </div>
                        
                    </div>
                    <!-- /.navbar-collapse -->
                </nav>
            </div>
            <!-- Main Content -->
            <div class="container-fluid">
                <div class="side-body padding-top">
                	<div class="row">
                		<div class="col-sm-6" style="padding-left:0px !important; padding-top:5px !important">
                		<div class="card">
							<div class="card-header">
								<div class="card-title">
                                    <div class="title">Appointments</div>
                            	</div>
							</div>
						<div class="card-body">
							<div class="row">
								<table class="datatable table table-striped dataTable" id="DataTables_Table_0" 
								role="grid" aria-describedby="DataTables_Table_0_info" style="width: 100%;">
									<thead>
										<tr>
											<th>Patient</th>
											<th>Appointment Date</th>
											<th>Appointment Time</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="aptmnt" items="${appointments}">
											<tr role="row">
												<td>${aptmnt.patient.user.firstName}</td>
												<td>${aptmnt.aptmntDate}</td>
												<td>${aptmnt.aptmntTime}</td>
												<td> <button type="button" class="btn btn-success" onclick="select('${aptmnt.patient.id}');">Select</button></td>
												<%-- <td><a href="update-task?id=${apt.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
												<td><a href="delete-task?id=${apt.id}"><span class="glyphicon glyphicon-trash"></span></a></td>	 --%>										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
                    </div>
				</div>	
				</div>
				<div class="col-sm-6" style="padding-left:0px !important; padding-top:5px !important">
                 <!--  Main contents goes here-->
					<div class="card">
						<div class="card-header">
							<div class="card-title">
                            	<div class="title">Patient information</div>
                            </div>
						</div>

						<div class="card-body">
							<div class="row">
								<div id="selected_patient">
									<c:if test="${sessionScope.type !='patient' && sessionScope.patient != null }">
										<script>
											select("${sessionScope.patient.id}");
										</script>
									</c:if>
								</div>
							</div>
                    </div>
                </div>
                </div>
             </div>
             <div class="row">
                		<div class="card">
							<div class="card-header">
								<div class="card-title">
                                    <div class="title">Treatments</div>
                            	</div>
                            	<button type="button" class="btn btn-primary"  data-toggle="modal" 
                          		data-target="#create_treatment"  style="width: 140px;float: right;margin-right: 17px; margin-top: 12px;">Create Treatment</button>
							</div>
						<div class="card-body">
							<div class="row" id="treatment_list">
								
							</div>
                    </div>
				</div>	
			
				
             </div>
            </div>
        </div>
        </div>
	<!-- make_appointment -->
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
        <footer class="app-footer">
            <div class="wrapper">
                <span class="pull-right">2.1 <a href="#"><i class="fa fa-long-arrow-up"></i></a></span>MUM-DCS ©2017 Copyright.
            </div>
        </footer>
  </div>
 
	<!-- create_treatment -->
	<div id="create_treatment" class="modal fade" role="dialog">
	  <div class="modal-dialog">
		    Create Treatment
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title" style="text-align:center">Treatment</h4>
	      </div>
	      <form method="post" action="saveTreatment" th:object="${trForm}" class="form-signin">
		      <div class="modal-body">
		      
			        <div>
			       	 	<select name="setting" class="form-control" id="selector" >
				            <c:forEach items="${teeth}" var="tooth" > 
				                <option value="${tooth.id}">${tooth.varValue}</option>
				            </c:forEach>
				        </select>   
			            <input name="symptom" type="text" class="form-control" placeholder="Symptom"  /> 
			            <br/>
      					<textarea name="treatments" class="form-control" rows="5" placeholder="Treatment"></textarea>
			            <br/>
			            <textarea name="prescription" class="form-control" rows="3" placeholder="Prescription"></textarea> 
			            <br/>
			            <textarea name="advice" class="form-control" rows="3" placeholder="Advice"></textarea>
			            <br/>
			            <div class="input-group">
			             <span class="input-group-addon">$</span>
    					<input type="text" name="price" class="form-control" placeholder="Price"/>
			            </div>
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
		
       <script>
        $("#get_patient_list").click(function(){
    		$.ajax({url: "selPatient", success: function(result){
    			 $("#patien_list").html(result);
    			 $("#select_patient_modal").modal("show");
    			
    	       
    	    }});
    	});
	        $(function() {
	        	  $('.sorting').removeClass('sorting');
	        	  $('.sorting_asc').removeClass('sorting_asc');
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
	    			$("#make_apppointment_modal").modal("hide");
	    	    }});
	    	});
        </script>
        
        
</body>

</html>
