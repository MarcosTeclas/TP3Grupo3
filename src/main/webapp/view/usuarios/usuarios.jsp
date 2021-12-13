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



		<c:if test="${!usuario.isAdmin()}">
			<div class="bg-light p-4 rounded my-5 text-center">
			<h1>
				Lo siento, tiene que ser administrador para ver esta página!
			</h1>
		</div >
		<div><img class="mx-auto d-block" alt="" src=""></div> <!-- Colocar una imagen relacionada -->
		</c:if>
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
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td><strong><c:out value="${usuario.nombre}"></c:out></strong></td>
						<td><c:out value="${usuario.dinero}"></c:out></td>
						<td><c:out value="${usuario.tiempo}"></c:out></td>
						<td>
						<c:out value="${usuario.itinerario}"></c:out>
						
						</td>
						
						<td><c:if test="${usuario.admin}">
								<a href="editarUsuario.do?id=${usuario.id}" class="btn btn-light"
									role="button">Editar</a>
								<a href="borrarUsuario.do?id=${usuario.id}"
									class="btn btn-danger rounded" role="button">Eliminar</a>
							</c:if> </td>
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