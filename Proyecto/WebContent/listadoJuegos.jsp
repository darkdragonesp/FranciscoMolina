<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Repositorio de Videojuegos - Explorar</title>
</head>
<body>
Añadir juego
	<table>
		<tr>
			<th>Título</th>
			<th>Categoría</th>
			<th>Plataforma</th>
			<th>Fecha Lanzamiento</th>
			<th>Descripcion</th>
		</tr>
		<c:forEach items="${listaJuegos}" var="juego">
			<tr>
				<td><c:out value="${juego.titulo}" /></td>
				<td><c:out value="${juego.categoria.nombre}" /></td>
				<td><c:out value="${juego.plataforma.nombre}" /></td>
				<td><c:out value="${juego.fechaLanzamiento}" /></td>
				<td><c:out value="${juego.descripcion}" /></td>
				
				<td><a href="BorrarServlet?id=${juego.idJuego}">X</a></td>
				<td><a href="BuscarServlet?id=${juego.idJuego}">E</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.jsp">Inicio</a>
	<br> ${msg}
</body>
</html>