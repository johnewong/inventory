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
			
			}	
			tr:nth-child(odd) {background-color:#49afff;}		
		</style>
	</head>
	<body>
		<%@include file="main.jsp" %>
		<p> You are now: Viewing customer list</p>
		<form action="addCustomer.jsp">
			<input type="submit" value="Add New Customer" />
		</form>
		<br>
		<p> Search by:</p>
		<form method="post" action="customerList">
			<select name="search">
				<option value=""disabled selected>Select your option</option>
				<option value="companyName">Company</option>
				<option value="contactName">ContactName</option>
				<option value="status">Status</option>
			</select>
			<input type="text" name="key" placeholder="Keyword">
			<input type="submit" value="Search">
		</form>
		<br>
		<br>
		<form>
			<div style="overflow-x:auto;">
			<table class ="table table-bordered">
					<tr>
						<th>Company name</th>
						<th>Contact name</th>
						<th>Contact number</th>
						<th>Email</th>
						<th>Status</th>
						<th>Total</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
						<td>Company name</td>
						<td>Contact name</td>
						<td>Contact number</td>
						<td>Email</td>
						<td>Status</td>
						<td>Total</td>
						<td>Edit</td>
						<td>Delete</td>
					</tr>
			 	<c:forEach items="${customers}" var="customer" varStatus="st">
					<tr>
						<td>${customer.companyName}</td>
						<td>${customer.contactName}</td>
						<td>${customer.contactNumber}</td>
						<td>${customer.email}</td>
						<td>${customer.status}</td>
						<td>${customer.total}</td>
						<td><a href="customerGet?id=${customer.id}"><img src="img\edit.png" width="20""></a></td>
				        <td><a href="customerDelete?id=${customer.id}" onclick="return confirm('Are you sure you want to delete this customer?');"><img src="img\delete.png" width="20"></a></td> 		
					</tr>
				</c:forEach>
			</table>
			</div>
		</form>
	</body>
</html>