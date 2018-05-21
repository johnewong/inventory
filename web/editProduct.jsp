<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>

<script>
$(function() {
    $( "#datepicker" ).datepicker();
});
/*
function getOption(selectObject) {
	  var value = selectObject.value; 
	  alert(value);
}

var xmlhttp;
function sold() {
	var id = document.getElementById("id").value;
	var status = document.getElementById("name").value;
	var url = "http://127.0.0.1:8080/productGet?id="+id;
	alert(status);
	xmlhttp =new XMLHttpRequest();
  	xmlhttp.onreadystatechange=checkResult; 
  	xmlhttp.open("GET",url,true);   
  	xmlhttp.send(null); 
}

function checkResult(){
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    document.getElementById('checkResult').innerHTML=xmlhttp.responseText;
   
}*/
</script>

</head>
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
        <td>Price</td>
        <td>Password</td>
        <td>Comment</td>
    </tr>
    <tr>
    	<td>
    		${product.id}
    		<input name="id" type="text" id="id" value="${product.id}" maxlength="6" size="6" hidden/>
    	</td>
    	<td>
    		<input name="productName" type="text" value="${product.productName}" maxlength="12" size="12"/>
    	</td>
    	<td>
    	
    		Type: <select name="type" required>
					<option value="internal" ${product.type == "internal" ? 'selected="selected"' : ''}>Internal antenna</option>
					<option value="external" ${product.type == "external" ? 'selected="selected"' : ''}>External Antenna</option>
					<option value="other" ${product.type == "other" ? 'selected="selected"' : ''}>other</option> 
				</select>
    	</td>
    	<td>
    		${product.createDate}
    	</td>
    	<td>
    		<input name="MACaddr" type="text" value="${product.macAddr}" maxlength="12" size="12"/>
    	</td>
    	<td>
    		Status: <select name="status"  id="status" required>//onchange="getOption(this)" 
					<option value="available" ${product.status == "available" ? 'selected="selected"' : ''}>available</option>
					<option value="sold" ${product.status == "sold" ? 'selected="selected"' : ''}>sold</option>
					<option value="other" ${product.status == "other" ? 'selected="selected"' : ''}>other</option> 
				</select>
    	</td>
    	<td>
    		<!--<input name="soldDate" type="text" value="${product.soldDate}" />-->
    		Date: <input name="soldDate" type="text" id="datepicker" />
    		
    	</td>
    	<td>
    		<select name="cid">
    			<option value=1 ${product.customer.getCompanyName()==" "?'selected="selected"':''}>Please select the company</option>
    		<c:forEach items="${customers}" var="customer" varStatus="st">
    			<option value="${customer.id}" ${customer.getCompanyName() == product.customer.getCompanyName()?'selected="selected"':''}>${customer.getCompanyName()}</option> 		
    		</c:forEach>
    		</select>	
    	</td> 	
    		<!--<input name="cid" type="text" value="${product.cid}" maxlength="6" size="6" hidden/>-->  			
    	<td>
    		<input name="price" type="text" value="${product.price}" maxlength="12" size="12"/>
    	</td>
    	<td>
    		<input name="password" type="text" value="${product.password}" maxlength="12" size="12"/>
    	</td>
    	<td>
    		<input name="comment" type="text" value="${product.comment}" maxlength="18" size="18"/>
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
