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

<!-- Ficha del juego -->
	<h2><spring:message code="accion.mostrar.juego"/></h2>

	<table>
		<tr>
			<th><spring:message code="juego.titulo"/></th>
			<td>${juego.titulo}</td>
		</tr>
		<tr>
			<th><spring:message code="juego.categoria"/></th>
			<td><a href="listarPorCategoria?idCategoria=${juego.categoria.idCategoria}">${juego.categoria.nombre}</a></td>
		</tr>
		<tr>	
			<th><spring:message code="juego.plataforma"/></th>
			<td><a href="listarPorPlataforma?idPlataforma=${juego.plataforma.idPlataforma}">${juego.plataforma.nombre}</a></td>
		</tr>
		<tr>	
			<th><spring:message code="juego.fechaLanzamiento"/></th>
			<td><fmt:formatDate value="${juego.fechaLanzamiento}" pattern="dd-MM-yyyy"/></td>	
		</tr>
		<tr>	
			<th><spring:message code="juego.descripcion"/></th>
			<td>${juego.descripcion}</td>
			
		</tr>

	</table>
	<br>

	
	<h3><spring:message code="juego.analisis"/></h3>
<!-- 	Formulario para analisis -->
	<form:form modelAttribute="analisis" method="POST" action="guardarAnalisis">
		<input type="hidden" name="idJuego" value="${juego.idJuego}"/>
		<form:hidden path="juego.idJuego" value="${juego.idJuego}"/>
		<form:hidden path="usuario.idUsuario" value="${usuario.idUsuario}"/>
		<table>
		
		<tr><td><spring:message code="juego.analisis.nota"/> (0-100)</td>
			<td><form:input path="nota" type="number" min="0" max="100" step="1" required="required"/></td>
			<td><form:errors path="nota" cssClass="error" /></td>
		</tr>
		
		<tr><td><spring:message code="juego.analisis.comentario"/></td>
			<td><form:textarea path="comentario" rows="8" cols="30" required="required"/></td>
			<td><form:errors path="comentario" cssClass="error" /></td>
		</tr>
			

		<tr><td><input type="submit" value="<spring:message code="accion.guardar"/>"/></td></tr>
		</table>
	</form:form>
		${msg}
	<br>
<!-- 	Lista de Analisis -->
<br>
	<table>
		<c:forEach items="${juego.analisis}" var="item">
			
				<tr>
					<th><spring:message code="juego.analisis.fechaAlta"/></th>
					<td><fmt:formatDate value="${item.fechaAlta}" pattern="dd-MM-yyyy hh:MM:ss"/></td>
					<th><spring:message code="usuario.autor"/></th>
					<td>${item.usuario.nombreUsuario}</td>
				</tr>
				<tr>
					<th><spring:message code="juego.analisis.nota"/></th>
					<td>${item.nota}</td>
				</tr>
		
				<tr>
					<th><spring:message code="juego.analisis.comentario"/></th>
					<td>${item.comentario}</td>
				</tr>
			
		</c:forEach>
	</table>
	
	<a href="inicio"><spring:message code="accion.inicio"/></a>
</body>
</html>