<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="assets/css/style.css" />
    <script
      defer
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      ="anonymous"
    ></script>
    <title>Login</title>
  </head>
  
  
  <body>
  
    <div class="container bg-primary my-5 rounded shadow" >
      <!--al container le puse w-75(que ocupe un 75% de la pagina ancho) y mt-5 para que no quede pegado de arriba y abajo y rounded para redondear las esquinas-->
      <div class="row align-items-stretch">
        <div
          class="col image d-none d-lg-block col-md-5 col-lg-5 col-xl-6 rounded"
        ></div>
        <!--aca configure el responsive-->
        <div class="col bg-white rounded-end">
          <div class="text-end mt-2">
            <!-- esta clase es para alinear el contenido hacia la izquierda-->
            <img src="img/logo.png" width="60" alt="Logo de la empresa" />
          </div>
          <h2 class="fw-bold text-center py-4 m">Bienvenidos a Tierra Media</h2>
          <!-- fw-bold es para poner negrita. pt-5 es padding-top y mb-5 es mb-5 es margin botton 5-->

          <!--LOGIN-->
          <c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>

          <form action="login" method="post">
            <div class="mb-4">
              <!-- un div con un mb-4 esta avisando que al contenido le pondra un margin botton de 4 px-->
              <label for="text" class="form-label">Usuario</label>
              <!-- Label es una etiqueta. for="" siempre tiene que coincidir con el nombre del imput type-->
              <input type="text" class="form-control" name="usuario"/><!--el input para que se pueda escribir-->
            </div>
            
            <!-- 
            <div class="mb-4">
              <label for="password" class="form-label">Contraseña</label>
              <!-- Label es una etiqueta. for="" siempre tiene que coincidir con el nombre del imput type-->
              <!--<input type="password" class="form-control" name="Password"
              /><!--el input para que se pueda escribir-->
            <!--</div>
				 -->
            <div class="d-grid mb-5">
              <!--d-grid es para que mi contenido ocupe toda la grilla disponible ( ancho de la pagina que le asigne )-->
              <button type="submit" class="btn btn-primary">Iniciar sesion</button>
            </div>
            <footer class="text-center italic">
                <span><i>Derechos reservados - Grupo 3 YoProgramo</i></span>
            </footer>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>