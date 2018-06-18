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
	<p> You are now: Adding new customer</p><br>
		<form method="post" action="customerAdd">
			<div style="overflow-x:auto">
			<table class ="table table-bordered">
			<tr>
			<td>
			Company name: <input type="text" placeholder="Enter company name" name="companyName" maxlength="100" size="20" required>
			</td>
			<td>
			Contact name: <input type="text" placeholder="Enter contact name" name="contactName" maxlength="100" size="18" required>
			</td>
			<td>
			Contact number: <input type="text" placeholder="Enter contact number" name="contactNumber" maxlength="100" size="18" required>
			</td>
			<td>
			Email: <input type="email" placeholder="Enter Email" name="email" maxlength="100" size="20" required>
			</td>
			<td> Status: 
				<select name="status" required/>
					<option value="opt" disabled >Select your option</option>
					<option value="delivered"> Delivered</option>
					<option value="unpaid"> Unpaid</option>
					<option value="unconfirmed"> Unconfirmed</option>
					<option value="confirmed"> Confirmed</option>						
					<option value="other"> Others</option>					
			</select></td>
			<td>
			Total: <input type="number" placeholder="Enter Total Amount" name="total" required>
			</td>
			</tr>
			</table>
			</div>
			<button type="submit">Add</button>
	</body>
</html>