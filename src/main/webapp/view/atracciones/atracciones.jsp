<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/view/partials/head.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="/view/partials/nav.jsp"></jsp:include>

	<main class="container">

		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>



		<c:if test="${usuario.isAdmin()}">
			<div class="p-1 mb-7 my-3 hover">
				<a href="create.do" class="btn btn-primary shadow" role="button">
					<i class="bi bi-plus-lg"></i> Nueva Atracción
				</a>
			</div>
		</c:if>
		<table id="example"
			class="table table-stripped table-hover table-dark">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Tipo</th>
					<th>Costo</th>
					<th>Duracion</th>
					<th>Cupo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${atracciones}" var="attraction">
				<c:if test="${attraction.activa == 1}">
					<tr>
						<td><strong><c:out value="${attraction.nombre}"></c:out></strong></td>
						<td><c:out value="${attraction.tipo}"></c:out></td>
						<td><c:out value="${attraction.costo}"></c:out></td>
						<td><c:out value="${attraction.tiempoNecesario}"></c:out></td>
						<td><c:out value="${attraction.cupo}"></c:out></td>
						</c:if>
						<td><c:if test="${usuario.admin}">
								<a href="edit.do?id=${attraction.id}" class="btn btn-light"
									role="button">Editar</a>
								<a href="delete.do?id=${attraction.id}"
									class="btn btn-danger rounded" role="button">Eliminar</a>
							</c:if> <c:choose>
								<c:when
									test="${usuario.puedePagar(attraction) && usuario.tieneTiempo(attraction) && attraction.getCupo()>0}">
									<a href="/view/atracciones/comprar.do?id=${attraction.id}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button">No se puede comprar</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<footer>
			<div class="mt-5"></div>
		</footer>

	</main>

</body>
</html>