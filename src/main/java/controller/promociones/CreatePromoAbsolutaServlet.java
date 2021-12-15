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
import model.PromoAbsoluta;
import model.TipoDeAtraccion;
import persistence.DAOFactory;
import services.promociones.PromocionService;

@WebServlet("/crearPromoAbsoluta.do")
public class CreatePromoAbsolutaServlet extends HttpServlet {

	private static final long serialVersionUID = -6605815733192435020L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/promociones/crearPromoAbsoluta.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(request.getParameter("tipo"));
		Double costo = Double.parseDouble(request.getParameter("costo"));
		String[] atracciones = request.getParameterValues("lista");
		
		List<Atraccion> atraccionesIncluidas = new ArrayList<>();
		for (String atraccion : atracciones) {
			Atraccion a = DAOFactory.getAtraccionDAO().findByUsername(atraccion);
			if(a!=null) {
				atraccionesIncluidas.add(a);
			}			
		}				

		PromoAbsoluta promocion = promocionService.createPromoAbsoluta(nombre, tipoAtraccion, costo, atraccionesIncluidas);

		if (promocion.isValid()) {
			response.sendRedirect("promociones.do");
		} else {
			request.setAttribute("promocion", promocion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/promociones/crearPromoAbsoluta.jsp");
			dispatcher.forward(request, response);
		}
	}

}
