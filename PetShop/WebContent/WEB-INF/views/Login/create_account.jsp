<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Would you kindly create an account?</h3>
	<BR />
	<form action="CreateAccount" method="post">
		<fieldset>
			<legend>Login Information</legend>
			<input type="text" name="username" id="username" /> <label for="username">Username: </label>
			<BR /> 
			<input type="text" name="password" id="password" /> <label for="password">Password: </label>
			<BR />
			<input type="submit" value="Away we go!" />
		</fieldset>
	</form>
</body>
</html>