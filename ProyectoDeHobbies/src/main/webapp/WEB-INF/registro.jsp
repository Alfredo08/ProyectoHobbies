<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>
			Registro
		</h1>
		<form:form method="POST" action="/usuarios/registrar" modelAttribute="usuario">
			<div>
				<form:label path="nombre" for="nombre">
					Nombre:
				</form:label>
				<form:input path="nombre" type="text" name="nombre" id="nombre" />
				<form:errors path="nombre"/>
			</div>
			<div>
				<form:label path="apellido" for="apellido">
					Apellido:
				</form:label>
				<form:input path="apellido" type="text" name="apellido" id="apellido" />
				<form:errors path="apellido"/>
			</div>
			<div>
				<form:label path="nombreUsuario" for="nombreUsuario">
					Nombre de usuario:
				</form:label>
				<form:input path="nombreUsuario" type="text" name="nombreUsuario" id="nombreUsuario" />
				<form:errors path="nombreUsuario"/>
			</div>
			<div>
				<form:label path="password" for="password">
					Password:
				</form:label>
				<form:input path="password" type="password" name="password" id="password" />
				<form:errors path="password"/>
			</div>
			<div>
				<form:label path="identificador" for="identificador">
					Identificador:
				</form:label>
				<form:input path="identificador" type="text" name="identificador" id="identificador" />
				<form:errors path="identificador"/>
			</div>
			<button type="submit">
				Registrar usuario
			</button>
		</form:form>
	</body>
</html>