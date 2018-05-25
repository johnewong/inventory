<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<head>
<body>
<b>Online User: ${online_number}</b>
<b>User: ${userName}<b> 
<form>
<table align='center' border='1' cellspacing='0'>
	<tr>
		<td>Id</td>
		<td>Name</td>
		<td>Description</td>
		<td>Category</td>
		<td>Status</td>
		<td>Safety Stock</td>
		<td>Stock</td>
		<td>Price</td>
		<td>Total</td>
		<td>Create Date</td>
		<td>Edit</td>
		<td>Delete</td>
	</tr>
	
	 <c:forEach items="${items}" var="item" varStatus="st">
		<tr>
		<td>${item.id}</td>
		<td>${item.name}</td>
		<td>${item.desc}</td>
		<td>${item.category}</td>
		<td>${item.status}</td>
		<td>${item.safetyStock}</td>
		<td>${item.stock}</td>
		<td>${item.price}</td>
		<td>${(item.price)*(item.stock)}</td>
		<td>${item.createDate}</td>
		<td><a href="itemGet?id=${item.id}">edit</a></td>
        <td><a href="itemDelete?id=${item.id}" onclick="return confirm('Are you sure you want to delete this item?');">delete</a></td> 		
		</tr>
	</c:forEach>
</table>
</form>

<form action="addItem.html">
    	<input type="submit" value="Add Item" />
</form>
<form action="/productList">
    	<input type="submit" value="Go ProductList" />
</form>
<form action="/customerList">
    	<input type="submit" value="Go CustomerList" />
</form>