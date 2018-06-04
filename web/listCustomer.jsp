<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<b>Online User: ${online_number}</b>
<b>User: ${userName}<b> 
<form>
<table align='center' border='1' cellspacing='0'>
	<tr>
		<!--<td>Id</td>-->
		<td>CompanyName</td>
		<td>ContactName</td>
		<td>ContactNumber</td>
		<td>Email</td>
		<td>Status</td>
		<td>Total</td>
		<td>Edit</td>
		<td>Delete</td>
	</tr>
	
	 <c:forEach items="${customers}" var="customer" varStatus="st">
		<tr>
		<!--<td>${customer.id}</td>-->
		<td>${customer.companyName}</td>
		<td>${customer.contactName}</td>
		<td>${customer.contactNumber}</td>
		<td>${customer.email}</td>
		<td>${customer.status}</td>
		<td>${customer.total}</td>
		<td><a href="customerGet?id=${customer.id}">edit</a></td>
        <td><a href="customerDelete?id=${customer.id}" onclick="return confirm('Are you sure you want to delete this item?');">delete</a></td> 		
		</tr>
	</c:forEach>
</table>
</form>

<form action="addCustomer.html">
    	<input type="submit" value="Add Customer" />
</form>
<form action="/productList">
    	<input type="submit" value="Go ProductList" />
</form>

<form action="/itemList">
    	<input type="submit" value="Go ItemList" />
</form>

<form method="post" action="customerList">
	<select name="search">
		<option value="" selected>Search Element</option>
		<option value="companyName">Company</option>
		<option value="contactName">ContactName</option>
		<option value="status">Status</option>
	</select>
	<input type="text" name="key" placeholder="Enter the key">
	
	<input type="submit" value="Search">
</form>
<a href="https://www.the-qrcode-generator.com">Go QRcode generator</a>
