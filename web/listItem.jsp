<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
	<head>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
		<script>
			function checkStock(id) {
				
				var stockId = "stock" + id;
				var safeStockId = "safeStock" + id;
				var statusId = "status" + id;
				//alert(stockId);
				var stock = Number(document.getElementById(stockId).innerHTML);
				var safeStock = Number(document.getElementById(safeStockId).innerHTML);
				
				if(stock > safeStock*1.2) {
					//alert(id);
					document.getElementById(stockId).style.color = "green";
					document.getElementById(statusId).innerHTML = "Safe";
					document.getElementById(statusId).style.color = "green";
				}
				else if(stock <= safeStock) {
					//alert(id);
					document.getElementById(stockId).style.color = "red";
					document.getElementById(statusId).innerHTML = "Danger";
					document.getElementById(statusId).style.color = "red";
				}
				else{
					//alert(id);
					document.getElementById(stockId).style.color = "#f7a942";
					document.getElementById(statusId).innerHTML = "Warning";
					document.getElementById(statusId).style.color = "#f7a942";
				}
			}
			
			//window.addEventListener('load', checkStock);
		</script>
		
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
		<p>You are now: Viewing item list</p>
		<form action="addItem.jsp">
	    	<input type="submit" value="Add New Items" />
		</form>
		<br>
		<br>
		<form>
			<div style="overflow-x:auto">
				<table class ="table table-bordered">
					<tr>
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
				<script>
					var size = Number("<c:out value='${fn:length(items)}'/>");
					var index = Number(${st.index});
					checkStock(index);
				</script>
		
					<tr>
						<td>${item.name}</td>
						<td>${item.desc}</td>
						<td>${item.category}</td>
						<td id="status${1+st.index}"></td>
						<td id="safeStock${1+st.index}">${item.safetyStock}</td>
						<td id="stock${1+st.index}">${item.stock}</td>
						<td>${item.price}</td>
						<td>${(item.price)*(item.stock)}</td>
						<td>${item.createDate}</td>
						<td><a href="itemGet?id=${item.id}">edit</a></td>
				        <td><a href="itemDelete?id=${item.id}" onclick="return confirm('Are you sure you want to delete this item?');">delete</a></td> 		
					</tr>
			</c:forEach>
				</table>
			</div>
		</form>
	</body>
</html>