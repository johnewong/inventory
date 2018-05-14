<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<b>User: ${userName}<b> 

<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>Id</td>
        <td>ProductName</td>
        <td>Type</td>
        <td>CreateDate</td>
        <td>MAC_Address</td>
        <td>Status</td>
        <td>SoldDate</td>
        <td>Cid</td>
        <td>CompanyName</td>
        <td>Password</td>
        <td>Comment</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="st">
        <tr>
            <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.type}</td>
            <td>${product.createDate}</td>
            <td>${product.macAddr}</td>
            <td>${product.status}</td>
            <td>${product.soldDate}</td>
            <td>${product.cid}</td>
            <td>
            ${product.customer.companyName}
            </td>
            <td>${product.password}</td>
            <td>${product.comment}</td>
            <td><a href="productGet?id=${product.id}">edit</a></td>
            <td><a href="productDelete?id=${product.id}" onclick="return confirm('Are you sure you want to delete this item?');">delete</a></td> 
        </tr>
    </c:forEach>
</table>
<form action="addProduct.html">
    	<input type="submit" value="Add Product" />
</form>
<form action="/customerList">
	    <input type="submit" value="Go CustomerList" />
</form>

<form method="post" action="productList">
	<select name="search">
		<option value="" selected>null</option>
		<option value="companyName">Company</option>
		<option value="productName">ProductName</option>
		<option value="status">Status</option>
	</select>
	<input type="text" name="key" placeholder="Enter the key">
	
	<input type="submit" value="Search">
</form>
<a href="https://www.the-qrcode-generator.com">Go QRcode generator</a>





