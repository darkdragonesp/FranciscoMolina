<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title><spring:message code="app.name"/></title>
</head>
<body>
	<h2><spring:message code="accion.listar.juegos.usuario"/></h2>
		<c:choose>
		<c:when test="${empty listaJuegos}">
			<spring:message code="mensaje.juego.usuario.vacio" />
			<a href="listarJuegos"><spring:message code="accion.listar.juegos"/></a>
		</c:when>
		<c:otherwise>
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
				<td><a href="mostrarJuego?idJuego=${item.juego.idJuego}">${item.juego.titulo}</a></td>
				<td><a href="listarPorCategoria?idCategoria=${item.juego.categoria.idCategoria}">${item.juego.categoria.nombre}</a></td>
				<td><a href="listarPorPlataforma?idPlataforma=${item.juego.plataforma.idPlataforma}">${item.juego.plataforma.nombre}</a></td>
				<td><fmt:formatDate value="${item.juego.fechaLanzamiento}" pattern="dd-MM-yyyy"/></td>	
				<td>${item.juego.descripcion}</td>
				<td><a href="borrarJuegoUsuario?idJuegoUsuario=${item.idJuegoUsuario}"
					onclick="return window.confirm('<spring:message code="accion.confirmar.borrar"/>')">
					<spring:message code="accion.borrar"/></a></td>	
			</tr>
		</c:forEach>
	</table>
	
			</c:otherwise>
	</c:choose>
	<br>
		${msg}
	<br>
	<a href="inicio"><spring:message code="accion.inicio"/></a>
</body>
</html>