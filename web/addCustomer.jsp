<!DOCTYPE html>
	<body>
	<%@include file="main.jsp" %>
		<form method="post" action="customerAdd">
			<table align='center' border='1' cellspacing='0'>
			<tr>
			<td>
			CompanyName: <input type="text" placeholder="Enter Company Name" name="companyName" maxlength="20" size="20" required>
			</td>
			<td>
			ContactName: <input type="text" placeholder="Enter Contact Name" name="contactName" maxlength="18" size="18" required>
			</td>
			<td>
			ContactNumber: <input type="text" placeholder="Enter Contact Number" name="contactNumber" maxlength="12" size="12" required>
			</td>
			<td>
			Email: <input type="email" placeholder="Enter Email" name="email" maxlength="20" size="20" required>
			</td>
			<td> Status: <select name="status" required/>
					<option value="delivered"> Delivered</option>
					<option value="unpaid"> Unpaid</option>
					<option value="unconfirmed"> Unconfirmed</option>
					<option value="confirmed"> Confirmed</option>
					<option value="unconfirmed"> Unconfirmed</option>							
					<option value="other"> Other</option>					
			</select></td>
			<td>
			Total: <input type="number" placeholder="Enter Total Amount" name="total" required>
			</td>
			</tr>
			</table>
			<button type="submit">Add</button>
	</body>
</html>