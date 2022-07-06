<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 7. 6. - 오전 8:06:31</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
#map {
	height: 100%;
}

html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>

<h3>ex01_oralce_json.jsp</h3> 
 <button id="btnDeleteMarkers">delete marker</button>
 <br>
 <div id="map"></div>
 
<script>
		var customLabel = {
			restaurant : {
				label : 'R'
			},
			bar : {
				label : 'B'
			}
		};

		var markers = [];
		
		function myMap() {  // myMap
			// 1.  한독빌딩
			var   lat = 37.49935854213284;
			var   lng=127.03320798504977;
			
			var map = new google.maps.Map(document.getElementById('map'), {
				center : new google.maps.LatLng(lat, lng),
				zoom : 15
			});
            // 2.
			var infoWindow = new google.maps.InfoWindow;
            // 3. 
			var params = null;
			$.ajax({
				url : "ex02_oracle_json_data.jsp",
				dataType : "json",
				type : "get",
				data : params,
				cache : false,
				success : function(data) { //  []
				// data == [{"id":100,"type":"restaurant","name":"admin","lng":127.03432487024399,"lat":37.49937084987687,"address":"seoul"},{"id":200,"type":"bar","name":"admin","lng":127.03231042642815,"lat":37.49895800057274,"address":"seoul"}]
					$(data).each(
							function(index, e) {
								// id, type,name, lng,lat,address
								var id = e.id;
								var name = e.name;
								var address = e.address;
								var type = e.type;
								var point = new google.maps.LatLng(
										parseFloat(e.lat), parseFloat(e.lng));

								var infowincontent = $("<div />");
								var strong = $("<strong />").html(name);
						 		infowincontent.append(strong).append($("<br>"));

								var text = document.createElement('text');
								text.textContent = address;
						 		infowincontent.append(text);
						 		
								var icon = customLabel[type] || {};

								var marker = new google.maps.Marker({
									map : map,
									position : point,
									label : icon.label
								});
								
								marker.addListener('click', function() {
									infoWindow.setContent(infowincontent.html());
									infoWindow.open(map, marker);
								});

								markers.push(marker);
							}); // each
				}
			}); // ajax 
			
			// 4. 조금 있다가~~ 
			//                           map 객체에 tilesloaded 이벤트가 발생하면
			//                                      [타일]이 로딩된 후에 발생하는 이벤트
			google.maps.event.addListener(map, 'tilesloaded', function() {
				
				console.log( " titlesloaded event ...");
				
				SWlongitude=map.getBounds().getSouthWest().lng();
				SWlatitude=map.getBounds().getSouthWest().lat();
				NElongitude=map.getBounds().getNorthEast().lng();
				NElatitude=map.getBounds().getNorthEast().lat();
				zoomLevel=map.getZoom();
				console.log("가로(경도) : "+SWlongitude+"/가로(위도) :"+SWlatitude
						+"/세로(경도) :"+NElongitude+"/세로(위도) :"+NElatitude);
				
				// 이 범위에 있는 마커 ajax select에서  이전 마커 삭제 후  마커 출력하면 된다. - 재민아...
				// select id, type,name, lng,lat,address from googlemap
				// where 위의 바운드 위도,경도 안에 있는 
			});

			// 5. 
			$("#btnDeleteMarkers").click(function (){
				for (var i = 0; i < markers.length; i++) {
					markers[i].setMap(null);
				}
			});
		}
	</script>
 
 <script async="true" defer src="https://maps.googleapis.com/maps/api/js?key=&callback=myMap">
 </script>

</body>
</html>