<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 7. 6. - 오전 8:06:05</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">

<link rel="stylesheet" 	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>

<h3>ex02.jsp</h3>

<div id="map" style="width: 100%; height: 500px;"></div>

	<script> 
		var lat = 37.49935854213284;
		var lng = 127.03320798504977;

		function myMap() { 
			var mapCanvas = document.getElementById("map");
			var myCenter = new google.maps.LatLng(lat, lng); // 
			var mapOptions = {
				center : myCenter,
				zoom : 15
			};
			var map = new google.maps.Map(mapCanvas, mapOptions);
			 
			google.maps.event.addListener(map, 'click', function(event) { 
				placeMarker(map, event.latLng); 
				$('#h_lng').val(event.latLng.lng());
				$('#h_lat').val(event.latLng.lat()); 
				$("#myModal").modal("show"); 
			});
		}

		function placeMarker(map, location) {
			 
			marker = new google.maps.Marker({
				position : location,  
				map : map
			});
			// 
			var infowindow = new google.maps.InfoWindow({
				content : 'Latitude: ' + location.lat() + '<br>Longitude: '
						+ location.lng()
			});

			infowindow.open(map, marker);
		}
	</script>

	<script	src="https://maps.googleapis.com/maps/api/js?key=&callback=myMap"></script>

    <!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog" style="width: 350px">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">위치 정보 입력</h4>
				</div>
				<div class="modal-body"> 
					<div style="text-align: center">
						<form id="form1" action="ex02_oracle_input_ok.jsp" method="post">
							<table style="width:300px;text-align: center" border="1">
							
								<tr><td>ID</td></tr>
								<tr><td><input type="text" name="id" value="100"></td></tr>
								<tr><td>TYPE</td></tr>
								<tr><td><input type="text" name="type" value="restaurant or bar"></td></tr>
								<tr><td>NAME</td></tr>
								<tr><td><input type="text" name="name" value="admin"></td></tr>
								<tr><td>ADDRESS</td></tr>
								<tr><td><input type="text" name="address" value="seoul"></td></tr>
								<tr>
									<td><input type="button" id="btnSave" value="저장"></td>
								</tr>
							</table>
	<input type="hidden" id="h_lat" name="lat" value="" />
	<input type="hidden" id="h_lng" name="lng" value="" />
						</form>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" onclick="modal_close();" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>

<script>
   $("#btnSave").click(function (){
	   if( confirm("정말 저장합니까?") ){
		 $("#form1").submit();
	   } // if
    }); // click
    
    function modal_close(){
    	if( typeof marker != 'undefined') {
    		marker.setMap(null);  // 마커 삭제....
    	} // if
    } // modal_close
</script>

</body>
</html>

<!--
create table googlemap
	(
	  id number primary key  -- 100/101/102
	   ,type varchar2(20)
	   , name varchar2(30)
	   , lng number
	   , lat number
	   , address varchar2(255)
	);
-->