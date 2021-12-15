package controller.promociones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.PromoPorcentual;
import model.TipoDeAtraccion;
import persistence.DAOFactory;
import services.promociones.PromocionService;

@WebServlet("/crearPromoPorcentual.do")
public class CreatePromoPorcentualServlet extends HttpServlet {

	private static final long serialVersionUID = -4617006016953432868L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/promociones/crearPromoPorcentual.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(request.getParameter("tipo"));
		int descuento = Integer.parseInt(request.getParameter("descuento"));
		String[] atracciones = request.getParameterValues("lista");
		
		List<Atraccion> atraccionesIncluidas = new ArrayList<>();
		for (String atraccion : atracciones) {
			Atraccion a = DAOFactory.getAtraccionDAO().findByUsername(atraccion);
			if(a!=null) {
				atraccionesIncluidas.add(a);
			}			
		}				

		PromoPorcentual promocion = promocionService.create(nombre, tipoAtraccion, descuento, atraccionesIncluidas);

		if (promocion.isValid()) {
			response.sendRedirect("promociones.do");
		} else {
			request.setAttribute("promocion", promocion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/promociones/crearPromoPorcentual.jsp");
			dispatcher.forward(request, response);
		}
	}

}
