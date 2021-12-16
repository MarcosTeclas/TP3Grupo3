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


		<c:choose>
			<c:when test="${!usuario.isAdmin()}">
				<div class="bg-light p-4 rounded my-5 text-center">
					<h1>Lo siento, tiene que ser administrador para ver esta
						página!</h1>
				</div>
			</c:when>
			<c:otherwise>
			<div class="p-1 mt-3">
					<a href="crearUsuario.do" class="btn btn-success shadow" role="button">
						<i class="bi bi-plus-lg"></i> Nuevo usuario
					</a>
				</div>

				<div>
					<img class="mx-auto d-block" alt="" src="">
				</div>
				<!-- Colocar una imagen relacionada -->

				<div class="mb-5"></div>
				<table id="example"
					class="table table-stripped table-hover table-dark my-5">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>monedas disponibles</th>
							<th>Tiempo disponible</th>
							<th>Promos y atracciones compradas</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${usuarios}" var="temp_usuario">
							<tr>
								<td><strong><c:out value="${temp_usuario.nombre}"></c:out></strong></td>
								<td><c:out value="${temp_usuario.dinero}"></c:out></td>
								<td><c:out value="${temp_usuario.tiempo}"></c:out></td>
								<td><c:out value="${temp_usuario.itinerario}"></c:out></td>

								<td><a href="editarUsuario.do?id=${temp_usuario.id}"
									class="btn btn-light" role="button">Editar</a> <a
									href="borrarUsuario.do?id=${temp_usuario.id}"
									class="btn btn-danger rounded" role="button">Eliminar</a> 
									</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>


		<footer>
			<div class="mt-5"></div>
		</footer>

	</main>

</body>
</html>