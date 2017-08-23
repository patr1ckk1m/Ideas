<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Like Status</title>
<style>
	.messagebox {
		width: 300px;
		height: 100px;
		border-style: solid;
    	border-width: 3px;
    	text-align: center;
    	overflow: auto;
	}
</style>
</head>
<body>
<a href="/bright_ideas">Bright Ideas</a>
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
	<p><a href = "/users/${idea.poster.id }">${idea.poster.alias}</a> says: </p>
	<div class = "messagebox">
		<p>${idea.message }</p>
	</div>
	
	<table>
		<tr>
			<th>Alias</th>
			<th>Name</th>
		</tr>
		<c:forEach var = "user" items = "${idea.users }">
			<tr>
				<td>${user.alias }</td>
				<td>${user.name }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>