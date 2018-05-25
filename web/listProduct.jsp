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
<b>User: ${userName}<b> 

<table align='center' border='1' cellspacing='0' class="table table-striped table-bordered table-hover  table-condensed">
    <tr>
        <td>Id</td>
        <td>ProductName</td>
        <td>Type</td>
        <td>CreateDate</td>
        <td>MAC_Address</td>
        <td>Status</td>
        <td>SoldDate</td>
        <!--<td>Cid</td>-->
        <td>CompanyName</td>
        <td>Price</td>
        <td>Password</td>
        <td>Comment</td>
        
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${products}" var="product"  varStatus="st">
        <tr>
            <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.type}</td>
            <td>${product.createDate}</td>
            <td>${product.macAddr}</td>
            <td>${product.status}</td>
            <td>${product.soldDate}</td>
            <!--<td>${product.cid}</td>-->
            <td>${product.customer.companyName}</td>
            <td>${product.price}</td>
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

<form action="/itemList">
	    <input type="submit" value="Go ItemList" />
</form>

<form method="post" action="productList">
	<select name="search">
		<option value="" selected>Search Element</option>
		<option value="companyName">Company</option>
		<option value="productName">ProductName</option>
		<option value="status">Status</option>
	</select>
	<input type="text" name="key" placeholder="Enter the key">
	
	<input type="submit" value="Search">
</form>
<a href="https://www.the-qrcode-generator.com">Go QRcode generator</a>
</body>
</html>




