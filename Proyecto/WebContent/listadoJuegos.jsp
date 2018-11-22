<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Explorar juegos</title>
</head>
<body>
	<h2>Explorar juegos</h2>
	<a href="/anadirJuego">Añadir juego nuevo</a>
	<table>
		<tr>
			<th>Título</th>
			<th>Categoría</th>
			<th>Plataforma</th>
			<th>Fecha Lanzamiento</th>
			<th>Descripcion</th>
			
			<th>Borrar</th>
			<th>Editar</th>
		</tr>
		<c:forEach items="${listaJuegos}" var="juego">
			<tr>
				<td><c:out value="${juego.titulo}" /></td>
				<td><c:out value="${juego.categoria.nombre}" /></td>
				<td><c:out value="${juego.plataforma.nombre}" /></td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${juego.fechaLanzamiento}"/></td>
				<td><c:out value="${juego.fechaLanzamiento}" /></td>
				<td><c:out value="${juego.descripcion}" /></td>
				
				<td><a href="/borrarJuego?id=${juego.idJuego}">X</a></td>
				<td><a href="/buscarJuego?id=${juego.idJuego}">E</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<br> ${msg}
</body>
</html>