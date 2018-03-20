<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<div class="bg"></div>
	<div class="welcome_title"><h1><u>Automotive Parking </u></h1></div>
	<div class = "result">
	<h1> Grid Size:						"${Grid}"</h1>
	<h1> Direction of the Car:			"${Direction}"</h1>
	<h1> Initial Car Position:			"${Coordinates}"</h1>
	<h1> Command you gave:				"${Command}"</h1>
	<h1> We should get the position:	"${Result}"</h1>
	</div>
	<input  type="button" onclick="location.href='/AutoParking/puzzle';" class="back_button btn btn-danger" value ="Done" />
</body>
<link rel="stylesheet" type="text/css" href="resources/css/custom.css" >
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="resources/js/bootstrap.min.js"> 
</html>

