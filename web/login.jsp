<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>	
	
	.blocks
	{
		margin:auto;
		text-align: center;
		border: solid 4px #0174CF;
		background-color: #0174CF;
		padding: 10px 10px ;
		border-radius: 30px;
		width: 350px;
		height: 300px;
		position: absolute;
   	 	top:0;
    	bottom: 0;
    	left: 0;
    	right: 0;
	}
	.button
	{
  		padding: 8px 15px;
  		font-size: 15px;
  		text-align: center;
  		cursor: pointer;
  		outline: none;
  		color: black;
  		background-color: #fff;
 		border: none;
		border-radius: 10px;
  		box-shadow: 0 7px #999;
	}
	.button:active 
	{
  		background-color: #fff;
  		box-shadow: 0 5px #666;
  		transform: translateY(3px);
	}
	.button:hover
	{
		background-color: #e8e8e8;
	}
	
	body
	{
		font-family:arial;
		<!--background-image: url("/img/blur1.jpg");-->
		background-repeat: repeat;
		background-color: #6DC1E5;
		background-repeat: repeat;
		color:white;
		
		
	}
	
	input[type=text], input[type=password]
	{
	 width: 45%;
     padding: 15px;
     margin: 5px 0 22px 0;
     border: none;
     background: #f1f1f1;
	}
	
	input[type=text]:focus,input[type=password]:focus	
	{
		background-color: #e1e1e1;
	}
	img
	{	
		width:100%
		height:auto;
	}
	</style>
</head>
	<body>
		<form method="post" action = "login">
			<input type="text" name="info" value="${info}" hidden/>
			<div class="blocks">	
			<!--<img src ="img/product-icon.png" alt= "Whizpace logo" height="60" width="150">-->
				<h1><i>Whizpace&trade; Inventory</i></h1>
				<input type="text" placeholder="Enter username" name="name" required></br>
				<input type="password" placeholder="Enter password" name="password" required></br>
				<button class="btn btn-success; button"" type="submit"><b><i>Login</i></b></button></br></br>
				<small><i>&copy; Copyright 2018 Whizpace</i><small>
			</div>
		</form>
	</body>
</html>

