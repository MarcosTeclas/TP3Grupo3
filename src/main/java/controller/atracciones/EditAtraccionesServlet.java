package controller.atracciones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.TipoDeAtraccion;
import services.AtraccionService;

@WebServlet("/atracciones/edit.do")
public class EditAtraccionesServlet extends HttpServlet {

	private static final long serialVersionUID = -1218727026712040920L;
	private AtraccionService atraccionService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Atraccion atraccion = atraccionService.find(id);
		request.setAttribute("atraccion", atraccion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/edit.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		Integer costo = Integer.parseInt(request.getParameter("costo"));
		Double tiempoNecesario = Double.parseDouble(request.getParameter("tiempoNecesario"));
		Integer cupoPersonas = Integer.parseInt(request.getParameter("cupoPersonas"));
		TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(request.getParameter("tipoAtraccion"));

		Atraccion atraccion = atraccionService.update(id, nombre, costo, tiempoNecesario, cupoPersonas, tipoAtraccion);

		if (atraccion.isValid()) {
			response.sendRedirect("/turismo/atracciones/index.do");
		} else {
			request.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/edit.jsp");
			dispatcher.forward(request, response);
		}
	}


	

}