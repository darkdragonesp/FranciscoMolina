<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.name"/></title>
</head>
<body>
	<table>
		<tr>
			<th><spring:message code="producto.nombre"/></th>
			<th><spring:message code="producto.cantidad"/></th>
			<th><spring:message code="producto.fecha"/></th>
			<th><spring:message code="producto.tipo"/></th>
		</tr>
		<c:forEach items="${lista}" var="item">
			<tr>
				<td>${item.nombre}</td>
				<td>${item.cantidad}</td>
				<td>${item.fecha}</td>	
				<td>${item.tipo.descripcion}</td>
				<td><a href="buscar?id=${item.id}"><spring:message code="accion.editar"/></a></td>			
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="inicio"><spring:message code="accion.inicio"/></a>
</body>
</html>