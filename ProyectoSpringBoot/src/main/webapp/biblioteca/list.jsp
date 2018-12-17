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

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<%-- Lista de Juegos de un Usuario --%>
<h2>
	<spring:message code="accion.listar.juegos.usuario" />
</h2>
<c:choose>
	<c:when test="${empty listaJuegos}">
		<spring:message code="mensaje.juego.usuario.vacio" />
		<a href="${raiz}/juego/list"><spring:message
				code="accion.listar.juegos" /></a>
	</c:when>
	<c:otherwise>
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th><spring:message code="juego.titulo" /></th>
					<th><spring:message code="juego.categoria" /></th>
					<th><spring:message code="juego.plataforma" /></th>
					<th><spring:message code="juego.fechaLanzamiento" /></th>
					<th><spring:message code="juego.descripcion" /></th>
					<th><spring:message code="accion.borrar" /></th>
				</tr>
			</thead>
			</tbody>
			<c:forEach items="${listaJuegos}" var="item">
				<tr>
					<td><a
						href="${raiz}/${item.juego.idJuego}/juego/view">${item.juego.titulo}</a></td>
					<td><a
						href="${raiz}/juego/list/${item.juego.categoria.idCategoria}/categoria">${item.juego.categoria.nombre}</a></td>
					<td><a
						href="${raiz}/juego/list/${item.juego.plataforma.idPlataforma}/plataforma">${item.juego.plataforma.nombre}</a></td>
					<td><fmt:formatDate value="${item.juego.fechaLanzamiento}"
							pattern="dd-MM-yyyy" /></td>
					<td><div class=truncate>${item.juego.descripcion}</div></td>
					<td><a
						href="${raiz}/${item.idJuegoUsuario}/juego/usuario/delete"
						onclick="return window.confirm('<spring:message code="accion.confirmar.borrar"/>')">
							<i class="material-icons">delete_forever</i>
					</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<br>
${msg}
<br>
<a href="${raiz}/inicio"><spring:message
		code="accion.inicio" /></a>
