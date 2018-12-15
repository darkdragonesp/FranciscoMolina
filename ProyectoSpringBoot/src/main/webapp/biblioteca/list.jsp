<%--
  Muestra los datos de los juegos seguidos por un usuario
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page errorPage="error.jsp"%>


	<%-- Lista de Juegos de un Usuario --%>
	<h2>
		<spring:message code="accion.listar.juegos.usuario" />
	</h2>
	<c:choose>
		<c:when test="${empty listaJuegos}">
			<spring:message code="mensaje.juego.usuario.vacio" />
			<a href="${pageContext.request.contextPath}/juego/list"><spring:message
					code="accion.listar.juegos" /></a>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th><spring:message code="juego.titulo" /></th>
					<th><spring:message code="juego.categoria" /></th>
					<th><spring:message code="juego.plataforma" /></th>
					<th><spring:message code="juego.fechaLanzamiento" /></th>
					<th><spring:message code="juego.descripcion" /></th>
				</tr>
				<c:forEach items="${listaJuegos}" var="item">
					<tr>
						<td><a
							href="${pageContext.request.contextPath}/${item.juego.idJuego}/juego/view">${item.juego.titulo}</a></td>
						<td><a
							href="${pageContext.request.contextPath}/juego/list/${item.juego.categoria.idCategoria}/categoria">${item.juego.categoria.nombre}</a></td>
						<td><a
							href="${pageContext.request.contextPath}/juego/list/${item.juego.plataforma.idPlataforma}/plataforma">${item.juego.plataforma.nombre}</a></td>
						<td><fmt:formatDate value="${item.juego.fechaLanzamiento}"
								pattern="dd-MM-yyyy" /></td>
						<td>${item.juego.descripcion}</td>
						<td><a
							href="${pageContext.request.contextPath}/${item.idJuegoUsuario}/juego/usuario/delete"
							onclick="return window.confirm('<spring:message code="accion.confirmar.borrar"/>')">
								<spring:message code="accion.borrar" />
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<br> ${msg}
	<br>
	<a href="${pageContext.request.contextPath}/inicio"><spring:message
			code="accion.inicio" /></a>
