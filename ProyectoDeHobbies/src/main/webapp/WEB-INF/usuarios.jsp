<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Usuarios con JPA y SQL</title>
	</head>
	<body>
		<h1>
			Bienvenido de vuelta <c:out value="${nombre}" /> <c:out value="${apellido}" /> <c:out value="${nombreUsuario}"/>	
		</h1>
		<h2>
			Lista de usuarios de nuestra base de datos proyecto_hobbies
		</h2>
		<ul>
			<c:forEach var="usuario" items="${listaUsuarios}" >
				<li>
					<form action="/usuarios/eliminar/${usuario.getNombreUsuario()}" method="POST">
						<c:out value="${usuario.getNombre()}" /> <c:out value="${usuario.getApellido()}" />
						<input type="hidden" name="_method" value="DELETE" />
						<button type="submit">
							Eliminar usuario
						</button>
					</form >
					<c:if test = "${usuario.getNombreUsuario() == nombreUsuario}">
						<a href="/usuarios/editar">
							<button>
								Editar
							</button>
						</a>
					</c:if>
					<ul>
						<c:forEach var="hobby" items="${usuario.getListaHobbies()}" >
							<li>
								<c:out value="${hobby.getNombre()}" />
							</li>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
		</ul>
		<div>
			<form action="/usuarios/logout" method="GET">
				<button type="submit">
					Logout
				</button>
			</form>
		</div>
	</body>
</html>