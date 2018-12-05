<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- <%@ page errorPage="error.jsp"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title><spring:message code="app.name"/></title>
</head>
<body>
	<h2><spring:message code="accion.mostrar.juego"/></h2>

	<table>
		<tr>
			<th><spring:message code="juego.titulo"/></th>
			<td>${item.titulo}</td>
		</tr>
		<tr>
			<th><spring:message code="juego.categoria"/></th>
			<td><a href="listarPorCategoria?idCategoria=${item.categoria.idCategoria}">${item.categoria.nombre}</a></td>
		</tr>
		<tr>	
			<th><spring:message code="juego.plataforma"/></th>
			<td><a href="listarPorPlataforma?idPlataforma=${item.plataforma.idPlataforma}">${item.plataforma.nombre}</a></td>
		</tr>
		<tr>	
			<th><spring:message code="juego.fechaLanzamiento"/></th>
			<td><fmt:formatDate value="${item.fechaLanzamiento}" pattern="dd-MM-yyyy"/></td>	
		</tr>
		<tr>	
			<th><spring:message code="juego.descripcion"/></th>
			<td>${item.descripcion}</td>
			
		</tr>
		
			
				
				
				
		
		
	</table>
	<br>
	${msg}
	<br>
	<a href="inicio"><spring:message code="accion.inicio"/></a>
</body>
</html>