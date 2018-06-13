<html>
	<head>
		<script>
			fucntion checkStock() {
				var safeStock = document.getElementById("safeStock");
				var stock = document.getElementById("stock");
				
				alert("safeStock");
				alert("stock");
			}
		</script>
	</head>
	<body>
		<%@include file="main.jsp" %>
		<form method="post" action="itemAdd">
			<table align='center' border='1' cellspacing='0'>
			<tr>
			<td>
			Name: <input type="text" placeholder="Enter Item Name" name="name" required>
			</td>
			<td>
			Description: <input type="text" placeholder="Enter Description" name="desc" required>
			</td>
			<td>
			Category: <input type="text" placeholder="Enter Category" name="cate" required>
			</td>
			<td id = "safeStock">
			Safety Stock: <input type="number" placeholder="Enter Safety Stock" name="safetyStock" required>
			</td>
			<td id = "stock">
			Current Stock: <input type="number" placeholder="Enter Current Stock" name="stock" required>
			</td>
			<td>
			Price: <input type="text" placeholder="Enter Price" name="price" required>
			</td>
			</tr>
			</table>
			<button type="submit" onclick="checkStock()">Add</button>
		
	</body>
</html>