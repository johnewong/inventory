<!DOCTYPE html>
	<head>
		<script>
			fucntion checkStock() {
				var safeStock = document.getElementById("safeStock");
				var stock = document.getElementById("stock");
				
				alert("safeStock");
				alert("stock");
			}
		</script>
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
		<p> You are now: Adding new item</p><br>
		<form method="post" action="itemAdd">
			<div style="overflow-x:auto">
			<table class ="table table-bordered">
			
			<tr>
			<td>
			Name: <input type="text" placeholder="Enter item name" name="name" required>
			</td>
			<td>
			Description: <input type="text" placeholder="Enter description" name="desc" required>
			</td>
			<td>
			Category: <input type="text" placeholder="Enter category" name="cate" required>
			</td>
			<td id = "safeStock">
			Safety stock: <input type="number" placeholder="Enter safety stock" name="safetyStock" required>
			</td>
			<td id = "stock">
			Current stock: <input type="number" placeholder="Enter current stock" name="stock" required>
			</td>
			<td>
			Cost (USD):<input type="text" placeholder="Enter cost" name="price" required>
			</td>
			</tr>
			</table>
			</div>
			<button type="submit" onclick="checkStock()">Add</button>
		
	</body>
</html>