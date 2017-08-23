<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
</head>
<body>

	<a href = "/bright_ideas">Bright Ideas</a>
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>

	<p>Name: ${user.name }</p>
	<p>Alias: ${user.alias }</p>
	<p>Email: ${user.email }</p>
	
	<p>Total Number of Posts: 2</p>
	<p>Total Number of Likes: 4</p>
</body>
</html>