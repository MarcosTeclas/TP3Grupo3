<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="name" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" placeholder="Nombre de usuario" id="name" name="nombre" required
			value="${temp_usuario.nombre}">

	</div>
	<div class="mb-3">
		<label for="preferida"
			class='form-label ${temp_usuario.errors.get("preferida") != null ? "is-invalid" : "" }'>preferida</label>
		<select class="form-select" required name="preferida"
			aria-label="default select example" id="preferida">

			<option selected value="">Seleccione un tipo de atraccion</option>
			<option value="AVENTURA">AVENTURA</option>
			<option value="DEGUSTACION">DEGUSTACION</option>
			<option value="PAISAJE">PAISAJE</option>
		</select>
	</div>
	<div class="mb-3">
		<label for="dinero"
			class='col-form-label ${temp_usuario.errors.get("dinero") != null ? "is-invalid" : "" }'>dinero:</label>
		<input class="form-control" placeholder="Dinero disponible"
			type="number" min=0.5 step=0.5 id="dinero" name="dinero" required
			value="${temp_usuario.dinero}"></input>
		<div class="invalid-feedback">
			<c:out value='${temp_usuario.errors.get("dinero")}'></c:out>

		</div>
		
		
	</div>
	<div class="mb-3">
		<label for="tiempo"
			class='col-form-label ${temp_usuario.errors.get("tiempo") != null ? "is-invalid" : "" }'>tiempo:</label>
		<input class="form-control" placeholder="Tiempo disponible"
			type="number" min=0.5 step=0.5 id="tiempo" name="tiempo" required
			value="${temp_usuario.tiempo}"></input>
		<div class="invalid-feedback">
			<c:out value='${temp_usuario.errors.get("tiempo")}'></c:out>
		</div>
	</div>
	
	<div class="mb-3">
		<label for="admin"
			class='form-label ${temp_usuario.errors.get("admin") != null ? "is-invalid" : "" }'>admin</label>
		<select class="form-select" required name="admin"
			aria-label="default select example" id="admin">

			<option selected value="">Seleccione el nivel de usuario</option>
			<option value=1>admin</option>
			<option value=0>usuario</option>
		</select>
	</div>

</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
