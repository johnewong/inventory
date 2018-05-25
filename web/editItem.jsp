<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
	<head></head>
	<body>
	<b>User: ${userName}<b> 
	<form method="post" action="/itemEdit">
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
			</tr>
			<tr><td>${item.id}</td>
			<input name="id" type="text" value="${item.id}" hidden/>
			<td><input type="text" name="name" value="${item.name}" maxlength="12" size="12" requried/></td>
			<td><input type="text" name="description" value="${item.desc}" maxlength="12" size="12" requried/></td>
			<td><input type="text" name="category" value="${item.category}" maxlength="12" size="12" requried/></td>
			<td><input type="text" name="status" value="${item.status}" maxlength="12" size="12" requried</td>
			<td><input type="text" name="safetyStock" value="${item.safetyStock}" requried/></td>
			<td><input type="text" name="stock" value="${item.stock}" requried/></td>
			<td><input type="text" name="price" value="${item.price}" requried/></td>
			</tr>
			
		</table>
		<input type="submit" value="Update">
	</form>

	<form action="/productList">
    		<input type="submit" value="Go ProductList" />
	</form>
	<form action="/customerList">
	    	<input type="submit" value="Go CustomerList" />
	</form>
	<form action="/itemList">
	    	<input type="submit" value="Go ItemList" />
	</form>
	
	
	
	</body>
</html>