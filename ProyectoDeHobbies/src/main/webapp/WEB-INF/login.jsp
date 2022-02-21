<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<form method="POST" action="/login">
			<div>
				<label for="nombreUsuario">
					Nombre de usuario:
				</label>
				<input type="text" id="nombreUsuario" name="nombreUsuario" />
			</div>
			<div>
				<label for="password">
					Password:
				</label>
				<input type="password" id="password" name="password" />
			</div>
			<button type="submit">
				Login
			</button>
		</form>
	</body>
</html>