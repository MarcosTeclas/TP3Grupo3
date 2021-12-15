package controller.atracciones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.atracciones.AtraccionService;

@WebServlet("/detalles.do")
public class DetallesAtraccionServlet extends HttpServlet {

	
	private static final long serialVersionUID = 7673388948368765381L;
	private AtraccionService atraccionService;

	/*@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}*/

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		String detalles = atraccionService.find(id).getDetalle();
		request.setAttribute("detalles", detalles);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/atracciones/detalles.jsp");
		dispatcher.forward(request, response);
	}

	/*@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		Double costo = Double.parseDouble(request.getParameter("costo"));
		Double tiempoNecesario = Double.parseDouble(request.getParameter("tiempoNecesario"));
		Integer cupoPersonas = Integer.parseInt(request.getParameter("cupo"));
		TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(request.getParameter("tipo"));
		String detalle = request.getParameter("detalle");

		Atraccion atraccion = atraccionService.create(nombre, costo, tiempoNecesario, cupoPersonas, tipoAtraccion, detalle);

		if (atraccion.isValid()) {
			response.sendRedirect("atracciones.do");
		} else {
			request.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/atracciones/create.jsp");
			dispatcher.forward(request, response);
		}
	}*/

}
