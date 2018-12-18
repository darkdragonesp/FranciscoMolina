<%--
  Muestra los datos de un juego y sus análisis asociados. Permite añadir nuevos análisis
  
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
		<table class="table table-bordered custom-table">
			<thead class="thead-dark">
				<tr>
					<th><spring:message code="juego.titulo" /></th>
					<td>${juego.titulo}</td>
				</tr>
				<tr>
					<th><spring:message code="juego.categoria" /></th>
					<td><a
						href="${raiz}/juego/list/${juego.categoria.idCategoria}/categoria">${juego.categoria.nombre}</a></td>
				</tr>
				<tr>
					<th><spring:message code="juego.plataforma" /></th>
					<td><a
						href="${raiz}/juego/list/${juego.plataforma.idPlataforma}/plataforma">${juego.plataforma.nombre}</a></td>
				</tr>
				<tr>
					<th><spring:message code="juego.fechaLanzamiento" /></th>
					<td><fmt:formatDate value="${juego.fechaLanzamiento}"
							pattern="dd-MM-yyyy" /></td>
				</tr>
				<tr>
					<th><spring:message code="juego.descripcion" /></th>
					<td align="center"><div class="iffyTip hideText">${juego.descripcion}</div></td>
				</tr>
				<tr>
					<th><spring:message code="juego.analisis.notaMedia" /></th>
					<td>${notaMedia}</td>
				</tr>
				</thead>
	</table>

	<br>
	<h3>
		<spring:message code="juego.analisis" />
	</h3>
	<a
		href="${raiz}/analisis/save?idJuego=${juego.idJuego}"><spring:message
			code="accion.analisis.nuevo" /></a> ${msg}
	<br>
	<br>
	<c:choose>
		<%-- 	No existen análisis --%>
		<c:when test="${empty juego.analisis}">
			<spring:message code="mensaje.analisis.vacio" />
			<spring:message code="mensaje.analisis.nuevo" />
			<%-- 	Lista de Analisis --%>
		</c:when>
		<c:otherwise>
			
				<table class="table table-bordered">
				<thead class="thead-dark">
					<tr>
						<th><spring:message code="usuario.autor" /></th>
						<th><spring:message code="juego.analisis.fechaAlta" /></th>
						<th><spring:message code="juego.analisis.nota" /></th>
						
						<th><spring:message code="juego.analisis.comentario" /></th>
					</tr>
					</thead>
					
					<c:forEach items="${juego.analisis}" var="item">
						<tr>
							<td>${item.usuario.nombreUsuario}</td>
							<td><fmt:formatDate value="${item.fechaAlta}"
										pattern="dd-MM-yyyy HH:mm:ss" /></td>
										
							<td>${item.nota}</td>
							<td align="center"><div class="iffyTip hideText">${item.comentario}</div></td>
						</tr>
					</c:forEach>
					
				</table>
				<hr>
			
		</c:otherwise>
	</c:choose>
	<br>
	<a href="${raiz}/inicio"><spring:message
			code="accion.inicio" /></a>
