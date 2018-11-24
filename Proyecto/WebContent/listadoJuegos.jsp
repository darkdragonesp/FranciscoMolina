<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="funciones.js"></script>
<title>Explorar juegos</title>
</head>
<body>
	<h2>Explorar juegos</h2>
	<a href="buscarPlataformas">A�adir juego nuevo</a>
	
	<form action="filtrarJuegos">
	T�tulo: <input type="text" name="titulo" value="${titulo}"/>
	Categor�a: <input type="text" name="categoria" value="${categoria}"/>
	Plataforma: <input type="text" name="plataforma" value="${plataforma}"/>
	<input type="submit" value="Filtrar"/>
	</form>
	
	<table>
		<tr>
			<th>T�tulo</th>
			<th>Categor�a</th>
			<th>Plataforma</th>
			<th>Fecha Lanzamiento</th>
			<th>Descripcion</th>
			
			<th>A�adir</th>
			
			<th>Borrar</th>
			<th>Editar</th>
		</tr>
		<c:forEach items="${listaJuegos}" var="juego">
			<tr>
				<td><c:out value="${juego.titulo}" /></td>
				<td><c:out value="${juego.categoria.nombre}" /></td>
				<td><c:out value="${juego.plataforma.nombre}" /></td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${juego.fechaLanzamiento}"/></td>
<%-- 				<td><c:out value="${juego.fechaLanzamiento}" /></td> --%>
				<td><c:out value="${juego.descripcion}" /></td>
				
				<td><a href="anadirJuego?id=${juego.idJuego}">A�adir</a></td>
				
				<td><a href="borrarJuego?id=${juego.idJuego}" onclick="confirmar('�Borrar juego seleccionado?')">Borrar</a></td>
				<td><a href="buscarJuego?id=${juego.idJuego}">Editar</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<br> ${msg}
</body>
</html>