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
	<h2><spring:message code="accion.listar.juegos"/></h2>
	
	<form method="GET" action="listarJuegosFiltro">
		<spring:message code="juego.titulo"/><input type="text" name="titulo"/>
		<input type="submit" value="<spring:message code="accion.filtrar"/>"/>
	</form>
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
				<td><a href="listarPorCategoria?idCategoria=${item.categoria.idCategoria}">${item.categoria.nombre}</a></td>
				<td><a href="listarPorPlataforma?idPlataforma=${item.plataforma.idPlataforma}">${item.plataforma.nombre}</a></td>
				<td><fmt:formatDate value="${item.fechaLanzamiento}" pattern="dd-MM-yyyy"/></td>	
				<td>${item.descripcion}</td>
				
				<td><a href="guardarJuegoUsuario?idJuego=${item.idJuego}"><spring:message code="accion.agregar"/></a></td>	
				<td><a href="buscarJuego?idJuego=${item.idJuego}"><spring:message code="accion.editar"/></a></td>	
				<td><a href="borrarJuego?idJuego=${item.idJuego}" 
					onclick="return window.confirm('<spring:message code="accion.confirmar.borrar"/>')">
					<spring:message code="accion.borrar"/></a></td>		
			</tr>
		</c:forEach>
	</table>
	${msg}
	<br>
	<a href="inicio"><spring:message code="accion.inicio"/></a>
</body>
</html>