<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<div class="bg"></div>
	<div class="welcome_title"><h1>Automotive Parking</h1></div>
	<div class="form-group">
			<frm:form modelAttribute="car" method="GET" acceptCharset="UTF-8"	action="puzzleResult">
				<input type="text" class="form-control" style ="margin-bottom: 20px;" id="grid" name="grid" placeholder="Default gridsize: 15 15">
				<input type="text" class="form-control" style ="margin-bottom: 20px;"id="coordinate" name="coordinate" placeholder="Default coordinates: 1 1">
				<input type="text" class="form-control" style ="margin-bottom: 20px;"id="commands" name="commands" placeholder="Commands">
				<div data-toggle="buttons">
				      <label class="btn">
				        <input type="radio" name="direction" id="direction" value ="North" checked=""> North
				      </label>
				      <label class="btn ">
				        <input type="radio" name="direction" id="direction" value ="East"> East
				      </label>
				      <label class="btn ">
				        <input type="radio" name="direction" id="direction" value ="West"> West
				      </label>
				      <label class="btn ">
				        <input type="radio" name="direction" id="direction" value ="South"> South
				      </label>
				</div>
				<button type="Submit" name="action" class= "sub btn-danger"
									value="updateParkingGrid" class="btn btn-orange btn-xl ">Submit</button>
			</frm:form>
		</div>
</body>
<link rel="stylesheet" type="text/css" href="resources/css/custom.css" >
 <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="resources/js/bootstrap.min.js"> 
</html>

