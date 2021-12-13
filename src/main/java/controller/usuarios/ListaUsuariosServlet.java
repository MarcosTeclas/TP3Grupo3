package controller.usuarios;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.usuarios.UsuarioService;

@WebServlet("/usuarios.do")
public class ListaUsuariosServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -732723221736235305L;
	private UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Usuario> usuarios = usuarioService.list();
		request.setAttribute("usuarios", usuarios);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/usuarios/usuarios.jsp");
		dispatcher.forward(request, response);

}
}
