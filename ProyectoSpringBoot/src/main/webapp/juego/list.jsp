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

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><spring:message code="app.name" /></title>
</head>
<body>

	<h2>
		<spring:message code="accion.listar.juegos" />
	</h2>
	<%-- 	Filtrado de Juegos --%>
	<form:form modelAttribute="juego" method="GET"
		action="${pageContext.request.contextPath}/juego/filter">
		<form:hidden path="idJuego" />
		<table>

			<tr>
				<td><spring:message code="juego.titulo" /></td>
				<td><form:input path="titulo" /></td>


				<td><spring:message code="juego.categoria" /></td>
				<td><form:select path="categoria.idCategoria">
						<form:option value="">&nbsp;</form:option>
						<form:options items="${listaCategorias}" itemLabel="nombre"
							itemValue="idCategoria" />
					</form:select></td>

				<td><spring:message code="juego.plataforma" /></td>
				<td><form:select path="plataforma.idPlataforma">
						<form:option value="">&nbsp;</form:option>
						<form:options items="${listaPlataformas}" itemLabel="nombre"
							itemValue="idPlataforma" />
					</form:select></td>

				<td><input type="submit"
					value="<spring:message code="accion.filtrar"/>" /></td>
				<td><input type="reset"
					value="<spring:message code="accion.limpiar"/>" /></td>
			</tr>
		</table>

	</form:form>
	<%-- Lista de Juegos --%>
	<c:choose>
		<c:when test="${empty listaJuegos}">
			<spring:message code="mensaje.juego.vacio" />
			<a href="${pageContext.request.contextPath}/juego/list"> <spring:message
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
							href="${pageContext.request.contextPath}/${item.idJuego}/juego/view">${item.titulo}</a></td>
						<td><a
							href="${pageContext.request.contextPath}/juego/list/${item.categoria.idCategoria}/categoria">${item.categoria.nombre}</a></td>
						<td><a
							href="${pageContext.request.contextPath}/juego/list/${item.plataforma.idPlataforma}/plataforma">${item.plataforma.nombre}</a></td>
						<td><fmt:formatDate value="${item.fechaLanzamiento}"
								pattern="dd-MM-yyyy" /></td>
						<td>${item.descripcion}</td>

						<td><a
							href="${pageContext.request.contextPath}/guardarJuegoUsuario?idJuego=${item.idJuego}
							&idCategoria=${param.idCategoria}
							&idPlataforma=${param.idPlataforma}">
								<spring:message code="accion.agregar" />
						</a></td>
						<td><a
							href="${pageContext.request.contextPath}/${item.idJuego}/juego"><spring:message
									code="accion.editar" /></a></td>

						<td><a
							href="${pageContext.request.contextPath}/${item.idJuego}/juego/delete
							?idCategoria=${param.idCategoria}
							&idPlataforma=${param.idPlataforma}"
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
</body>
</html>