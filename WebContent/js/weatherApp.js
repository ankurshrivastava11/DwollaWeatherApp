$(document).ready(function() {
	var email = "";
	$("#viewWeather").click(function() {
		alert("Here");
		$.ajax({
	        type: "GET",
	        url: "/DwollaWeatherApp/rest/v1/cities?cityName="+location+"/weather",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        success: function (data, status, jqXHR) {
	        	console.log(data);
	        },
	
	        error: function (jqXHR, status) {
	            // error handler
	        }
		});
	});
});