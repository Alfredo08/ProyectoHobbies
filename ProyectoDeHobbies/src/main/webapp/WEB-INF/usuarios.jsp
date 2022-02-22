<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Usuarios con JPA y SQL</title>
	</head>
	<body>
		<h1>
			Lista de usuarios de nuestra base de datos proyecto_hobbies
		</h1>
		<ul>
			<c:forEach var="usuario" items="${listaUsuarios}" >
				<li>
					<c:out value="${usuario.getNombre()}" /> <c:out value="${usuario.getApellido()}" />
				</li>
			</c:forEach>
		</ul>
	</body>
</html>