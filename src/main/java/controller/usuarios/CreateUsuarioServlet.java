package controller.usuarios;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TipoDeAtraccion;
import model.Usuario;
import services.usuarios.UsuarioService;

@WebServlet("/create.do")
public class CreateUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 7190349227357954012L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/usuarios/create.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		TipoDeAtraccion tipoAtraccionPreferida = TipoDeAtraccion.valueOf(request.getParameter("tipo"));
		Double dinero = Double.parseDouble(request.getParameter("dinero"));
		Double tiempo = Double.parseDouble(request.getParameter("tiempo"));
		String password = request.getParameter("password");
		

		Usuario usuario = usuarioService.create(nombre, tipoAtraccionPreferida, dinero, tiempo, password);

		if (usuario.isValid()) {
			response.sendRedirect("usuarios.do");
		} else {
			request.setAttribute("usuario", usuario);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/usuarios/create.jsp");
			dispatcher.forward(request, response);
		}
	}

}
