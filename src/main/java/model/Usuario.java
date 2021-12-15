package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import utils.Crypt;

public class Usuario {

	private int id;
	private String nombre;
	private TipoDeAtraccion preferida;
	private double dinero, tiempo;
	private List<Producto> itinerario;
	private String password;
	private HashMap<String, String> errors;
	private int admin;
	private int activo;

	public Usuario(int id, String nombre, TipoDeAtraccion preferencia, double dinero, double tiempo,
			List<Producto> itinerario, String password, int admin) {
		if (validaNumeros(dinero)) {
			this.dinero = dinero;
		} else {
			this.dinero = 0;
		}
		if (validaNumeros(tiempo)) {
			this.tiempo = tiempo;
		} else {
			this.tiempo = 0;
		}
		this.id = id;
		this.nombre = nombre;
		this.preferida = preferencia;
		this.itinerario = itinerario;
		this.password = password;
		this.admin = admin;
		this.activo = 1;
	}

	public Usuario(String nombre, TipoDeAtraccion preferencia, double dinero, double tiempo, List<Producto> itinerario,
			String password) {
		if (validaNumeros(dinero)) {
			this.dinero = dinero;
		} else {
			this.dinero = 0;
		}
		if (validaNumeros(tiempo)) {
			this.tiempo = tiempo;
		} else {
			this.tiempo = 0;
		}

	}

	public Usuario(String nombre, TipoDeAtraccion preferencia, double dinero, double tiempo, List<Producto> itinerario,
			String password, int admin) {
		if (validaNumeros(dinero)) {
			this.dinero = dinero;
		} else {
			this.dinero = 0;
		}
		if (validaNumeros(tiempo)) {
			this.tiempo = tiempo;
		} else {
			this.tiempo = 0;
		}

		this.nombre = nombre;
		this.preferida = preferencia;
		this.itinerario = itinerario;
		this.password = password;
		this.admin = admin;
		this.activo = 1;
	}

	public boolean isAdmin() {
		// retorna true si el admin es 1
		return admin == 1;
	}

	public int getId() {
		return id;
	}

	public TipoDeAtraccion getPreferida() {
		return preferida;
	}

	public void setPreferida(TipoDeAtraccion preferida) {
		this.preferida = preferida;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public void setItinerario(List<Producto> itinerario) {
		this.itinerario = itinerario;
	}

	public void setErrors(HashMap<String, String> errors) {
		this.errors = errors;
	}

	public String getNombre() {
		return nombre;
	}

	public double getDinero() {
		return dinero;
	}

	public double getTiempo() {
		return tiempo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipoDeAtraccion getAtraccionPreferida() {
		return preferida;
	}

	public List<Producto> getItinerario() {
		return itinerario;
	}

	// Validacion de Doubles positivos
	private boolean validaNumeros(double valor) {
		boolean confirmacion = false;
		if (valor < 0) {
			throw new NumberFormatException("El valor no puede ser negativo");
		} else {
			confirmacion = true;
		}
		return confirmacion;
	}

	public boolean puedeComprarProducto(Producto producto) {
		return puedePagar(producto) && tieneTiempo(producto) && !estaEnElItinerario(producto) && producto.hayCupo();
	}

	public boolean puedePagar(Producto producto) {
		return this.dinero >= producto.getCosto();
	}

	public boolean tieneTiempo(Producto producto) {
		return this.tiempo >= producto.getTiempoNecesario();
	}

	public void comprarProducto(Producto producto) {
		this.dinero -= producto.getCosto();
		this.tiempo -= producto.getTiempoNecesario();
		this.itinerario.add(producto);
		producto.restarCupo();
	}

	private boolean estaEnElItinerario(Producto producto) {
		boolean existe = false;
		Iterator<Producto> itr = this.itinerario.iterator();
		while (!existe && itr.hasNext()) {
			existe = producto.contiene(itr.next());
		}
		return existe;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", atracci�n preferida=" + preferida + ", dinero disponible=" + dinero
				+ ", tiempo disponible=" + tiempo + "]";
	}

	public boolean checkPassword(String password) {
		return Crypt.match(password, this.password);
	}

	public boolean isNull() {
		return false;
	}

	public boolean isValid() {
		validate();

		return errors.isEmpty();
	}

	public void validate() {

		errors = new HashMap<String, String>();

		if (nombre == null || nombre == "") {
			errors.put("nombre", "no debe estar vacío");
		}
		if (preferida == null) {
			errors.put("tipo de atracción preferida", "no debe estar vacío");
		}
		if (dinero <= 0) {
			errors.put("dinero", "debe ser positivo");
		}
		if (tiempo <= 0) {
			errors.put("tiempo", "debe ser positivo");
		}
		/*
		 * if(password == null || password == "") { errors.put("password",
		 * "no debe estar vacío"); }
		 */
	}

	public HashMap<String, String> getErrors() {
		return errors;
	}
	
	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	/*
	 * public static void main(String[] args) { List<Producto>productos=new
	 * ArrayList<>(); Usuario marcos = new
	 * Usuario("marcos",TipoDeAtraccion.AVENTURA,100,100,productos,"marcos");
	 * UserDAOImpl u = new UserDAOImpl(); u.insert(marcos);
	 * System.out.println(marcos.toString()); }
	 */
}