package controller.atracciones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.atracciones.AtraccionService;

@WebServlet("/detalles.do")
public class DetallesAtraccionServlet extends HttpServlet {

	
	private static final long serialVersionUID = 7673388948368765381L;
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
		
		Atraccion detalles = atraccionService.find(id);
		request.setAttribute("detalles", detalles);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/atracciones/detalles.jsp");
		dispatcher.forward(request, response);
	}

	
}
