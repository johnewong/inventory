<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style>
	table, th, td
			{
			border:1px solid white;
			border-collapse: collapse;
			family-font: calibri;
			}	
			tr:nth-child(odd) {background-color:#49afff;}	
	</style>
	
	</head>
	<body>
	<%@include file="main.jsp"%>
	<p>You are now: Updating item </p>
	<form method="post" action="/itemEdit">
	<table align='center' border='1' cellspacing='0'>
	<table class="table table-bordered">
			<tr>
				<td>Name</td>
				<td>Description</td>
				<td>Category</td>
<<<<<<< HEAD
				<td>Safety stock</td>
				<td>Current stock</td>
				<td>Cost (USD)</td>
=======
				<td>Safety Stock</td>
				<td>Stock</td>
				<td>Price</td>
>>>>>>> 68b8e70d83eba35516efcbe85d270c74b0877959
			</tr>
		
			<input name="id" type="text" value="${item.id}" hidden/>
<<<<<<< HEAD
			<td><input type="text" name="name" value="${item.name}" maxlength="20" size="20" requried/></td>
			<td><input type="text" name="description" value="${item.desc}" maxlength="20" size="12" requried/></td>
			<td><input type="text" name="category" value="${item.category}" maxlength="20" size="12" requried/></td>
=======
			<td><input type="text" name="name" value="${item.name}" maxlength="12" size="12" requried/></td>
			<td><input type="text" name="description" value="${item.desc}" maxlength="12" size="12" requried/></td>
			<td><input type="text" name="category" value="${item.category}" maxlength="12" size="12" requried/></td>
>>>>>>> 68b8e70d83eba35516efcbe85d270c74b0877959
			<td><input type="text" name="safetyStock" value="${item.safetyStock}" requried/></td>
			<td><input type="text" name="stock" value="${item.stock}" requried/></td>
			<td><input type="text" name="price" value="${item.price}" requried/></td>
			</tr>
			
		</table>
		<input type="reset" value="Reset">
		<input type="submit" value="Update">
	</form>

	</body>
</html>