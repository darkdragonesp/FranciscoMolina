<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="app.name"/></title>
</head>
<body>
	<h2><spring:message code="accion.registrarse"/></h2>
	
	<form:form modelAttribute="usuario" method="POST" action="guardarUsuario">
		<table>
				<tr><th><spring:message code="usuario.nombre"/></th>
					<td><form:input path="nombreUsuario" required="required"/></td>
					<td><form:errors path="nombreUsuario" cssClass="error" /></td>
				</tr>
					
				<tr><th><spring:message code="usuario.correo"/></th>
					<td><form:input path="correo" type="email" required="required"/></td>
					<td><form:errors path="correo" cssClass="error" /></td>
				</tr>
				<tr><th><spring:message code="usuario.contrasena"/></th>
					<td><form:input path="contrasena" type="password" required="required"/></td>
					<td><form:errors path="contrasena" cssClass="error" /></td>
				</tr>
					
				<tr><td><input type="submit" value="<spring:message code="accion.registrar"/>"/></td></tr>
		</table>
	</form:form>
	<a href="inicio"><spring:message code="accion.inicio"/></a>
</body>
</html>