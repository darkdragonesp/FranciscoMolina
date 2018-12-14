<%--
  Muestra los datos de un juego y sus an�lisis asociados. Permite a�adir nuevos an�lisis
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page errorPage="error.jsp"%>


	<%-- Ficha del juego --%>
	<h2>
		<spring:message code="accion.mostrar.juego" />
	</h2>
	<table>
		<tr>
			<th><spring:message code="juego.titulo" /></th>
			<td>${juego.titulo}</td>
		</tr>
		<tr>
			<th><spring:message code="juego.categoria" /></th>
			<td><a
				href="${pageContext.request.contextPath}/juego/list/${juego.categoria.idCategoria}/categoria">${juego.categoria.nombre}</a></td>
		</tr>
		<tr>
			<th><spring:message code="juego.plataforma" /></th>
			<td><a
				href="${pageContext.request.contextPath}/juego/list/${juego.plataforma.idPlataforma}/plataforma">${juego.plataforma.nombre}</a></td>
		</tr>
		<tr>
			<th><spring:message code="juego.fechaLanzamiento" /></th>
			<td><fmt:formatDate value="${juego.fechaLanzamiento}"
					pattern="dd-MM-yyyy" /></td>
		</tr>
		<tr>
			<th><spring:message code="juego.descripcion" /></th>
			<td>${juego.descripcion}</td>
		</tr>
		<tr>
			<th><spring:message code="juego.analisis.notaMedia" /></th>
			<td>${notaMedia}</td>
		</tr>
	</table>

	<br>
	<h3>
		<spring:message code="juego.analisis" />
	</h3>
	<a
		href="${pageContext.request.contextPath}/analisis/save?idJuego=${juego.idJuego}"><spring:message
			code="accion.analisis.nuevo" /></a> ${msg}
	<br>
	<br>
	<c:choose>
		<%-- 	No existen an�lisis --%>
		<c:when test="${empty juego.analisis}">
			<spring:message code="mensaje.analisis.vacio" />
			<spring:message code="mensaje.analisis.nuevo" />
			<%-- 	Lista de Analisis --%>
		</c:when>
		<c:otherwise>
			<c:forEach items="${juego.analisis}" var="item">
				<table>
					<tr>
						<th><spring:message code="juego.analisis.fechaAlta" /></th>
						<td><fmt:formatDate value="${item.fechaAlta}"
								pattern="dd-MM-yyyy hh:MM:ss" /></td>
						<th><spring:message code="usuario.autor" /></th>
						<td>${item.usuario.nombreUsuario}</td>
					</tr>
					<tr>
						<th><spring:message code="juego.analisis.nota" /></th>
						<td>${item.nota}</td>
					</tr>
					<tr>
						<th><spring:message code="juego.analisis.comentario" /></th>
						<td>${item.comentario}</td>
					</tr>
				</table>
				<hr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<br>
	<a href="${pageContext.request.contextPath}/inicio"><spring:message
			code="accion.inicio" /></a>
