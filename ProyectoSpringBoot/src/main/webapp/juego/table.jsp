<%--
  Muestra los datos de los juegos del sistema
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page errorPage="error.jsp"%>


<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<%-- Lista de Juegos --%>
<c:choose>
	<c:when test="${empty listaJuegos}">
		<div id="tabla">
			<spring:message code="mensaje.juego.vacio" />
			<a href="javascript:listar()"> <spring:message
				code="accion.listar.juegos" /></a>
		</div>
	</c:when>
	<c:otherwise>
		<table class="table table-bordered" id="tabla">
			<thead class="thead-dark">
				<tr>
					<th><spring:message code="juego.titulo" /></th>
					<th><spring:message code="juego.categoria" /></th>
					<th><spring:message code="juego.plataforma" /></th>
					<th><spring:message code="juego.fechaLanzamiento" /></th>
					<th><spring:message code="juego.descripcion" /></th>
					<th><spring:message code="accion.agregar" /></th>
					<c:if test="${sessionUser.tipoUsuario.idTipo == 1}">
						<th><spring:message code="accion.editar" /></th>
						<th><spring:message code="accion.borrar" /></th>
					</c:if>
				</tr>
			</thead>
			</tbody>
			<c:forEach items="${listaJuegos}" var="item">
				<tr>
					<td><a href="${raiz}/${item.idJuego}/juego/view">${item.titulo}</a></td>
					<td><a
						href="${raiz}/juego/list/${item.categoria.idCategoria}/categoria">
							${item.categoria.nombre}</a></td>
					<td><a
						href="${raiz}/juego/list/${item.plataforma.idPlataforma}/plataforma">
							${item.plataforma.nombre}</a></td>
					<td><fmt:formatDate value="${item.fechaLanzamiento}"
							pattern="dd-MM-yyyy" /></td>

					<td align="center"><div class="iffyTip hideText">${item.descripcion}</div></td>

					<td><a href="${raiz}/${item.idJuego}/juego/usuario/save">
							<i class="material-icons">create_new_folder</i>
					</a></td>

					<c:if test="${sessionUser.tipoUsuario.idTipo == 1}">
						<td><a href="${raiz}/${item.idJuego}/juego"> <i
								class="material-icons">edit</i>
						</a></td>

						<td><a href="${raiz}/${item.idJuego}/juego/delete"
							onclick="return window.confirm('<spring:message code="accion.confirmar.borrar"/>')">
								<i class="material-icons">delete_forever</i>
						</a></td>
					</c:if>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>