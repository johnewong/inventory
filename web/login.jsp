<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<html>
	<body>
		<form method="post" action = "login">
			<input type="text" name="info" value="${info}" hidden/>
			Username: <input type="text" placeholder="Enter Username" name="name" required>
			Password: <input type="password" placeholder="Enter Password" name="password" required>
			<button type="submit">Login</button>
		</form>
	</body>
</html>