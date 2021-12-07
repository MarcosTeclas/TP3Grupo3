package controller.atracciones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.TipoDeAtraccion;
import services.AtraccionService;

public class CreateAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 5679272145659533649L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/create.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		Integer costo = Integer.parseInt(request.getParameter("costo"));
		Double tiempoNecesario = Double.parseDouble(request.getParameter("tiempoNecesario"));
		Integer cupoPersonas = Integer.parseInt(request.getParameter("cupoPersonas"));
		TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(request.getParameter("tipoAtraccion"));

		Atraccion atraccion = atraccionService.create(nombre, costo, tiempoNecesario, cupoPersonas, tipoAtraccion);

		if (atraccion.isValid()) {
			response.sendRedirect("/turismo/atracciones/index.do");
		} else {
			request.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/create.jsp");
			dispatcher.forward(request, response);
		}
	}

}
