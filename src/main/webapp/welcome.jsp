<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="view/partials/head.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="view/partials/nav.jsp"></jsp:include>

	<main class="container">
		<div class="bg-light p-4 rounded my-5 text-center">
			<h1>
				�Bienvenido, <c:out value="${usuario.nombre}" />!
			</h1>
		</div >
		<div><img class="mx-auto d-block" alt="" src="img/saludoanimado.png"></div>
	</main>
</body>
</html>