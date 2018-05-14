<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
<b>User: ${userName}<b> 
<form method="post" action="/productEdit">
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>Id</td>
        <td>ProductName</td>
        <td>Type</td>
        <td>CreateDate</td>
        <td>MAC_Address</td>
        <td>Status</td>
        <td>SoldDate</td>
        <td>CompanyName</td>
        <td>Password</td>
        <td>Comment</td>
    </tr>
    <tr>
    	<td>
    		${product.id}
    	</td>
    	<td>
    		${product.productName}
    	</td>
    	<td>
    		${product.type}
    	</td>
    	<td>
    		${product.createDate}
    	</td>
    	<td>
    		${product.macAddr}
    	</td>
    	<td>
    		${product.status}
    	</td>
    	<td>
    		${product.soldDate} 		
    	</td>
    	<td>
    		${product.customer.getCompanyName()}
    	</td> 	
    		${product.cid}			
    	<td>
    		${product.password}
    	</td>
    	<td>
    		${product.comment}
    	</td>
    </tr>
</table>
<button type="submit">Submit</button>
</form>

<form action="/productList">
    	<input type="submit" value="Go ProductList" />
</form>
<form action="/customerList">
	    	<input type="submit" value="Go CustomerList" />
</form>
</body>
