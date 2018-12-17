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


<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

	<h2>
		<spring:message code="accion.listar.juegos" />
	</h2>
	<%-- 	Filtrado de Juegos --%>
	<form:form class="form-inline input-group"  modelAttribute="juego" method="GET"
		action="${raiz}/juego/list/filter">
		<form:hidden path="idJuego" />
		

			<label for="titulo" class="sr-only">
				<spring:message code="juego.titulo" var="labTitulo"/>
			</label>
				<form:input path="titulo" class="form-control" placeholder="${labTitulo}"/>

			<label for="categoria.idCategoria" class="sr-only">
				<spring:message code="accion.elegir.categoria" var="labCategoria"/>
				</label>
				<form:select path="categoria.idCategoria" class="form-control">
						<form:option value="" >${labCategoria}</form:option>
						<form:options items="${listaCategorias}" itemLabel="nombre"
							itemValue="idCategoria" />
					</form:select>

				<label for="plataforma.idPlataforma" class="sr-only">
				<spring:message code="accion.elegir.plataforma" var="labCategoria"/>
				</label>
				<form:select path="plataforma.idPlataforma" class="form-control">
						<form:option value="">${labCategoria}</form:option>
						<form:options items="${listaPlataformas}" itemLabel="nombre"
							itemValue="idPlataforma" />
					</form:select>

				<input type="submit" class="btn btn-default" 
					value="<spring:message code="accion.filtrar"/>" />
				<input type="button" class="btn btn-default" onclick="window.location='${raiz}/juego/list'"
					value="<spring:message code="accion.limpiar"/>" />
					

	</form:form>
	<%-- Lista de Juegos --%>
	<c:choose>
		<c:when test="${empty listaJuegos}">
			<spring:message code="mensaje.juego.vacio" />
			<a href="${raiz}/juego/list"> <spring:message
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
							<td><a
								href="${raiz}/${item.idJuego}/juego/view">${item.titulo}</a></td>
							<td><a
								href="${raiz}/juego/list/${item.categoria.idCategoria}/categoria">${item.categoria.nombre}</a></td>
							<td><a
								href="${raiz}/juego/list/${item.plataforma.idPlataforma}/plataforma">${item.plataforma.nombre}</a></td>
							<td><fmt:formatDate value="${item.fechaLanzamiento}"
									pattern="dd-MM-yyyy" /></td>
									
							<td><span class="field-tip">
							    <div class=truncate>${item.descripcion}</div>
							    <span class="tip-content">${item.descripcion}</span>
								</span>  	
							</td>	
									
<%-- 							<td><div class=truncate>${item.descripcion}</div></td> --%>
	
							<td><a href="${raiz}/${item.idJuego}/juego/usuario/save">
									<i class="material-icons">create_new_folder</i>
							</a></td>
							
							<c:if test="${sessionUser.tipoUsuario.idTipo == 1}">
								<td><a href="${raiz}/${item.idJuego}/juego">
								<i class="material-icons">edit</i>
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
	<br> ${msg}
	<br>
	<a href="${raiz}/inicio"><spring:message
			code="accion.inicio" /></a>
