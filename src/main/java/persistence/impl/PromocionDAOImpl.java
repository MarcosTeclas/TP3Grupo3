package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Atraccion;
import model.PromoAbsoluta;
import model.PromoAxB;
import model.PromoPorcentual;
import model.Promocion;
import model.TipoDeAtraccion;
import persistence.MissingDataException;
import persistence.PromocionDAO;
import persistence.jdbc.ConnectionProvider;

public class PromocionDAOImpl implements PromocionDAO {

	public int insert(Promocion promocion) {
		try {
			String sql = "INSERT INTO PROMOCIONES (NOMBRE, TIPO_ATRACCION, COSTO, ATRACCION_GRATUITA, DESCUENTO) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, promocion.getNombre());
			statement.setString(2, promocion.getTipo().toString());

			if (promocion.getNombre().equals("PromoAbsoluta")) {
				statement.setDouble(3, promocion.getCosto());
			}

			statement.setInt(4, promocion.getAtraccionesIncluidas().get(1).getId());

			if (promocion.getNombre().equals("PromoPorcentual")) {
				statement.setDouble(5, promocion.getCosto());
			}

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Promocion promocion) {

		try {
			String sql = "UPDATE PROMOCIONES SET NOMBRE = ?, TIPO_ATRACCION = ?, COSTO = ?, ATRACCION_GRATUITA = ?, DESCUENTO= ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, promocion.getNombre());
			statement.setString(2, promocion.getTipo().name());

			if (promocion.getNombre().equals("PromoAbsoluta")) {
				statement.setDouble(3, promocion.getCosto());
			}
			
			statement.setInt(4, promocion.getAtraccionesIncluidas().get(1).getId());

			if (promocion.getNombre().equals("PromoPorcentual")) {
				statement.setDouble(5, promocion.getCosto());
			}
			
			statement.setInt(6, promocion.getId());
			
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	/*
	 * List<Atraccion> atraccionesIncluidas = promocion.getAtraccionesIncluidas();
	 * int rows = 0; AtraccionDAOImpl atraccionDao = new AtraccionDAOImpl();
	 * 
	 * for (Atraccion atraccion : atraccionesIncluidas) { rows =
	 * atraccionDao.update(atraccion); } return rows; }
	 */

	public int delete(Promocion promocion) {
		try {
			String sql = "DELETE FROM PROMOCIONES WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, promocion.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Promocion findById(int id) {
		try {
			String sql = "SELECT * FROM PROMOCIONES WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Promocion promocion = null;

			if (resultados.next()) {
				if (resultados.getInt(1) == 1) {
					promocion = toPromoPorcentual(resultados);
				} else if (resultados.getInt(1) == 2) {
					promocion = toPromoAbsoluta(resultados);
				} else if (resultados.getInt(1) == 3) {
					promocion = toPromoAxB(resultados);
				}
			}

			return promocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM PROMOCIONES";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Promocion> findAll() {
		try {
			String sql = "SELECT * FROM PROMOCIONES";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Promocion> promociones = new ArrayList<Promocion>();
			while (resultados.next()) {
				if (resultados.getInt(1) == 1) {
					promociones.add(toPromoPorcentual(resultados));
				} else if (resultados.getInt(1) == 2) {
					promociones.add(toPromoAbsoluta(resultados));
				} else if (resultados.getInt(1) == 3) {
					promociones.add(toPromoAxB(resultados));
				}
			}

			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private List<Atraccion> atraccionesIncluidas(int idPromocion) {
		try {
			String sql = "SELECT ATRACCIONES.ID FROM PROMOCIONES JOIN ATRACCIONES_PROMOCIONES ON ATRACCIONES_PROMOCIONES.PROMOCION_ID"
					+ " = PROMOCIONES.ID JOIN ATRACCIONES ON ATRACCIONES.ID = ATRACCIONES_PROMOCIONES.ATRACCION_ID WHERE "
					+ "PROMOCIONES.ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idPromocion);
			ResultSet resultados = statement.executeQuery();

			List<Atraccion> atraccionesIncluidas = new ArrayList<Atraccion>();
			AtraccionDAOImpl atraccionDAO = new AtraccionDAOImpl();

			while (resultados.next()) {
				Atraccion atraccion = atraccionDAO.findById(resultados.getInt(1));
				atraccionesIncluidas.add(atraccion);
			}
			return atraccionesIncluidas;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Promocion toPromoPorcentual(ResultSet resultados) throws SQLException {
		Promocion promocionPorcentual = new PromoPorcentual(resultados.getInt(1), resultados.getString(2),
				TipoDeAtraccion.valueOf(resultados.getString(3)), resultados.getInt(6), this.atraccionesIncluidas(1));
		return promocionPorcentual;
	}

	private Promocion toPromoAbsoluta(ResultSet resultados) throws SQLException {
		Promocion promocionAbsoluta = new PromoAbsoluta(resultados.getInt(1), resultados.getString(2),
				TipoDeAtraccion.valueOf(resultados.getString(3)), resultados.getDouble(4),
				this.atraccionesIncluidas(2));
		return promocionAbsoluta;
	}

	private Promocion toPromoAxB(ResultSet resultados) throws SQLException {
		Promocion promocionAxB = new PromoAxB(resultados.getInt(1), resultados.getString(2),
				TipoDeAtraccion.valueOf(resultados.getString(3)), this.atraccionesIncluidas(3));
		return promocionAxB;
	}

}