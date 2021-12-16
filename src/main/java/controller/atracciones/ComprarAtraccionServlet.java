package controller.atracciones;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.DAOFactory;
import services.atracciones.ComprarAtraccionService;

@WebServlet("/comprar.do")
public class ComprarAtraccionServlet extends HttpServlet{

	private static final long serialVersionUID = -4672823548806279662L;
	private ComprarAtraccionService comprarAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.comprarAtraccionService = new ComprarAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer atraccionId = Integer.parseInt(request.getParameter("id"));
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Map<String, String> errors = comprarAtraccionService.comprar(usuario.getId(), atraccionId);
		
		Usuario usuario2 = DAOFactory.getUserDAO().findById(usuario.getId());
		request.getSession().setAttribute("usuario", usuario2);
	
		if(errors.isEmpty()) {
			request.setAttribute("flash", "¡Gracias por comprar!");
		}else {
			request.setAttribute("errors", errors);
			request.setAttribute("flash", "No se ha podido realizar la compra");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/atracciones.do");
		dispatcher.forward(request, response);
	}

}
