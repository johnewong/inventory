<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<head>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
	table, th, td
			{
			border:3px solid white;
			border-collapse: collapse;
			family-font: calibri;
			}	
			tr:nth-child(odd) {background-color:#49afff;}	
</style>
	
</head>
	<body>
		<%@include file="main.jsp" %>
		<%@include file ="choices.jsp"%>
		<p> You are now: Adding new product</p><br>
		<form method="post" action="productAdd">
		
		<div style="overflow-x:auto">
		<table class ="table table-bordered">
			<tr>
				<td>
					Product name: <input type="text" placeholder="Enter product name" name="productName" required>
				</td>
				<td>
					Antenna type: <select name="type" required>
					<option value="opt" disabled selected>Select your option</option>
					<option value="internal">Internal</option>
					<option value="external">External </option>
					<option value="other">Others</option> 
					</select>
				</td>
			
				<!-- <input type="" name="createDate" value=""> --> 
				<td>
					MAC Address: <input type="text" placeholder="xx:xx:xx:xx:xx:xx" name="macAddr" required>
				</td>
				<td>
					Status: <select name="status" required>
					
					<option value="available" disabled selected>Available</option>
					
					</select>
				</td>
				<td>
					Password: <input type="password" placeholder="Enter Password" name="password" required>
				</td>
				<td>
					Comment: <input type="text" placeholder="Enter Comment" name="comment">
				</td>
			</tr>
		</table>
		</div>
		<button type="submit">Add</button>
	</body>
</html>