package controller.promociones;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.TipoDeAtraccion;
import services.promociones.PromocionService;

@WebServlet("/crearPromociones.do")
public class CreatePromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 7367639614719672088L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/promociones/crearPromosiones.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(request.getParameter("tipo"));
		List<Atraccion> atraccionesincluidas;// = request.getParameter("lista");
				

		//Promocion promocion = promocionService.create(nombre, costo, tiempoNecesario, cupoPersonas, tipoAtraccion);

		/*if (promocion.isValid()) {
			response.sendRedirect("promociones.do");
		} else {
			request.setAttribute("promocion", promocion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/promociones/create.jsp");
			dispatcher.forward(request, response);
		}*/
	}

}
