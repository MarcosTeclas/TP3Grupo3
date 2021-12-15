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
import model.PromoAxB;
import model.PromoPorcentual;
import model.Promocion;
import model.TipoDeAtraccion;
import services.promociones.PromocionService;


@WebServlet("/editPromociones.do")
public class EditPromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 8643379155774311064L;
	private PromocionService promocionService;
	
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Promocion promocion = promocionService.find(id);
		request.setAttribute("promocion", promocion);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/promociones/edit.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(request.getParameter("tipo"));
		List<Atraccion> atraccionesIncluidas = new ArrayList<>();
		
		if(tipoAtraccion.name().equals("AVENTURA")) {

			Integer descuento = Integer.parseInt(request.getParameter("descuento"));
			
			PromoPorcentual promocion = promocionService.updatePromoPorcentual(id, nombre, tipoAtraccion, descuento, atraccionesIncluidas);
			
			if (promocion.isValid()) {
				response.sendRedirect("promociones.do");
			} else {
				request.setAttribute("promocion", promocion);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/promociones/edit.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		if(tipoAtraccion.name().equals("DEGUSTACION")) {
			Double costo = Double.parseDouble(request.getParameter("costo"));

			PromoAbsoluta promocion = promocionService.updatePromoAbsoluta(id, nombre, tipoAtraccion, costo, atraccionesIncluidas);
			
			if (promocion.isValid()) {
				response.sendRedirect("promociones.do");
			} else {
				request.setAttribute("promocion", promocion);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/promociones/edit.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		if(tipoAtraccion.name().equals("PAISAJE")) {

			PromoAxB promocion = promocionService.updatePromoAxB(id, nombre, tipoAtraccion, atraccionesIncluidas);
			
			if (promocion.isValid()) {
				response.sendRedirect("promociones.do");
			} else {
				request.setAttribute("promocion", promocion);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/promociones/edit.jsp");
				dispatcher.forward(request, response);
			}
		}

	}


	

}
