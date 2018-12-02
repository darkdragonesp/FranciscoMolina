<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="app.name"/></title>
</head>
<body>
	<form:form modelAttribute="juego" method="POST" action="guardarJuego">
		<form:hidden path="idJuego" />
		<table>
		
		<tr><td><spring:message code="juego.titulo"/></td><td><form:input path="titulo" required="required"/></td>
		
		<tr><td><spring:message code="juego.categoria"/></td>
		<td><form:select path="categoria.idCategoria" items="${listaCategorias}" itemLabel="nombre" itemValue="idCategoria"/></td></tr>
		
		<tr><td><spring:message code="juego.plataforma"/></td>
		<td><form:select path="plataforma.idPlataforma" items="${listaPlataformas}" itemLabel="nombre" itemValue="idPlataforma"/></td></tr>
		
		<tr><td><spring:message code="juego.fechaLanzamiento"/></td>
			<td>				
				<%-- Formato de fecha --%>
				<fmt:formatDate value="${juego.fechaLanzamiento}" pattern="yyyy-MM-dd" var="fechaLanzamiento"/>
				<form:input path="fechaLanzamiento" value="${fechaLanzamiento}" type="date" required="required"/>
			</td>		

		<tr><td><spring:message code="juego.descripcion"/></td><td><form:textarea path="descripcion" rows="8" cols="30" /></td>
			

		<tr><td><input type="submit" value="<spring:message code="accion.guardar"/>"/></td></tr>
		</table>
	</form:form>
	<br>
	${msg}
	<br>
	<a href="listarJuegos"><spring:message code="accion.listar.juegos"/></a>
</body>
</html>