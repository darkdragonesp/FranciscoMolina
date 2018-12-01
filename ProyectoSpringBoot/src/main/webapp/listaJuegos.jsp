<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- <%@ page errorPage="error.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script src="scripts/funciones.js"></script> -->
<title><spring:message code="app.name"/></title>
</head>
<body>
	<h2><spring:message code="accion.listarJuegos"/></h2>
<!-- 	<a href="buscarPlataformas">Añadir juego nuevo</a> -->
	
<!-- 	<form action="filtrarJuegos"> -->
<%-- 	Título: <input type="text" name="titulo" value="${titulo}"/> --%>
<%-- 	Categoría: <input type="text" name="categoria" value="${categoria}"/> --%>
<%-- 	Plataforma: <input type="text" name="plataforma" value="${plataforma}"/> --%>
<!-- 	<input type="submit" value="Filtrar"/> -->
<!-- 	</form> -->
	<table>
		<tr>
			<th><spring:message code="juego.titulo"/></th>
			<th><spring:message code="juego.categoria"/></th>
			<th><spring:message code="juego.plataforma"/></th>
			<th><spring:message code="juego.fechaLanzamiento"/></th>
			<th><spring:message code="juego.descripcion"/></th>
		</tr>
		<c:forEach items="${listaJuegos}" var="item">
			<tr>
				<td>${item.titulo}</td>
				<td>${item.categoria.nombre}</td>
				<td>${item.plataforma.nombre}</td>
				<td><fmt:formatDate value="${item.fechaLanzamiento}" pattern="dd-MM-yyyy"/></td>	
				<td>${item.descripcion}</td>
				<td><a href="buscar?id=${item.idJuego}"><spring:message code="accion.editar"/></a></td>	
<%-- 				<td><a href="anadirJuego?id=${juego.idJuego}">Añadir</a></td> --%>
<%-- 				<td><a href="borrarJuego?id=${juego.idJuego}" onclick="return confirmar('¿Borrar juego seleccionado?')">Borrar</a></td>		 --%>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="inicio"><spring:message code="accion.inicio"/></a>
</body>
</html>