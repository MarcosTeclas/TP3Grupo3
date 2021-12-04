<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link rel="stylesheet" href="assets/css/cssAtracciones.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs5/dt-1.11.3/datatables.min.css" />
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>


<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs5/dt-1.11.3/datatables.min.js"></script>
<title>TIerra Media</title>
</head>
<body>

	<!-- HEADER  -->
	<header class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Parque</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Atracciones</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Promociones</a>
						</li>

						<li class="nav-item"><a class="nav-link">Usuarios</a></li>
					</ul>
					<form class="d-flex">
						<img src="img/logo.png" width="48" alt="" />
					</form>
				</div>
			</div>
		</nav>
	</header>

	<!-- TABLE  -->
	<div class="table-responsive">
		<table class="table table-dark table-striped table-hover my-5">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nombre</th>
					<th scope="col">Tipo</th>
					<th scope="col">Tiempo</th>
					<th scope="col">Costo</th>
					<th scope="col">Cupo</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td>Moria</td>
					<td>Aventura</td>
					<td>2</td>
					<td>10</td>
					<td>6</td>
					<td></td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>Minas Tirith</td>
					<td>Paisaje</td>
					<td>2.5</td>
					<td>5</td>
					<td>25</td>
					<td></td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>La Comarca</td>
					<td>Degustación</td>
					<td>6.5</td>
					<td>3</td>
					<td>150</td>
					<td></td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td>Mordor</td>
					<td>Aventura</td>
					<td>3</td>
					<td>25</td>
					<td>4</td>
					<td></td>
				</tr>
				<tr>
					<th scope="row">5</th>
					<td>Abismo de Helm</td>
					<td>Paisaje</td>
					<td>2</td>
					<td>5</td>
					<td>15</td>
					<td></td>
				</tr>
				<tr>
					<th scope="row">6</th>
					<td>Lothlórien</td>
					<td>Degustacion</td>
					<td>1</td>
					<td>35</td>
					<td>30</td>
					<td></td>
				</tr>
				<tr>
					<th scope="row">7</th>
					<td>Erebor</td>
					<td>Paisaje</td>
					<td>3</td>
					<td>12</td>
					<td>32</td>
					<td></td>
				</tr>
				<tr>
					<th scope="row">8</th>
					<td>Bosque Negro</td>
					<td>Aventura</td>
					<td>4</td>
					<td>3</td>
					<td>12</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>