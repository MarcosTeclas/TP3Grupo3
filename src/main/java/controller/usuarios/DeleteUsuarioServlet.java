package controller.usuarios;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.usuarios.UsuarioService;

@WebServlet("/borrarUsuario.do")
public class DeleteUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -3628940327302197434L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
	
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		usuarioService.delete(id);
		
		response.sendRedirect("usuarios.do");
	
	}
}
