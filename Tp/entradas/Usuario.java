package entradas;

import java.sql.Array;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dao.AtraccionDAOSQLite;
import dao.GenericDAO;
import dao.UserDAOSQLite;

public class Usuario extends AtraccionDAOSQLite {

	private String nombre;
	public double tiempoDisp;
	public double dineroDisp;
	protected List<Atracciones> atraccionAceptada = new LinkedList<Atracciones>();
	protected List<Promociones> promocionAceptada = new LinkedList<Promociones>();
	Scanner entradaEscaner = new Scanner(System.in);
	public String respuesta;
	UserDAOSQLite user;


	public Usuario() {
		this.setNombre();
		this.setTiempoDisp();
		this.setDineroDisp();
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", tiempoDisp=" + tiempoDisp + ", dineroDisp=" + dineroDisp
				+ ", atraccionAceptada=" + atraccionAceptada + ", promocionAceptada=" + promocionAceptada + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre() {
		System.out.println("Ingrese Nombre del Usuario");
		String nombre = entradaEscaner.nextLine();
		
		this.nombre = nombre;
	}

	public List<Atracciones> getAtraccionesAceptadas() {
		return atraccionAceptada;
	}
	
	public String getNombresAtraccionesAceptadas(){
		String nombres = "";
		for (Atracciones atracciones : atraccionAceptada) {
			nombres = nombres + atracciones.getNombre() + " , ";
		}
		
		return nombres;
	}

	public double getTiempoDisp() {
		return tiempoDisp;
	}

	public void setTiempoDisp() {
		System.out.println("ingrese Tiempo Disponible");
		this.tiempoDisp = entradaEscaner.nextDouble();
	}

	public double getDineroDisp() {
		return dineroDisp;
	}

	public void setDineroDisp() {
		System.out.println("Ingrese dinero disponible");
		this.dineroDisp = entradaEscaner.nextDouble();
	}

	public boolean sugerenciaAtraccion(Atracciones sugerencia) {
		boolean band = true;
		boolean band1 = false;

		int variable = 0;
		
		for (Atracciones atraccion : atraccionAceptada) {
			if (sugerencia.getID() == atraccion.getID()) {
				band = false;
			}
		}
			if ((sugerencia.getCupo() > 0) && (this.dineroDisp >= sugerencia.getCosto())
					&& (this.tiempoDisp >= sugerencia.getTiempo())) {
				band1 = true;
			}
		if(band1==true && band==true) {
			return true;
		} else
		return false;
	}

	public void atraccionesSeleccionadas(Atracciones sugerencia) throws SQLException {
		this.tiempoDisp -= sugerencia.getTiempo();
		sugerencia.restarCupo();
		this.update(sugerencia.getID());
		System.out.println("Duracion Hs: " + sugerencia.getTiempo());
		System.out.println("Tiempo disponible: " + this.tiempoDisp);
		this.dineroDisp -= sugerencia.getCosto();
		System.out.println("Costo de Atraccion " + sugerencia.getCosto());
		System.out.println("Saldo disponible: $ " + this.dineroDisp);
		this.atraccionAceptada.add(sugerencia);
	}

	public boolean compararAtraccionPromocion(int[] atraccionesID) {
		List<Atracciones> atraccionesEnPromocion = getAtracciones(atraccionesID);
		boolean respuesta = true;
		for (Atracciones atraccion : atraccionesEnPromocion) {
			if (this.atraccionAceptada.contains(atraccion)) {
				respuesta = false;
			}
		}
		return respuesta;
	}

	public boolean sugerenciaPromocion(Promociones sugerencia) {
		if (this.getDineroDisp() >= sugerencia.getSumaCosto() && this.getTiempoDisp() >= sugerencia.getSumaDuracion()
				&& sugerencia.getCupo() && compararAtraccionPromocion(sugerencia.getAtraccionesID())) {
			return true;
		}
		return false;

	}

	public List<Atracciones> getAtracciones(int[] atraccionesID) {
		List<Atracciones> Mostrar_Atracciones = new LinkedList<Atracciones>();
		for (int ID : atraccionesID) {
			for (Atracciones IDatraccion : App.atracciones) {
				if (ID == IDatraccion.getID()) {
					Mostrar_Atracciones.add(IDatraccion);
				}
			}
		}
		return Mostrar_Atracciones;
	}

	public void elegirAtracciones(List<Atracciones> atracciones) throws SQLException {
		for (Atracciones atraccion : atracciones) {
			if (this.sugerenciaAtraccion(atraccion)) {
				System.out.println("Desea aceptar la " + atraccion.toString());
				System.out.print("S/N");
				respuesta = entradaEscaner.nextLine();
				if (respuesta.equals("S") || respuesta.equals("s")) {
					this.atraccionesSeleccionadas(atraccion);
					

				}
			}

		}
	}

	public void listarAtracciones(List<Atracciones> atraccionesDisp) throws SQLException {
		for (Atracciones atraccion : atraccionesDisp) {
			if (sugerenciaAtraccion(atraccion)) {
				System.out.println(atraccion.toString());
				System.out.println("Desea aceptar esta Atraccion? S/N");
				respuesta = entradaEscaner.next();
				if (respuesta.equals("S") || respuesta.equals("s")) {
					this.atraccionesSeleccionadas(atraccion);
					
					System.out.println(this.dineroDisp);
					System.out.println(this.tiempoDisp);
				}
			}
		}
	}

	public void elegirPromociones(Promociones promociones) throws SQLException {
		this.dineroDisp -= promociones.getSumaCosto();
		this.tiempoDisp -= promociones.getSumaDuracion();
		List<Atracciones> atraccionEnPromo = getAtracciones(promociones.getAtraccionesID());
		for (Atracciones atraccion : atraccionEnPromo) {
			atraccion.restarCupo();
			this.update(atraccion.getID());
			this.atraccionAceptada.add(atraccion);
		}
	}

	public void listarPromociones(List<Promociones> promociones) throws SQLException {
		for (Promociones promo : promociones) {
			if (this.sugerenciaPromocion(promo)) {
				System.out.println(promo.toString());
				System.out.print("");
				System.out.print(getAtracciones(promo.getAtraccionesID()));
				System.out.println("");
				System.out.println("Desea aceptar esta promocion? S/N");
				respuesta = entradaEscaner.next();
				if (respuesta.equals("S") || respuesta.equals("s")) {
					elegirPromociones(promo);
					this.promocionAceptada.add(promo);
					System.out.println(this.dineroDisp);
					System.out.println(this.tiempoDisp);
				}

			}
		}
	}

	@Override
	public List findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Atracciones atraccion) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
