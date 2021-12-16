<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- HEADER  -->
	
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
			<div class="container-fluid">
				<a class="navbar-brand" href="parque.jsp">Parque</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="atracciones.do">Atracciones</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="promociones.do">Promociones</a>
						</li>

						<li class="nav-item"><a class="nav-link" href="usuarios.do">Usuarios</a></li>
					</ul>
					<div class ="ps-2 bg-secondary text-ligth row p-2 text-center rounded">
					<div class="col-12 col-sm-4">Monedas de oro: <c:out value="${usuario.dinero}"></c:out></div>
					<div class="col-12 col-sm-4">Tiempo disponible: <c:out value="${usuario.tiempo}"></c:out></div>
					</div>
					
					<form class="d-flex p-3">
						<img src=https://i.ibb.co/nzDMzZ0/logo.png width="48" alt="" />
					</form>
				</div>
			</div>
		</nav>
	</header>
