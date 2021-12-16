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


@WebServlet("/editarUsuario.do")
public class EditUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -7568822069252259246L;
	private UsuarioService usuarioService;
	
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Usuario temp_usuario = usuarioService.find(id);
		request.setAttribute("temp_usuario", temp_usuario);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/usuarios/edit.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));	
		String nombre = request.getParameter("nombre");
		TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(request.getParameter("preferida"));
		Double dinero = Double.parseDouble(request.getParameter("dinero"));
		Double tiempo = Double.parseDouble(request.getParameter("tiempo"));
		int admin = Integer.parseInt(request.getParameter("admin"));
		//String password = request.getParameter("password");
		
		Usuario usuario = usuarioService.update(id, nombre, tipoAtraccion, dinero, tiempo, admin);

		if (usuario.isValid()) {
			if(usuario.getId() == ((Usuario)request.getSession().getAttribute("usuario")).getId()) {
				request.getSession().setAttribute("usuario", usuario);
			}
			response.sendRedirect("usuarios.do");
		} else {
			request.setAttribute("usuario", usuario);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/usuarios/edit.jsp");
			dispatcher.forward(request, response);
		}
	}


	

}
