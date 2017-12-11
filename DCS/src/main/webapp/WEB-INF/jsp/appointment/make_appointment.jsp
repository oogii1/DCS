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
<div class="row">
<div class="col-sm-6">
	<div class="card">
			<div class="card-header" style="height:30px">
							Select Date
						</div>
						<div class="card-body" style="padding:5px">
							<input type="text" id="date" /> 
                    </div>
                </div>
                </div>
                <div class="col-sm-6">
	                <div class="card">
						<div class="card-header" style="height:30px">
	                                    Select Time
							</div>
	
							<div class="card-body"  style="padding:5px">
								<input type="text" id="time" class="datetimepicker"/>
	                    </div>
	                </div>
				</div>
				<div class="col-sm-6">
	                <div class="card">
						<div class="card-header" style="height:30px">
	                                    Select Doctor
							</div>
	
							<div class="card-body"  style="padding:5px">
								<div id="doctors"></div>
	                    </div>
	                </div>
				</div>
				<div class="col-sm-6">
	                <div class="card">
						<div class="card-header" style="height:30px">
	                                    Selected Doctor
							</div>
	
							<div class="card-body"  style="padding:5px">
								<div id="doctor_selected"></div>
	                    </div>
	                </div>
				</div>
	</div>
</body>
<script>
$( function() {
	$('#time').timepicker({
		'timeFormat': 'H:i',
		'minTime': '08:00am',
		'maxTime': '05:00pm'
		
	});

	$('#date').datepicker({
		'dateFormat': 'yy-mm-dd',
		'autoclose': true
	});
	$('#time').change(function() {
		callDoctor();
	});
	$('#date').change(function() {
		callDoctor();
	});
	
  } );
  function callDoctor(){
	  if($('#time').val() != "" && $('#date').val() != ""){
		  var date=$('#date').val();
		  var time=$('#time').val();
		  $.ajax({url: "doctorByAppointment?date="+date+"&time="+time + "", success: function(result){
 			 $("#doctors").html(result);
 	    }});
	  }
  }
  function selectDoctor(id){
	  $.ajax({url: "selectDoctor?id="+id, success: function(result){
		  $("#doctor_selected").html(result);
	    }});
  }
</script>
</html>