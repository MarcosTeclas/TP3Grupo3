package controller.promociones;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.DAOFactory;
import services.promociones.ComprarPromocionService;

@WebServlet("/comprar.do")
public class ComprarPromocionServlet extends HttpServlet{

	private static final long serialVersionUID = 4347308040695405878L;
	private ComprarPromocionService comprarPromocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.comprarPromocionService = new ComprarPromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer promocionId = Integer.parseInt(request.getParameter("id"));
		
		/*Usuario usuario = (Usuario) request.getSession().getAttribute("user");
		Map<String, String> errors = comprarPromocionService.comprar(usuario.getId(), atraccionId);
		
		Usuario usuario2 = DAOFactory.getUserDAO().findById(usuario.getId());
		request.getSession().setAttribute("usuario", usuario2);
	
		if(errors.isEmpty()) {
			request.setAttribute("flash", "¡Gracias por comprar!");
		}else {
			request.setAttribute("errors", errors);
			request.setAttribute("flash", "No se ha podido realizar la compra");
		}*/
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/promociones/promociones.do");
		dispatcher.forward(request, response);
	}

}
