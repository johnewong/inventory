<!DOCTYPE html>

<head>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
	<body>
		<%@include file="main.jsp" %>
		<%@include file="choices.jsp"%>	
		<p> You are now viewing: FAQ page</p>
		<div class="choices">
			<h1 style="color:black"><i>FAQ</i></h1>
			<h3> Q: How do I generate the QR Code?</h3>
			<h5> A: In the generator, enter :"http://(ip address of host)(port number)/productScan?macAddr=(MAC address of device) for eg. http://192.168.186.84:8080/productScan?macAddr="F8:B5:6:B8:00:0A" this will bring you to the product update page. <b><i><u>Before generating the code, make sure the mac address of the device has been addded into the database.</u></i></b></h5>
			<br>
			<h3>Q: What happens if i delete an entry?</h3>
			<h5>A: After deleting any entries in the database, you will be unable to retrieve them unless you have made an extra copy.</h5>
			<br>
			<h3> Q: How often should I delete entries?(Sold status for eg.)</h3>
			<h5> A: After 3-5 months.</h3>
			<br>
			<h3> Q: Who did this inventory system and who should I contact if there are changes to be made along the way?</h3>
			<h5> A: This inventory system was done by Polytechnic interns. If any changes are to be made, please use git bash and github to retrieve the files from johnewong at github. Please save a copy of the original file first before making any changes.	</h5>
		</div>
	</body>
</html>