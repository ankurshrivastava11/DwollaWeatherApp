<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Weather</title>
</head>
<body>

	<p>Check the Weather:</p>
	<form action="/DwollaWeatherApp/checkWeather" method="get">
		Location: <input type="text" name="location"
			placeholder="Where are you?"><br> <input type="submit"
			value="Check Weather">
	</form>

	<!-- <h2>Check Weather</h2>
	<p>Enter your Location:</p>
	<input type="text" id="location" name="location"
		placeholder="Where are you?" required="required">
	<input type="button" id="loginButton" value="Check Weather"> -->
</body>

<!-- <script language="JavaScript" type="text/javascript" src="js/weatherApp.js"></script> -->
</html>