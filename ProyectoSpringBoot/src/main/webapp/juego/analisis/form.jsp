<%--
  Formulario para añadir nuevos análisis de juegos al sistema
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page errorPage="error.jsp"%>


	<h3>
		<spring:message code="juego.analisis" />
	</h3>

	<%-- 	Formulario para analisis --%>
	<form:form modelAttribute="analisis" method="POST"
		action="${pageContext.request.contextPath}/analisis/save">
		<form:hidden path="juego.idJuego" value="${juego.idJuego}" />
		<form:hidden path="usuario.idUsuario" value="${usuario.idUsuario}" />
		<table>

			<tr>
				<td><spring:message code="juego.analisis.nota" />(0-100)</td>
				<td><form:input path="nota" type="number" min="0" max="100"
						step="1" required="required" /></td>
				<td><form:errors path="nota" cssClass="error" /></td>
			</tr>

			<tr>
				<td><spring:message code="juego.analisis.comentario" /></td>
				<td><form:textarea path="comentario" required="required" /></td>
				<td><form:errors path="comentario" cssClass="error" /></td>
			</tr>

			<tr>
				<td><input type="submit"
					value="<spring:message code="accion.guardar"/>" /></td>
			</tr>
		</table>
		<form:errors cssClass="errorblock" element="div" />
	</form:form>
	${msg}
	<br>
	<a
		href="${pageContext.request.contextPath}/${analisis.juego.idJuego}/juego/view">
		<spring:message code="accion.volver" />
	</a>
	<a href="${pageContext.request.contextPath}/inicio"><spring:message
			code="accion.inicio" /></a>
