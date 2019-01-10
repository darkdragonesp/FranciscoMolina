<%--
  Muestra la lista de categorías
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page errorPage="error.jsp"%>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<%-- Lista de Juegos de un Usuario --%>
<h2>
	<spring:message code="accion.listar.juegos.usuario" />
</h2>
<!-- 	Mensaje de información -->
<jsp:include page="${raiz}/tiles/mensaje.jsp" />
<c:choose>
	<c:when test="${empty listaCategorias}">
		<spring:message code="mensaje.juego.usuario.vacio" />
		<a href="${raiz}/categoria/list"><spring:message
				code="accion.listar.juegos" /></a>
	</c:when>
	<c:otherwise>
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>

					<th><spring:message code="juego.categoria" /></th>
					<th><spring:message code="accion.editar" /></th>
					<th><spring:message code="accion.borrar" /></th>
				</tr>
			</thead>
			</tbody>
			<c:forEach items="${listaCategorias}" var="item">
				<tr>
					<td>${item.nombre}</td>
					<td><a href="${raiz}/categoria/${item.idCategoria}/edit">
							<i class="material-icons">edit</i>
					</a></td>
					<td><a href="${raiz}/categoria/${item.idCategoria}/delete"
						onclick="return window.confirm('<spring:message code="accion.confirmar.borrar"/>')">
							<i class="material-icons">delete_forever</i>
					</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>

<a class="nav-link" href="${raiz}/inicio"><spring:message
		code="accion.inicio" /></a>
