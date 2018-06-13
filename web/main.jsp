<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
	<style>
	body
	 {
	  margin: auto;
	  font-family: Arial;
	  background-color:#0174CF;
	}
	.topnav 
	{
	  overflow: hidden;
	  background-color: #60adea;
	}
	.topnav a 
	{
	  float: left;
	  color: white;
	  text-align: center;
	  padding: 14px 16px;
	  text-decoration: none;
	  font-size: 20px;
	}
	.topnav a:hover 
	{
	  background-color: white;
	  color: black;
	}
	.topnav a.active
	 {
	  background-color: white;
	  color: black;
	}
	.header
	{
		background-color: #60adea;
	}
	
	.online
	{
		float: right;
		padding : 0px 15px 0px 0px;
	}
	
	
	</style>
	<body style="color:white">
		<div class="header">
			<div class="topnav">
				<div class="online">
				<b>Online users: ${online_number}</b>
				</div>
				<p>Logged in as: ${userName}<p>
				<a href="home.jsp"><img src="home-icon.png" width="30"> Home</a>
				<a href="/productList"><img src="product-icon.png"width="30"> Product</a>
				<a href="/customerList"><img src ="customers-icon.png" width="30"> Customers</a>
				<a href="itemList"><img src="misc-icon.png" width="30"> Other items</a>
				<a href ="https://www.the-qrcode-generator.com" onclick="return confirm('You will be redirected to the QR Page')"><img src="qr-code.png" width="30" height="30">QR Generator</a>
				<a href ="login.jsp" onclick="return confirm('Are you sure you want to log out?')"><img src="logOut.png" width="30">Log out</a>
			</div> 
		</div>
	</body>	
</html>