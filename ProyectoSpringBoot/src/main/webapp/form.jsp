<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.name"/></title>
</head>
<body>
	<form:form modelAttribute="producto" method="POST" action="guardar">
		<form:hidden path="id" />
		<table>
		<tr><td><spring:message code="producto.nombre"/></td><td><form:input path="nombre" /></td>
		<tr><td><spring:message code="producto.cantidad"/></td><td><form:input path="cantidad" /></td>
		<tr><td><spring:message code="producto.precio"/></td><td><form:input path="precio" /></td>
		<tr><td><spring:message code="producto.comentario"/></td><td><form:input path="comentario" /></td>
		<tr>
			<td><spring:message code="producto.fecha"/></td>
			<td>				
				<%-- Formato de fecha --%>
				<fmt:formatDate value="${producto.fecha}" pattern="dd/MM/yyyy" var="fecha"/>
				<form:input path="fecha" value="${fecha}"/>
			</td>
		<tr>
		<tr><td><spring:message code="producto.tipo"/></td><td><form:select path="tipo.id" items="${lista}" itemLabel="descripcion" itemValue="id"/></td></tr>
		<tr><td><input type="submit" value="<spring:message code="accion.guardar"/>"/></td></tr>
		</table>
	</form:form>
	<br>
	${msg}
	<br>
	<a href="listar"><spring:message code="accion.listar"/></a>
</body>
</html>