<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Repositorio de Videojuegos - Mis juegos</title>
</head>
<body>
	<h2>Mis juegos</h2>
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
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${juego.fechaLanzamiento}"/></td>
				<td><c:out value="${juego.fechaLanzamiento}" /></td>
				<td><c:out value="${juego.descripcion}" /></td>
				

			</tr>
		</c:forEach>
	</table>
	

</body>
</html>