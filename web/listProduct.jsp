<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
	<head>
		<style>
			table, th, td
			{
			border:3px solid white;
			border-collapse: collapse;
			family-font: calibri;
			text-align: center;
			}	
			tr:nth-child(odd) {background-color:#49afff;}					
		</style>
	</head>
	<body>
		
		<%@include file="main.jsp" %>	
		<p> You are now: Viewing product list</p>
		<form action="addProduct.jsp">
	    	<input type="submit" value="Add New Products" />
		</form>
		<br>
		<form method="post" action="productList">
			<p> Search by: </p>
			<select name="search">
				<option value="" disabled selected>Select your option</option>
				<option value="companyName">Company name</option>
				<option value="productName">Product name</option>
				<option value="status">Status</option>
			</select>
			<input type="text" name="key" placeholder="Keyword">
			<input type="submit" value="Search">
		</form>
		<br>
		<br>
		<div style="overflow-x:auto;">
			<table class ="table table-bordered">
		    	<tr>
			        <td>Product name</td>
			        <td>Product type</td>
			        <td>Date created</td>
			        <td>MAC Address</td>
			        <td>Status</td>
			        <td>Date sold</td>
			        <td>Company name</td>
			        <td>Price</td>
			        <td>Password</td>
			        <td>Comments</td>
			        <td>Edit</td>
			        <td>Delete</td>
			    </tr>
	    	<c:forEach items="${products}" var="product"  varStatus="st">
	       		 <tr>
		            <td>${product.productName}</td>
		            <td>${product.type}</td>
		            <td>${product.createDate}</td>
		            <td>${product.macAddr}</td>
		            <td>${product.status}</td>
		            <td>${product.soldDate}</td>
		            <td><a href="customerGet?id=${product.customer.id}"> ${product.customer.companyName}</td>
		            <td>${product.price}</td>
		            <td>${product.password}</td>
		            <td>${product.comment}</td>
		            <td><a href="productGet?id=${product.id}"><img src="img/edit.png" width="20"></a></td>
		            <td><a href="productDelete?id=${product.id}" onclick="return confirm('Are you sure you want to delete this item?');"><img src="img/delete.png" width="20"></a></td> 
	        	</tr>
	    	</c:forEach>
			</table>
		</div>
	</body>
</html>




