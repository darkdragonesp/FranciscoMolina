<%--
  Muestra los datos de un usuario y sus análisis
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page errorPage="error.jsp"%>


	<%-- Perfil de usuario --%>
	<h2>
		<spring:message code="usuario.perfil" />
	</h2>
	<table class="table table-bordered">
			<thead class="thead-dark">
			<tr>
				<th><spring:message code="usuario.nombre" /></th>
				<td>${usuario.nombreUsuario}</td>
			</tr>
			<tr>
				<th><spring:message code="usuario.correo" /></th>
				<td>${usuario.correo}</td>
			</tr>
			<tr>
				<th><spring:message code="usuario.tipoUsuario" /></th>
				<td>${usuario.tipoUsuario.nombre}</td>
			</tr>
			<tr>
				<th><spring:message code="usuario.fechaAlta" /></th>
				<td><fmt:formatDate value="${usuario.fechaAlta}"
						pattern="dd-MM-yyyy hh:mm:ss" /></td>
			</tr>
		</thead>
	</table>
	<br>
	<%-- 	Lista de Analisis --%>
	<h3>
		<spring:message code="juego.analisis" />
	</h3>
	<c:choose>
		<c:when test="${empty usuario.analisis}">
			<spring:message code="mensaje.analisis.vacio" />
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<thead class="thead-dark">
					<tr>
						<th><spring:message code="juego.analisis.fechaAlta" /></th>
						<th><spring:message code="juego.titulo" /></th>
						<th><spring:message code="juego.analisis.nota" /></th>
						<th><spring:message code="juego.analisis.comentario" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuario.analisis}" var="item">
						<tr>
							<td><fmt:formatDate value="${item.fechaAlta}"
									pattern="dd-MM-yyyy hh:MM:ss" /></td>
							<td><a
								href="${raiz}/${item.juego.idJuego}/juego/view">${item.juego.titulo}</a></td>
							<td>${item.nota}</td>
							<td>${item.comentario}</td>
							<td><a
								href="${raiz}/${item.idAnalisis}/analisis/delete"
								onclick="return window.confirm('<spring:message code="accion.analisis.confirmar"/>')">
									<spring:message code="accion.borrar" />
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>

	<br>
	<a href="${raiz}/inicio"> <spring:message
			code="accion.inicio" /></a>
