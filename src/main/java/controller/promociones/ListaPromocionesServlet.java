package controller.promociones;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import services.promociones.PromocionService;


@WebServlet("/promociones.do")
public class ListaPromocionesServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -7126573066031200401L;
	private PromocionService promocionService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Promocion> promociones = promocionService.list();
		request.setAttribute("promociones", promociones);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/promociones/promociones.jsp");
		dispatcher.forward(request, response);
		}
}
