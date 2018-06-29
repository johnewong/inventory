<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<style>
	table, th, td
			{
			border:1px solid white;
			border-collapse: collapse;
			family-font: calibri;
			}	
			tr:nth-child(odd) {background-color:#49afff;}	
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<%@include file="main.jsp" %>
	<p> You are now: Updating customer</p>
	<form method="post" action="/customerEdit">
		<div style="overflow-x:auto">
		<table class="table table-bordered">
			<tr>
				<!--<td>Id</td>-->
				<td>Company name</td>
				<td>Contact name</td>
				<td>Contact number</td>
				<td>Email</td>
				<td>Status</td>
				<td>Total</td>
			</tr>
			<!--<tr><td>${customer.id}</td>-->
			<input name="id" type="text" value="${customer.id}" maxlength="6" size="6" hidden/>
			<td><input type="text" name="companyName" value="${customer.companyName}" maxlength="100" size="20" requried/></td>
			<td><input type="text" name="contactName" value="${customer.contactName}" maxlength="100" size="18" requried/></td>
			<td><input type="text" name="contactNumber" value="${customer.contactNumber}" maxlength="100" size="12" requried/></td>
			<td><input type="email" name="email" value="${customer.email}" maxlength="100" size="" requried</td>
			<td><select name="status" requried/>
			<option value="delivered" ${customer.status == "delivered" ? 'selected == "selected"' : ''}> Delivered</option>
			<option value="unpaid" ${customer.status == "unpaid" ? 'selected == "selected"' : ''}> Unpaid</option>
			<option value="unconfirmed" ${customer.status == "unconfirmed" ? 'selected == "selected"' : ''}> Unconfirmed</option>
			<option value="confirmed" ${customer.status == "confirmed" ? 'selected == "selected"' : ''}> Confirmed</option>				
			<option value="other" ${customer.status == "other" ? 'selected == "selected"' : ''}> Other</option>					
			</select>
			</td>
			<td><input type="text" name="total" value="${customer.total}" maxlength="12" size="12" required/></td>
			</tr>
			
		</table>
		</div>
		<input type="submit" value="Update">
		<input type="reset" value="Reset">
	</form>
</body>
</html>